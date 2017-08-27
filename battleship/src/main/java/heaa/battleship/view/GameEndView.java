/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.view;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Pelin loppunäkymää mallintava luokka.
 *
 * @author heaarnio
 */
public class GameEndView {

    private JPanel mainPanel;

    public GameEndView() {
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
    }

    public void setGameStatistics(JPanel stats) {
        mainPanel.add(stats);
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public void setMainMenuButton(JButton mainMenu) {
        mainPanel.add(mainMenu);
    }
}
