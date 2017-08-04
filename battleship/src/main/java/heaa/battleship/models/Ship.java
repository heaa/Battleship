/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.models;

import java.util.List;

/**
 *
 * @author heaarnio
 */
public class Ship {
    private int length;
    private List<Position> positions;
    
    public Ship(int length){
        length = this.length;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
    
    public List<Position> getPositions() {
        return this.positions;
    }
    public boolean hasPosition(Position other) {
        for(Position position : positions) {
            if (position.equals(other)) {
                return true;
            }
        }
        return false;
    }
    public void deletePosition(Position other) { 
        for(Position position : this.positions) {
            if(position.equals(other)) {
                this.positions.remove(position);
                break;
            }
        }
    }
    
}
