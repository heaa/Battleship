/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * Luokka, joka toimii pelinäkymän keskusikkunana.
 */
public class MainFrame {

    private static JFrame mainWindow;
    private static JPanel panelInView;
    private static MainFrame mainFrame;

    private MainFrame() {
        mainWindow = new JFrame();
        mainWindow.setSize(1200, 600);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }

    public static MainFrame getInstance() {
        if (mainFrame == null) {
            mainFrame = new MainFrame();
        }
        return mainFrame;
    }

    public void setPanelInView(JPanel panel) {
        if (panelInView != null) {
            panelInView.setVisible(false);
        }
        panelInView = panel;
        panelInView.setVisible(true);
        mainWindow.add(panelInView);
    }
}
