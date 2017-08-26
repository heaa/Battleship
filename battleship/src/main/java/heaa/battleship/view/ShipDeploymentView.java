package heaa.battleship.view;

import heaa.battleship.model.Position;
import java.awt.Color;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ShipDeploymentView {
    
    private JPanel mainPanel;
    private JLabel shipLengthDisplayer;
    
    private PositionView[][] positionViewPointers;
    
    public ShipDeploymentView() {
        this.mainPanel = new JPanel();
        this.shipLengthDisplayer = new JLabel();
        this.mainPanel.add(shipLengthDisplayer);
    }
    
    public JPanel getMainPanel() {
        return this.mainPanel;
    }
    
    public void setGrid(JPanel gridWrapper) {
        this.mainPanel.add(gridWrapper);
    }
    
    public void setGridPointers(PositionView[][] positionViewPointers) {
        this.positionViewPointers = positionViewPointers;
    }
    
    public void updateView(List<Position> combinedShipPositions) {
        combinedShipPositions.forEach(position -> {
            positionViewPointers[position.getI()][position.getJ()].setBackground(Color.black);
        });
    }
    
    public void setAlignmentRadioButtons(JRadioButton horizontal, JRadioButton vertical) {
        mainPanel.add(horizontal);
        mainPanel.add(vertical);
    }
    public void setToBattleButton(JButton toBattle) {
        mainPanel.add(toBattle);
    }
    public void setShipLengthDisplayerText(String nextShipLength) {
        this.shipLengthDisplayer.setText(nextShipLength);
    }
}