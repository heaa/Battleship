package heaa.battleship;

import heaa.battleship.view.MainMenuViewController;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MainMenuViewController());
    }
}
