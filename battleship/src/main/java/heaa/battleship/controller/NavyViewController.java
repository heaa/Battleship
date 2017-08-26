package heaa.battleship.controller;

import heaa.battleship.model.GameSettings;
import heaa.battleship.model.Grid;
import heaa.battleship.model.Player;
import heaa.battleship.model.Position;
import heaa.battleship.view.MainFrame;
import heaa.battleship.view.NavyView;
import heaa.battleship.view.PositionView;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

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
        area.setVisible(true);
        area.setLayout(new BoxLayout(area, BoxLayout.Y_AXIS));
        area.add(new Label(playerName));
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
                    positionView.addActionListener((ActionEvent e) -> {
                        gameController.playTurn(positionView.getPosition());
                        updateSituation();
                    });
                }
                grid.add(positionView);
                positionView.setVisible(true);
                gridPointers[i][j] = positionView;
            }
        }
        if(playerName.equals("Computer")) {
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
    }
}
