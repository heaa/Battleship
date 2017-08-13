
package heaa.battleship.view;

import heaa.battleship.model.Position;
import java.awt.Color;
import javax.swing.*;


public class PositionView extends JButton {
    
    private Position position;
    
    public PositionView(int i, int j) {
        super();
        this.createPosition(i, j);
        this.setUpForButtonLooks();
        this.addMouseListener(new ShootListener(position));
    }
    private void createPosition(int i, int j) {
        this.position = new Position(i, j);
    }
    private void setUpForButtonLooks() {
        this.setBorderPainted(true);
        this.setFocusPainted(true);
        this.setOpaque(true);
        this.setBackground(Color.blue);
    }
}
