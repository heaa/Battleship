package heaa.battleship.view;

import heaa.battleship.model.GameSettings;
import heaa.battleship.model.Position;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.*;

/**
 * 
 * Luokka, joka hallinnoi pelitilan näkymää.
 */
public class NavyView {

    
    private JPanel mainPanel;
    private PositionView[][] humanGridPointers;
    private PositionView[][] aiGridPointers;
    
    
    public NavyView() {
        this.mainPanel = new JPanel();
        buildWindow();
        
    }
    
    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    private void buildWindow() {
        int gridSize = GameSettings.getInstance().getGridSize();
        mainPanel.setLayout(new FlowLayout());
    //    mainPanel.add(makeAPlayingArea("Computer", gridSize));
    //    mainPanel.add(makeAPlayingArea("Human", gridSize));
    }



    public void showAPlayingArea(JPanel area) {
        mainPanel.add(area);
    }
    
    public void showLabels(JPanel labels) {
        mainPanel.add(labels);
    }
    
    public void setHumanGridPointers(PositionView[][] humanGridPointers) {
        this.humanGridPointers = humanGridPointers;
    }
    
    public void setAiGridPointers(PositionView[][] aiGridPointers) {
        this.aiGridPointers = aiGridPointers;
    }
   
    public void updateView(List<Position> computerMissedPositions, List<Position> humanMissedPositions, List<Position> computerDestroyedPositions, List<Position> humanDestroyedPositions) {
        
        computerMissedPositions.forEach(position -> {
           aiGridPointers[position.getI()][position.getJ()].setBackground(Color.white);
        });
        humanMissedPositions.forEach(position -> {
           humanGridPointers[position.getI()][position.getJ()].setBackground(Color.white);
        });
        computerDestroyedPositions.forEach(position -> {
           aiGridPointers[position.getI()][position.getJ()].setBackground(Color.red);
        });        
        humanDestroyedPositions.forEach(position -> {
           humanGridPointers[position.getI()][position.getJ()].setBackground(Color.red);
        });
    } 
    
    public void displayHumanShips(List<Position> shipPositions) {
        shipPositions.forEach(position -> {
            humanGridPointers[position.getI()][position.getJ()].setBackground(Color.black);
        });
    }
}
