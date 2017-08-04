
package heea.battleship.models;

import heaa.battleship.models.Navy;
import heaa.battleship.models.Position;
import heaa.battleship.models.Ship;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NavyTest {
    private Navy navy;
    private Ship testship;
    private List<Position> testShipPositions;
    
    @Before 
    public void setUp() {
        this.navy = new Navy();
        this.testship = new Ship(2);
        this.testShipPositions = new ArrayList();
        testShipPositions.add(new Position(1,2));
        testShipPositions.add(new Position(1,3));
        testship.setPositions(testShipPositions);
        this.navy.addShip(testship);
    }         

    
    
    @Test
    public void testAddShip() {
        this.navy.addShip(new Ship(1));
        assertEquals(2, navy.getShips().size());
    }
 
    @Test
    public void testShipCannotBeAddedBelowTheOtherOne() {
        Ship wantToAdd = new Ship(1);
        List<Position> wantToAddPositions = new ArrayList();
        wantToAddPositions.add(new Position(2,2));
        wantToAdd.setPositions(wantToAddPositions);
        assertFalse(navy.canShipBeAdded(wantToAdd.getPositions()));
        
        
    }
    @Test
    public void testShipCannotBeAddedAboveTheOtherOne() {
        Ship wantToAdd = new Ship(1);
        List<Position> wantToAddPositions = new ArrayList();
        wantToAddPositions.add(new Position(0,2));
        wantToAdd.setPositions(wantToAddPositions);
        assertFalse(navy.canShipBeAdded(wantToAdd.getPositions()));
    }
    
    @Test 
    public void testShipCannotBeAddedOnTheOtherOne() {
        Ship wantToAdd = new Ship(1);
        List<Position> wantToAddPositions = new ArrayList();
        wantToAddPositions.add(new Position(1,2));
        wantToAdd.setPositions(wantToAddPositions);
        assertFalse(navy.canShipBeAdded(wantToAdd.getPositions()));
    }
    
   @Test
   public void testShipCannotBeAddedRightOfTheOtherOne() {
       Ship wantToAdd = new Ship(1);
       List<Position> wantToAddPositions = new ArrayList();
       wantToAddPositions.add(new Position(1,4));
       wantToAdd.setPositions(wantToAddPositions);
       assertFalse(navy.canShipBeAdded(wantToAdd.getPositions()));
   }
   
   @Test
   public void testShipCannotBeAddedLeftOfTheOtherOne() {
       Ship wantToAdd = new Ship(1);
       List<Position> wantToAddPositions = new ArrayList();
       wantToAddPositions.add(new Position(1,1));
       wantToAdd.setPositions(wantToAddPositions);
       assertFalse(navy.canShipBeAdded(wantToAdd.getPositions()));
   }
   @Test
   public void testShipCanBeAddedToTheCornerOfTheOtherOne() {
       Ship wantToAdd = new Ship(1);
       List<Position> wantToAddPositions = new ArrayList();
       wantToAddPositions.add(new Position(3,1));
       wantToAdd.setPositions(wantToAddPositions);
       assertTrue(navy.canShipBeAdded(wantToAdd.getPositions()));
   }
   @Test
   public void testShipCanBeAddedTwoRowsBelowTheOtherOne() {
       Ship wantToAdd = new Ship(1);
       List<Position> wantToAddPositions = new ArrayList();
       wantToAddPositions.add(new Position(4,2));
       wantToAdd.setPositions(wantToAddPositions);
       assertTrue(navy.canShipBeAdded(wantToAdd.getPositions()));
   }
   
   @Test
   public void testShipCanBeAddedWithEmtpyPositionList() {
       assertTrue(navy.canShipBeAdded(new ArrayList<>()));
   }
   
   @Test(expected = Exception.class)
   public void testShipCanBeAddedWithNullPositionList() {
       navy.canShipBeAdded(null);
   }
}
