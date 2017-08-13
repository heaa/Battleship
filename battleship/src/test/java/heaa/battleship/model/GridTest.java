/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author heaarnio
 */
public class GridTest {
    private Grid grid;
    
    @Before
    public void setUp() {
        this.grid = new Grid(new Navy());
        List<Position> positionsOfShip1 = new ArrayList<>();
        positionsOfShip1.add(new Position(1,1));
        positionsOfShip1.add(new Position(1,2));
        positionsOfShip1.add(new Position(1,3));
        Ship ship1 = new Ship(3);
        ship1.setPositions(positionsOfShip1);
        List<Position> positionsOfShip2 = new ArrayList<>();
        positionsOfShip2.add(new Position(3,3));
        Ship ship2 = new Ship(1);
        ship2.setPositions(positionsOfShip2);
        grid.getNavy().addShip(ship2);
        grid.getNavy().addShip(ship1);
    }
    
    @Test 
    public void ShootGridDoesDamageTest() {
        Position position = new Position(3,3);
        this.grid.shootGrid(position);
        assertEquals(1, this.grid.getDestroyedShipPositions().size());       
    }
    @Test
    public void ShootGridDoesNotDamageTest() {
        Position position = new Position(10,10);
        this.grid.shootGrid(position);
        List<Position> missed = this.grid.getMissedPositions();
        assertEquals(1, missed.size());
    }
    
}
