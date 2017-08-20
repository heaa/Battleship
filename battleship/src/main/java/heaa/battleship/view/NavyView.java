package heaa.battleship.view;


import heaa.battleship.controller.GameController;
import heaa.battleship.model.GameSettings;
import heaa.battleship.model.Player;
import heaa.battleship.model.Position;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;

/**
 * 
 * Luokka, joka hallinnoi pelitilan näkymää.
 */

public class NavyView extends JPanel {
    private PositionView[][] humanGrid;
    private PositionView[][] aiGrid;
    private GameController gameController;
    
    
    public NavyView() {
        buildWindow();
        this.gameController = new GameController();
        this.gameController.setComputer(GameSettings.getAiPlayer());
        this.gameController.setHuman(GameSettings.getHumanPlayer());
    }
    

    private void buildWindow() {
        int gridSize = GameSettings.getGridSize();
        this.setLayout(new FlowLayout());
        this.add(makeAPlayingArea("Computer", gridSize));
        this.add(makeAPlayingArea("Human", gridSize));
        this.add(buildLabels());
    }

    private JPanel makeAPlayingArea(String playerName, int gridSize) {
        JPanel area = new JPanel();
        area.setVisible(true);
        area.setLayout(new BoxLayout(area, BoxLayout.Y_AXIS));
        area.add(new Label(playerName));
        area.add(makeAGrid(playerName, gridSize));

        return area;
    }

    private JPanel makeAGrid(String playerName, int gridSize) {
        if (playerName.equals("Computer")) {
            this.aiGrid = new PositionView[gridSize][gridSize];
        } 
        if (playerName.equals("Human")) {
            this.humanGrid = new PositionView[gridSize][gridSize];
        }
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                PositionView positionView = new PositionView(i, j);
                if (playerName.equals("Computer")) {
                    this.aiGrid[i][j] = positionView;
                    positionView.addActionListener((ActionEvent e) -> {
                        this.gameController.playTurn(positionView.getPosition());
                        updateView();
                    });
                } else {
                    this.humanGrid[i][j] = positionView;
                }
                grid.add(positionView);
                positionView.setVisible(true);
            }
        }
        grid.setVisible(true);
        if (playerName.equals("Human")) {
            GameSettings.getHumanPlayer().getGrid()
                    .getNavy().getCombinedPositionsOfShips()
                    .forEach(position -> {
                        humanGrid[position.getI()][position.getJ()].setBackground(Color.gray);
                    });
        } 
        grid.setPreferredSize(new Dimension(500, 500));
        return grid;
    }

    private JPanel buildLabels() {
        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(1, 2));

        labels.setVisible(true);

        return labels;
    }
    private void updateView() {
        Player computer = this.gameController.getComputer();
        Player human = this.gameController.getHuman();
        
        List<Position> computerDestroyedPositions = computer.getGrid().getDestroyedShipPositions();
        List<Position> humanDestroyedPositions = human.getGrid().getDestroyedShipPositions();
        
        List<Position> computerMissedPositions = computer.getGrid().getMissedPositions();
        List<Position> humanMissedPositions = human.getGrid().getMissedPositions();
        
        computerMissedPositions.forEach(position -> {
           this.aiGrid[position.getI()][position.getJ()].setBackground(Color.white);
        });
        humanMissedPositions.forEach(position -> {
           this.humanGrid[position.getI()][position.getJ()].setBackground(Color.white);
        });
        computerDestroyedPositions.forEach(position -> {
           this.aiGrid[position.getI()][position.getJ()].setBackground(Color.red);
        });        
        humanDestroyedPositions.forEach(position -> {
           this.humanGrid[position.getI()][position.getJ()].setBackground(Color.red);
        });
    }
}
