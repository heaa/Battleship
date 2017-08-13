
package heaa.battleship.util;

import heaa.battleship.model.Navy;
import heaa.battleship.model.Position;
import heaa.battleship.model.Ship;
import java.util.List;


public class NavyTool {
    
    public static Navy createNavy() {
        return new Navy();
    }
    
    public static Navy addShiptoNavy(Navy navy, List<Position> desiredPositions) throws RuntimeException {
        if (navy.canShipBeAdded(desiredPositions)) {
            Ship ship = new Ship(desiredPositions.size());
            ship.setPositions(desiredPositions);
            navy.addShip(ship);
            return navy;
        } else {
            throw new RuntimeException("Could not add ship.");
        }
        
    }
}