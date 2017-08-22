package heaa.battleship.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Pelaajan laivastoa mallintava luokka.
 */

public class Navy {

    private List<Ship> ships;

    /**
     * Metodi luo laivaston ja tyhjän uuden listan laivoja varten.
     */
    public Navy() {
        this.ships = new ArrayList<>();
    }

    public List<Ship> getShips() {
        return this.ships;
    }

    /**
     * Metodi palauttaa listan kaikkien laivaston laivojen sijainneista.
     *
     * @return Kaikkien laivastoon kuuluvien laivojen sijainnit
     */
    public List<Position> getCombinedPositionsOfShips() {
        List<Position> positions = new ArrayList();

        for (Ship ship : this.ships) {
            positions.addAll(ship.getPositions());
        }
        return positions;
    }

    /**
     * Metodi lisää laivan laivastoon laivalistaan.
     * @param ship Lisättävä laiva.
     */
    public void addShip(Ship ship) {
        this.ships.add(ship);
    }

    /**
     * Metodi tarkistaa tietystä parametrina annetusta sijainnista, onko yksikään
     * laivaston laiva kyseisessä sijainnissa. Jos on, kyseiseltä laivalta poistetaan
     * sijainti, johon tulee vahinkoa pelissa. Jos koko laiva tuhoutuu, se poistetaan
     * laivastosta.
     * @param position Sijainti, jota halutaan verrata laivaston laivojen sijainteihin
     * @return Palauttaa arvon true, jos laivastoon tuli vahinkoa ja false, jos mihinkään ei osuttu
     */
    public boolean damage(Position position) {
        for (Ship ship : ships) {
            if (ship.hasPosition(position)) {
                ship.deletePosition(position);
                if (isShipDestroyed(ship)) {
                    removeShipFromShipList(ship);
                }
                return true;
            }
        }
        return false;
    }

    private boolean isShipDestroyed(Ship ship) {
        return ship.getPositions().isEmpty();
    }

    private void removeShipFromShipList(Ship ship) {
        ships.remove(ship);
    }
    /**
     * Metodi palauttaa tiedon, voiko laivan lisätä toivottuun paikkaan ruudukossa.
     * Metodi ottaa parametrina listan toivotun laivan sijainneista ja tarkistaa,
     * ettei listan mukaisissa ruuduissa tai niiden viereisissä ruuduissa ole laivoja.
     * @param desiredLocations Lista asetettavan laivan sijainneista
     * @param gridSize Pelialueen ruudukon koko
     * @return Boolean-muuttuja true, jos laivan voi lisätä pelin sääntöjen mukaisesti
     * toivottuun kohtaan ja false, jos ei voi
     */
    public boolean canShipBeAdded(List<Position> desiredLocations, int gridSize) {
        List<Position> locationsWhereCannotBeShips = new ArrayList<>(desiredLocations);
        desiredLocations.forEach(l -> {
            locationsWhereCannotBeShips.add(new Position(l.getI(), l.getJ() + 1));
            locationsWhereCannotBeShips.add(new Position(l.getI(), l.getJ() - 1));
            locationsWhereCannotBeShips.add(new Position(l.getI() - 1, l.getJ()));
            locationsWhereCannotBeShips.add(new Position(l.getI() + 1, l.getJ()));
        });
        return !desiredPositionIsOccupied(locationsWhereCannotBeShips) && !desiredLocationsAreOutOfLimits(desiredLocations, gridSize);
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

    private boolean desiredLocationsAreOutOfLimits(List<Position> desiredPositions, int maxLimit) {
        for (Position p : desiredPositions) {
            if (isOutOfLimits(p, maxLimit)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOutOfLimits(Position p, int maxLimit) {
        return (p.getI() > maxLimit - 1) || (p.getI() < 0) || (p.getJ() > maxLimit - 1) || (p.getJ() < 0);
    }

}
