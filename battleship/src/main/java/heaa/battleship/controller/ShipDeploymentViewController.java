package heaa.battleship.controller;

import heaa.battleship.model.AIPlayer;
import heaa.battleship.model.GameSettings;
import heaa.battleship.model.Grid;
import heaa.battleship.model.HumanPlayer;
import heaa.battleship.model.Player;
import heaa.battleship.model.Position;
import heaa.battleship.util.ShipBuilder;
import heaa.battleship.view.MainFrame;
import heaa.battleship.view.PositionView;
import heaa.battleship.view.ShipDeploymentView;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Stack;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class ShipDeploymentViewController implements Runnable {

    private final String HORIZONTAL = "Horizontal";
    private final String VERTICAL = "Vertical";

    private ShipDeploymentView shipDeployment;
    private ButtonGroup alignmentSelection;
    private Stack<Integer> ships;

    private GameInitializerController gameInitializerController;

    @Override
    public void run() {
        this.gameInitializerController = new GameInitializerController();
        this.gameInitializerController.startGame();
        GameSettings.getInstance().setHumanPlayer((HumanPlayer) gameInitializerController.getHumanPlayer());
        GameSettings.getInstance().setAiPlayer((AIPlayer) gameInitializerController.getAIPlayer());
        this.shipDeployment = new ShipDeploymentView();
        this.alignmentSelection = new ButtonGroup();
        this.ships = ShipBuilder.createStackOfShipLengths();
        createShipLengthText();
        createAlignmentButtons();
        createGrid(GameSettings.getInstance().getGridSize());
        MainFrame.getInstance().setPanelInView(shipDeployment.getMainPanel());

    }
    private void createShipLengthText() {
        String nextShipLenght;
        if (this.ships.empty()) {
            nextShipLenght = "All ships have been deployed.";
        } else {
            nextShipLenght = "Your next ship is " + ships.peek() + " squares long.";
        }
        this.shipDeployment.setShipLengthDisplayerText(nextShipLenght);
    }

    private void createGrid(int gridSize) {
        JPanel gridWrapper = new JPanel();
        gridWrapper.setLayout(new GridLayout(gridSize, gridSize));
        gridWrapper.setPreferredSize(new Dimension(500, 500));
        PositionView[][] playerGridPointer = new PositionView[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                PositionView positionView = new PositionView(i, j);
                playerGridPointer[i][j] = positionView;
                gridWrapper.add(positionView);
                positionView.addActionListener(action -> {
                    deployShip(positionView.getPosition());
                    shipDeployment.updateView(gameInitializerController.getHumanPlayer()
                            .getGrid().getNavy().getCombinedPositionsOfShips());
                    createShipLengthText();
                });
            }
        }
        this.shipDeployment.setGrid(gridWrapper);
        this.shipDeployment.setGridPointers(playerGridPointer);
    }

    private void deployShip(Position place) {
        try {
            System.out.println(place);
            Player humanPlayer = gameInitializerController.getHumanPlayer();
            Grid grid = humanPlayer.getGrid();
            Integer length = ships.peek();
            boolean horizontal = alignmentSelection.getSelection().getActionCommand().equals(HORIZONTAL);
            gameInitializerController.addShipToGrid(grid, place, length, horizontal);
            ships.pop();
            if (this.ships.empty()) {
                showStartGameButton();
            }
        } catch (RuntimeException e) {
            if (this.ships.empty()) {
                showErrorMessage("All ships have been deployed. Start battle!");
            } else {
                showErrorMessage("You can't set this ship here. Choose another location.");
            }
            
        }
    }

    private void showErrorMessage(String message) {
            JOptionPane.showMessageDialog(this.shipDeployment.getMainPanel(), message);
    }
    
    private void createAlignmentButtons() {
        JRadioButton horizontal = new JRadioButton(HORIZONTAL);
        horizontal.setSelected(true);
        horizontal.setActionCommand(HORIZONTAL);
        JRadioButton vertical = new JRadioButton(VERTICAL);
        vertical.setActionCommand(VERTICAL);
        alignmentSelection.add(horizontal);
        alignmentSelection.add(vertical);
        this.shipDeployment.setAlignmentRadioButtons(horizontal, vertical);
    }

    private void showStartGameButton() {
        JButton toBattle = new JButton("To battle!");
        this.shipDeployment.setToBattleButton(toBattle);
        toBattle.addActionListener((ActionEvent e) -> {
            GameSettings.getInstance().setHumanPlayer((HumanPlayer) this.gameInitializerController.getHumanPlayer());
            GameSettings.getInstance().setAiPlayer((AIPlayer) this.gameInitializerController.getAIPlayer());
            SwingUtilities.invokeLater(new NavyViewController());
        });
    }

}
