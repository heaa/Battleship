package heaa.battleship.view;

import heaa.battleship.model.Position;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShootListener implements MouseListener {
    
    private Position position;
    
    public ShootListener(Position position) {
        this.position = position;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(position);
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
