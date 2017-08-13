
package heaa.battleship.model;

import heaa.battleship.util.NavyTool;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AIPlayerTest {
    private AIPlayer aiplayer;
    private Grid grid;
    
    @Before
    public void setUp() {
        this.aiplayer = new AIPlayer();
        this.grid = new Grid(NavyTool.createNavy());
        this.grid.setGridSize(20);
        
    }
    
    @Test
    public void getRandomShootingPositionGivesIPositionBetweenBounds() {
        Position position = aiplayer.determineWhereToShoot(grid);
        assertTrue(position.getI() >= 0);
        assertTrue(position.getI() < 20);
    }
    @Test
    public void getRandomShootingPositionGivesJPositionBetweenBounds() {
        Position position = aiplayer.determineWhereToShoot(grid);
        assertTrue(position.getJ() >= 0);
        assertTrue(position.getJ() < 20);
    }
    @Test
    public void isAlreadyShotTest() {
        Position shoot = new Position(1, 1);
        grid.shootGrid(shoot);
        assertTrue(aiplayer.isAlreadyShot(grid.getShootedPositions(), shoot));
        assertFalse(aiplayer.isAlreadyShot(grid.getShootedPositions(), new Position(2,1)));
    }
    
    @Test
    public void determinePositionToPutGivesIPositionBetweenBoundsTest() {
        Position position = this.aiplayer.determinePositionToPut(this.grid);
        assertTrue(position.getI() >= 0);
        assertTrue(position.getI() < 20);
    }
    @Test
    public void determinePositionToPutGivesJPositionBetweenBoundsTest() {
        Position position = this.aiplayer.determinePositionToPut(this.grid);
        assertTrue(position.getJ() >= 0);
        assertTrue(position.getJ() < 20);
    }
            
}
