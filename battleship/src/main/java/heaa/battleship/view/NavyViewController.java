package heaa.battleship.view;

import heaa.battleship.controller.GameController;
import heaa.battleship.exception.AlreadyShotException;
import heaa.battleship.exception.GameEndedException;
import heaa.battleship.model.GameSettings;
import heaa.battleship.model.Grid;
import heaa.battleship.model.Player;
import heaa.battleship.model.Position;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Luokka, joka kontrolloi pelitilan mallintamista.
 *
 * @author heaarnio
 */
public class NavyViewController implements Runnable {

    private NavyView navyView;
    private GameController gameController;

    @Override
    public void run() {
        this.navyView = new NavyView();
        this.gameController = new GameController();
        int gridSize = GameSettings.getInstance().getGridSize();
        this.gameController.setComputer(GameSettings.getInstance().getAiPlayer());
        this.gameController.setHuman(GameSettings.getInstance().getHumanPlayer());
        buildLabels();
        makeAPlayingArea("Human", gridSize);
        makeAPlayingArea("Computer", gridSize);
        this.navyView.updateShipStatus(this.gameController.getHuman().getShipAmount(),
                this.gameController.getHuman().getShipAmount());
        showHumanShipsBlack();
        MainFrame.getInstance().setPanelInView(navyView.getMainPanel());
    }

    private void buildLabels() {
        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(1, 2));
        labels.setVisible(true);
        this.navyView.showLabels(labels);
    }

    private void makeAPlayingArea(String playerName, int gridSize) {
        JPanel area = new JPanel();
        JLabel shipAmountDisplay = new JLabel();
        area.setVisible(true);
        area.setLayout(new BoxLayout(area, BoxLayout.Y_AXIS));
        area.add(new Label(playerName));
        area.add(shipAmountDisplay);
        if(playerName.equals("Computer")) {
            this.navyView.setComputerShipAmountDisplayer(shipAmountDisplay);
        } else {
            this.navyView.setHumanShipAmountDisplayer(shipAmountDisplay);
        }
        area.add(makeAGrid(playerName, gridSize));
        this.navyView.showAPlayingArea(area);
    }

    private JPanel makeAGrid(String playerName, int gridSize) {
        PositionView[][] gridPointers = new PositionView[gridSize][gridSize];
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                PositionView positionView = new PositionView(i, j);
                if (playerName.equals("Computer")) {
                    positionView.addActionListener((ActionEvent a) -> {
                        try {
                            gameController.playTurn(positionView.getPosition());
                        } catch (AlreadyShotException e) {
                            displayErrorMessage(e.getMessage());
                        } catch (GameEndedException e) {
                            SwingUtilities.invokeLater(new GameEndViewController());
                        }
                        updateSituation();
                    });
                }
                grid.add(positionView);
                positionView.setVisible(true);
                gridPointers[i][j] = positionView;
            }
        }
        if (playerName.equals("Computer")) {
            navyView.setAiGridPointers(gridPointers);
        } else {
            navyView.setHumanGridPointers(gridPointers);
        }
        grid.setVisible(true);
        grid.setPreferredSize(new Dimension(500, 500));
        return grid;
    }

    private void showHumanShipsBlack() {
        Grid grid = GameSettings.getInstance().getHumanPlayer().getGrid();
        navyView.displayHumanShips(grid.getNavy().getCombinedPositionsOfShips());
    }

    private void updateSituation() {
        Player computer = this.gameController.getComputer();
        Player human = this.gameController.getHuman();

        List<Position> computerDestroyedPositions = computer.getGrid().getDestroyedShipPositions();
        List<Position> humanDestroyedPositions = human.getGrid().getDestroyedShipPositions();

        List<Position> computerMissedPositions = computer.getGrid().getMissedPositions();
        List<Position> humanMissedPositions = human.getGrid().getMissedPositions();

        this.navyView.updateView(computerMissedPositions, humanMissedPositions, computerDestroyedPositions, humanDestroyedPositions);
        this.navyView.updateShipStatus(human.getShipAmount(), computer.getShipAmount());
    }

    private void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this.navyView.getMainPanel(), message);
    }
}
