/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.model;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author heaarnio
 */
public class PositionTest {
    private Position position;
    
    @Test
    public void hashCodeTest() {
        this.position = new Position(1,12);
        Position position2 = new Position(1,12);
        assertTrue(this.position.hashCode() == position2.hashCode());
    }
    
}
