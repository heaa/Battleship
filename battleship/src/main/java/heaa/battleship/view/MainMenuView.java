package heaa.battleship.view;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * Luokka, joka mallintaa päävalikkoa.
 */
public class MainMenuView {

    private JPanel mainPanel;

    public MainMenuView() {
        this.mainPanel = new JPanel();
        setUpView();
    }

    private void setUpView() {
        mainPanel.setLayout(new GridBagLayout());
    }

    public void setChooseGridSizeText() {
        mainPanel.add(new JLabel("Choose size for the playing area: "));
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

    private String buildShipLengthString(Integer length) {
        return "Your next ship is " + length + " squares long.";
    }

}
