package heaa.battleship.view;

import heaa.battleship.model.AIPlayer;
import heaa.battleship.model.GameSettings;
import heaa.battleship.model.HumanPlayer;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Pelin loppunäkymän mallinnusta hallinnoiva luokka.
 *
 * @author heaarnio
 */
public class GameEndViewController implements Runnable {

    private GameEndView gameEnd;

    @Override
    public void run() {
        this.gameEnd = new GameEndView();
        gameStatistics();
        createMainMenuButton();
        MainFrame.getInstance().setPanelInView(this.gameEnd.getMainPanel());
    }

    private void gameStatistics() {
        AIPlayer computer = GameSettings.getInstance().getAiPlayer();
        HumanPlayer human = GameSettings.getInstance().getHumanPlayer();
        int computerMissed = computer.getGrid().getMissedPositions().size();
        int computerHits = computer.getGrid().getDestroyedShipPositions().size();

        JPanel stats = new JPanel();
        stats.setLayout(new GridBagLayout());

        stats.add(createWinnerText());
        stats.add(createPointText());
        this.gameEnd.setGameStatistics(stats);
    }

    private JLabel createWinnerText() {
        JLabel winnerText = new JLabel();
        if (humanWon()) {
            winnerText.setText("Game ended. You won!");
        } else {
            winnerText.setText("Game ended. Computer won!");
        }
        return winnerText;
    }

    private JLabel createPointText() {
        JLabel pointText = new JLabel();
        if (humanWon()) {
            pointText.setText("You collected " + calculateHumanPoints(GameSettings.getInstance().getAiPlayer()) + " points.");
        } else {
            pointText.setText("Computer collected " + calculateComputerPoints(GameSettings.getInstance().getHumanPlayer()) + " points.");
        }
        return pointText;
    }

    private boolean humanWon() {
        if (GameSettings.getInstance().getHumanPlayer().hasShips()) {
            return true;
        }
        return false;
    }

    private long calculateHumanPoints(AIPlayer computer) {
        int squares = (int) Math.pow(GameSettings.getInstance().getGridSize(), 2);
        int computerShooted = computer.getGrid().getShootedPositions().size();
        return calculatePoints(squares, computerShooted);
    }

    private long calculateComputerPoints(HumanPlayer human) {
        int squares = (int) Math.pow(GameSettings.getInstance().getGridSize(), 2);
        int humanShooted = human.getGrid().getShootedPositions().size();
        return calculatePoints(squares, humanShooted);
    }

    private long calculatePoints(int squares, int shooted) {
        return Math.round((squares / shooted) * 1000);
    }

    private void createMainMenuButton() {
        JButton mainMenu = new JButton("To main menu");
        mainMenu.addActionListener(action -> {
            SwingUtilities.invokeLater(new MainMenuViewController());
        });
        gameEnd.setMainMenuButton(mainMenu);
    }
}
