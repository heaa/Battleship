
package heaa.battleship.model;

import java.util.ArrayList;
import java.util.List;


public class Grid {

    private List<Position> missedPositions;
    private List<Position> destroyedShipPositions;
    private Navy navy;
    private int gridSize;

    public Grid(Navy navy) {
        this.destroyedShipPositions = new ArrayList<>();
        this.missedPositions = new ArrayList<>();
        this.navy = navy;
    }

    public void setShootedPositions(List<Position> shootedPositions) {
        this.missedPositions = shootedPositions;
    }

    public List<Position> getMissedPositions() {
        return this.missedPositions;
    }
 
    public List<Position> getDestroyedShipPositions() {
        return this.destroyedShipPositions;
    }

    public Navy getNavy() {
        return navy;
    }
    
    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }
    
    public void shootGrid(Position position) {
        if (navy.damage(position)) {
            destroyedShipPositions.add(position);
        } else {
            missedPositions.add(position);
        }
    }
    public int getSize() {
        return this.gridSize;
    }
    
    public List<Position> getShootedPositions() {
        List<Position> shootedPositions = new ArrayList<>();
        shootedPositions.addAll(missedPositions);
        shootedPositions.addAll(destroyedShipPositions);
        return shootedPositions;
    }
    
    

}
