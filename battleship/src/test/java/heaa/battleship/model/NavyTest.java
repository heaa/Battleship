package heaa.battleship.model;





import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

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
        this.navy.addShip(new Ship(2));
        assertEquals(2, navy.getShips().size());
    }
 
    @Test
    public void testShipCannotBeAddedBelowTheOtherOne() {
        Ship wantToAdd = new Ship(1);
        List<Position> wantToAddPositions = new ArrayList();
        wantToAddPositions.add(new Position(2,2));
        wantToAdd.setPositions(wantToAddPositions);
        assertFalse(navy.canShipBeAdded(wantToAdd.getPositions(), 10));
        
        
    }
    @Test
    public void testShipCannotBeAddedAboveTheOtherOne() {
        Ship wantToAdd = new Ship(1);
        List<Position> wantToAddPositions = new ArrayList();
        wantToAddPositions.add(new Position(0,2));
        wantToAdd.setPositions(wantToAddPositions);
        assertFalse(navy.canShipBeAdded(wantToAdd.getPositions(), 10));
    }
    
    @Test 
    public void testShipCannotBeAddedOnTheOtherOne() {
        Ship wantToAdd = new Ship(1);
        List<Position> wantToAddPositions = new ArrayList();
        wantToAddPositions.add(new Position(1,2));
        wantToAdd.setPositions(wantToAddPositions);
        assertFalse(navy.canShipBeAdded(wantToAdd.getPositions(), 10));
    }
    
   @Test
   public void testShipCannotBeAddedRightOfTheOtherOne() {
       Ship wantToAdd = new Ship(1);
       List<Position> wantToAddPositions = new ArrayList();
       wantToAddPositions.add(new Position(1,4));
       wantToAdd.setPositions(wantToAddPositions);
       assertFalse(navy.canShipBeAdded(wantToAdd.getPositions(), 10));
   }
   
   @Test
   public void testShipCannotBeAddedLeftOfTheOtherOne() {
       Ship wantToAdd = new Ship(1);
       List<Position> wantToAddPositions = new ArrayList();
       wantToAddPositions.add(new Position(1,1));
       wantToAdd.setPositions(wantToAddPositions);
       assertFalse(navy.canShipBeAdded(wantToAdd.getPositions(), 10));
   }
   @Test
   public void testShipCanBeAddedToTheCornerOfTheOtherOne() {
       Ship wantToAdd = new Ship(1);
       List<Position> wantToAddPositions = new ArrayList();
       wantToAddPositions.add(new Position(3,1));
       wantToAdd.setPositions(wantToAddPositions);
       assertTrue(navy.canShipBeAdded(wantToAdd.getPositions(), 10));
   }
   @Test
   public void testShipCanBeAddedTwoRowsBelowTheOtherOne() {
       Ship wantToAdd = new Ship(1);
       List<Position> wantToAddPositions = new ArrayList();
       wantToAddPositions.add(new Position(4,2));
       wantToAdd.setPositions(wantToAddPositions);
       assertTrue(navy.canShipBeAdded(wantToAdd.getPositions(), 10));
   }
   
   @Test
   public void shipCannotBeAddedOutOfGameAreaLimits() {
       Grid grid = new Grid(this.navy);
       grid.setGridSize(20);
       List<Position> desiredPositions = new ArrayList();
       desiredPositions.add(new Position(19,19));
       desiredPositions.add(new Position(19,20));
       desiredPositions.add(new Position(19,21));
       assertFalse(navy.canShipBeAdded(desiredPositions, grid.getSize()));
   }
   
   @Test
   public void testShipCanBeAddedWithEmtpyPositionList() {
       assertTrue(navy.canShipBeAdded(new ArrayList<>(), 10));
   }
   
   @Test(expected = Exception.class)
   public void testShipCanBeAddedWithNullPositionList() {
       navy.canShipBeAdded(null, 10);
   }
   @Test
   public void testShipDamage() {
       Position position = new Position(1,2);
       assertTrue(navy.damage(position));
   }
   @Test
   public void testShipDestroyed() {
       int navySizeFirst = navy.getShips().size();
       Position position1 = new Position(1,2);
       Position position2 = new Position(1,3);
       navy.damage(position1);
       navy.damage(position2);
       int sizeDifference = Math.abs(navySizeFirst - navy.getShips().size());
       assertEquals(1, sizeDifference);
   }
  
}
