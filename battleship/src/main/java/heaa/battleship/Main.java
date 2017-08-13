package heaa.battleship;

import heaa.battleship.view.NavyView;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new NavyView());
    }
}
