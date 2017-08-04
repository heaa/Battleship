/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaa.battleship.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heaarnio
 */
public class Navy {
    private List<Ship> ships;
    
    public Navy(){
        this.ships = new ArrayList<>();
    }
    
    public List<Ship> getShips() {
        return this.ships;
    }
    public void addShip(Ship ship) {
        this.ships.add(ship);
    }
    public boolean damage(Position position) {
        for (Ship ship : ships) {
            if (ship.getPositions().contains(position)) {
                ship.deletePosition(position);
                return true;
            }
        }
        return false;
    }
    public boolean canShipBeAdded(List<Position> desiredLocations) {
        List<Position> locationsWhereCannotBeShips = new ArrayList<>(desiredLocations);
        desiredLocations.forEach(l -> {
            locationsWhereCannotBeShips.add(new Position(l.getI(), l.getJ() + 1));
            locationsWhereCannotBeShips.add(new Position(l.getI(), l.getJ() - 1));
            locationsWhereCannotBeShips.add(new Position(l.getI() - 1, l.getJ()));
            locationsWhereCannotBeShips.add(new Position(l.getI() + 1, l.getJ()));
        });
        return !desiredPositionIsOccupied(locationsWhereCannotBeShips);
    }

    private boolean desiredPositionIsOccupied(List<Position> locationsWhereCannotBeShips) {
        for (Position p : locationsWhereCannotBeShips) {
            for (Ship ship : this.ships) {
                if (ship.hasPosition(p)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
  
    
    
    
    
    
}
