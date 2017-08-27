package heaa.battleship.util;

import heaa.battleship.model.Navy;
import heaa.battleship.model.Position;
import heaa.battleship.model.Ship;
import java.util.List;

/**
 *
 * Luokka, jonka avulla voi hallinnoida laivastoa.
 */
public class NavyTool {

    /**
     * Metodi, joka luo uuden laivaston.
     * @return Laivasto
     */
    public static Navy createNavy() {
        return new Navy();
    }

    /**
     * Metodi lisää laivan laivaston, jos laiva on mahdollista lisätä toivottuun
     * sijaintiin. Jos laivaa ei voi lisätä, metodi heittää poikkeuksen.
     *
     * @param navy Laivasto, johon laiva halutaan lisätä
     * @param desiredPositions Sijainnit, joihin lisättävä laiva halutaan
     * asettaa
     * @param gridSize Pelialueen ruudukon koko
     * @return Laivasto, johon laiva on lisätty
     * @throws RuntimeException Poikkeus, joka kertoo, ettei laivaa voitu lisätä
     */
    public static Navy addShiptoNavy(Navy navy, List<Position> desiredPositions, int gridSize) throws RuntimeException {
        if (navy.canShipBeAdded(desiredPositions, gridSize)) {
            Ship ship = new Ship(desiredPositions.size());
            ship.setPositions(desiredPositions);
            navy.addShip(ship);
            return navy;
        } else {
            throw new RuntimeException("Could not add ship.");
        }

    }
}
