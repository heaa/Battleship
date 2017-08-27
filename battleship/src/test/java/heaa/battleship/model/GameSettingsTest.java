/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class GameSettingsTest {
    private GameSettings settings;
    
    @Before
    public void setUp() {
        this.settings = settings.getInstance();
    }
    
    @Test
    public void settingsIsNotNull() {
        assertTrue(settings != null);
    }
    
    @Test
    public void settingsKeepsSettedHumanPlayer() {
        settings.setHumanPlayer(new HumanPlayer());
        assertTrue(settings.getHumanPlayer() != null);
    }
    @Test
    public void settingsKeepsSettedAiPlayer() {
        settings.setAiPlayer(new AIPlayer());
        assertTrue(settings.getAiPlayer() != null);
    }
    @Test
    public void settingsKeepsSettedGridSize() {
        settings.setGridSize(20);
        assertEquals(20, settings.getGridSize());
    }
    
}
