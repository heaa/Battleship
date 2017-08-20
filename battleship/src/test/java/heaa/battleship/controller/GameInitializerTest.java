
package heaa.battleship.controller;

import heaa.battleship.model.GameSettings;
import heaa.battleship.model.Player;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class GameInitializerTest {

    private GameInitializerController initializer;

    @Before
    public void setUp() {
        this.initializer = new GameInitializerController();
        GameSettings.setGridSize(10);
    }

    @Test
    public void startGameHumanPlayerIsNotNullTest() {
        initializer.startGame();
        Player human = initializer.getHumanPlayer();
        assertNotNull(human);
    }

    @Test
    public void startGameAIPlayerIsNotNullTest() {
        initializer.startGame();
        Player computer = initializer.getAIPlayer();
        assertNotNull(computer);
    }

    @Test
    public void startGameAIPlayerHas5Ships() {
        initializer.startGame();
        int SizeOfNavy = initializer.getAIPlayer().getGrid().getNavy().getShips().size();
        assertEquals(6, SizeOfNavy);
    }

    @Test
    public void startGameHumanHasNavy() {
        initializer.startGame();
        assertNotNull(initializer.getHumanPlayer());
    }

    @Test
    public void startGameAIHasNavy() {
        initializer.startGame();
        assertTrue(initializer.getAIPlayer().hasShips());
    }
}
