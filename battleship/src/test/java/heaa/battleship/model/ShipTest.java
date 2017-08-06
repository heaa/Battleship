package heaa.battleship.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShipTest {
    private Ship ship;
    
    @Before 
    public void setUp() {
        this.ship = new Ship(1);
        List<Position> testPositions = new ArrayList<>();
        testPositions.add(new Position(1, 2));
        ship.setPositions(testPositions);
    }
    
    @Test
    public void testHasPosition() {
       
        assertTrue(ship.hasPosition(new Position(1,2)));
    }
    @Test
    public void testHasPositionFalse() {
        assertFalse(ship.hasPosition(new Position(1,1)));
        
    }
    @Test
    public void testDeletePosition() {
        ship.deletePosition(new Position(1,2));
        List testPositions = ship.getPositions();
        assertEquals(0, testPositions.size());
    }
}
