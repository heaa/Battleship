package heaa.battleship.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class NavyView implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame();
        this.frame.setTitle("Battleship");
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        buildWindow();

    }

    private void buildWindow() {
        int gridSize = 10;
        frame.setLayout(new FlowLayout());
        frame.add(makeAPlayingArea("Computer", gridSize));
        frame.add(makeAPlayingArea("Human", gridSize));
        frame.add(buildLabels());
    }

    private JPanel makeAPlayingArea(String playerName, int gridSize) {
        JPanel area = new JPanel();
        area.setVisible(true);
        area.setLayout(new BoxLayout(area, BoxLayout.Y_AXIS));
        area.add(new Label(playerName));
        area.add(makeAGrid(gridSize));

        return area;
    }

    private JPanel makeAGrid(int gridSize) {
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

    private JPanel buildLabels() {
        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(1, 2));

        labels.setVisible(true);

        return labels;
    }
}
