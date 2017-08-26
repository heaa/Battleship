package heaa.battleship.view;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * Luokka, joka hallinnoi päävalikkoa ja laivojen asetusta.
 */

public class MainMenuView {

    private JPanel mainPanel;
    
    public MainMenuView() {
        this.mainPanel = new JPanel();
        setUpView();
    }

    private void setUpView() {
        mainPanel.setLayout(new FlowLayout());
    }
    
    public void setStartButton(JButton startButton) {
        mainPanel.add(startButton);
    }
    
    public void setExitButton(JButton exitButton) {
        mainPanel.add(exitButton);
    }
    
    public void setGridSizeRadioButtons(JRadioButton ten, JRadioButton twenty, JRadioButton thirty, JRadioButton forty) {
        mainPanel.add(ten);
        mainPanel.add(twenty);
        mainPanel.add(thirty);
        mainPanel.add(forty);
    }
    
    public JPanel getMainPanel() {
        return this.mainPanel;
    }
/*
    private void showSetShipsView() {
        this.ships = ShipBuilder.createStackOfShipLengths();
        this.hideButtons();
        GameSettings settings = gameInitializerController.getGameSettings();
        alignmentSelection = new ButtonGroup();
        JRadioButton vertical = new JRadioButton("Vertical");
        vertical.setActionCommand("vertical");
        vertical.setSelected(true);
        JRadioButton horizontal = new JRadioButton("Horizontal");
        horizontal.setActionCommand("horizontal");
        alignmentSelection.add(vertical);
        alignmentSelection.add(horizontal);
        this.add(new JLabel("Set your ships."));
        this.shipLengthDisplayer = new JLabel(buildShipLengthString(this.ships.peek()));
        this.add(shipLengthDisplayer);
        this.add(vertical);
        this.add(horizontal);
        drawGrid(settings.getGridSize());
    }
    */
    private String buildShipLengthString(Integer length) {
        return "Your next ship is " + length + " squares long.";
    }
/*
    private void hideButtons() {
        this.start.setVisible(false);
        this.exit.setVisible(false);
        this.ten.setVisible(false);
        this.twenty.setVisible(false);
        this.thirty.setVisible(false);
        this.forty.setVisible(false);
    }
*/
/*    private void CreateRadioButtons() {

        this.ten = new JRadioButton("10");
        ten.setSelected(true);
        ten.setActionCommand("10");

        this.twenty = new JRadioButton("20");
        twenty.setActionCommand("20");

        this.thirty = new JRadioButton("30");
        thirty.setActionCommand("30");

        this.forty = new JRadioButton("40");
        forty.setActionCommand("40");

    }
*/
 /*   private void addRadioButtonstoGroup() {
        this.gridSizeRadioButtons = new ButtonGroup();
        this.gridSizeRadioButtons.add(ten);
        this.gridSizeRadioButtons.add(twenty);
        this.gridSizeRadioButtons.add(thirty);
        this.gridSizeRadioButtons.add(forty);
    }
*/
  /*  private void addRadioButtonstoThisView() {
        this.add(ten);
        this.add(twenty);
        this.add(thirty);
        this.add(forty);
    }*/
    /*private void drawGrid(int gridSize) {
        this.grid = new PositionView[gridSize][gridSize];
        this.gridWrapper = new JPanel();
        gridWrapper.setLayout(new GridLayout(gridSize, gridSize));
        for(int i = 0; i < gridSize; i++) {
            for(int j = 0; j < gridSize; j++) {
                PositionView positionView = new PositionView(i, j);
                positionView.addActionListener((ActionEvent e) -> {
                    setShipToGrid(positionView.getPosition(), 
                            alignmentSelection.getSelection().getActionCommand().equals("horizontal"));
                });
                grid[i][j] = positionView;
                gridWrapper.add(positionView);
                positionView.setVisible(true);
            }
        }
        gridWrapper.setPreferredSize(new Dimension(500, 500));
        this.add(gridWrapper);
    }*/
    
   /* private void setShipToGrid(Position position, boolean horizontal) {
        try {
            Integer length = ships.peek();
            this.gameInitializerController.addShipToGrid(
                    this.gameInitializerController
                            .getHumanPlayer()
                            .getGrid(), position, length, horizontal);
            ships.pop();
            updateView();
        } catch(RuntimeException e) {
            JOptionPane.showMessageDialog(this, "You can't set ship here. Please choose other location.");
        }
    }*/
    
   /* private void updateView() {
        if(this.ships.size() > 0) {
            this.shipLengthDisplayer.setText(this.buildShipLengthString(this.ships.peek()));
        } else {
            this.shipLengthDisplayer.setText("All ships have been deployed.");
            showStartGameButton();
        }
        Grid playerGrid = this.gameInitializerController.getHumanPlayer().getGrid();
        Navy navy = playerGrid.getNavy();
        List<Position> shipPositions = navy.getCombinedPositionsOfShips();
        shipPositions.forEach(position -> {
           grid[position.getI()][position.getJ()].setBackground(Color.BLACK);
        });
    }*/
    
   
}
