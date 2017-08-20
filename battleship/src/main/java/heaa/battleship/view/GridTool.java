package heaa.battleship.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * 
 * Luokka, jonka avulla voi piirtää peliin ruudukon.
 */
public class GridTool {
    
    public static JPanel makeGrid(int gridSize, ActionListener actionListener) {
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                PositionView positionView = new PositionView(i, j);
                grid.add(positionView);
                positionView.setVisible(true);
            }
        }
        grid.setVisible(true);
        grid.setPreferredSize(new Dimension(500, 500));
        return grid;
    }
    
}
