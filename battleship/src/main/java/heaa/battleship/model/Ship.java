
package heaa.battleship.model;

import java.util.List;
/**
 * 
 * Laivaa mallintava luokka.
 */

public class Ship {

   
    private List<Position> positions;
    private int length;

    public Ship(int length) {
        this.length = length;
    }

    

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return this.positions;
    }

    public boolean hasPosition(Position other) {
        for (Position position : positions) {
            if (position.equals(other)) {
                return true;
            }
        }
        return false;
    }

    public void deletePosition(Position other) {
        for (Position position : this.positions) {
            if (position.equals(other)) {
                this.positions.remove(position);
                break;
            }
        }
    }

}
