/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.view;

import javax.swing.JFrame;

/**
 *
 * Luokka, joka toimii pelinäkymien hallinnoijana.
 */
public class MainFrame implements Runnable {

    private static JFrame mainWindow;
    private static MainMenuView mainMenuView;
    private static NavyView navyView;
    
    @Override
    public void run() {
        mainWindow = new JFrame();
        mainWindow.setSize(1200, 600);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuView = new MainMenuView();
        mainWindow.add(mainMenuView);
        mainWindow.setVisible(true);
    }
    public static void startBattle() {
        navyView = new NavyView();
        mainMenuView.setVisible(false);
        mainWindow.add(navyView);
    }
}
