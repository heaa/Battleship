
package heaa.battleship.controller;

import heaa.battleship.model.Navy;
import heaa.battleship.model.Position;
import heaa.battleship.model.Ship;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class NavyToolTest {
    
    Navy navy;
    
    @Before
    public void setUp() {
        navy = new Navy();
        List<Position> initialShipPositions = new ArrayList();
        initialShipPositions.add(new Position(6,0));
        initialShipPositions.add(new Position(6,1));
        initialShipPositions.add(new Position(6,2));
        Ship ship = new Ship(3);
        ship.setPositions(initialShipPositions);
        navy.addShip(ship);
    }
    
    
    @Test
    public void testAddShiptoNavyReturnsNavy() {
        int sizeAtFirst = navy.getShips().size();
        List<Position> desiredPositions = new ArrayList();
        desiredPositions.add(new Position(1,2));
        desiredPositions.add(new Position(1,3));
        navy = NavyTool.addShiptoNavy(navy, desiredPositions);
        int sizeAfterAdding = navy.getShips().size();
        int shipCountDifference = sizeAfterAdding - sizeAtFirst;
        assertEquals(1, shipCountDifference);
    }
    
    @Test(expected = RuntimeException.class)
    public void testAddShipToNavyFails() {
        List<Position> desiredPositions = new ArrayList<>();
        desiredPositions.add(new Position(6,1));
        navy = NavyTool.addShiptoNavy(navy, desiredPositions);
    }
    
}
