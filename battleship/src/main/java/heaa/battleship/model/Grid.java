package heaa.battleship.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Pelin ruudukkoa mallintava luokka.
 */
public class Grid {

    private List<Position> missedPositions;
    private List<Position> destroyedShipPositions;
    private Navy navy;
    private int gridSize;

    /**
     * Metodi luo uuden peliruudukon ja listat tuhoutuneiden laivojen sijaintien
     * sekä ammuttujen hutien sijaintien tallentamiseen.
     *
     * @param navy Laivasto, joka halutaan asettaa ruudukkoon.
     */
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

    /**
     * Metodi, joka vastaa ampumisesta ruudukkoon. Metodi tarkastaa samalla,
     * upposiko laivoja ja lisää mahdolliset uponneet laivat
     * oliomuuttujalistaan. Jos mihinkään ei osuttu, sijainti tallennetaan
     * hutilistaan.
     *
     * @param position Sijainti, johon ammutaan.
     */
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

    /**
     * Metodi palauttaa kaikki sijainnit, joihin on ammuttu siten, että
     * yhdistetään hutilista ja osuttujen sijaintien lista.
     *
     * @return Lista kaikista sijainneista, joihin on ammuttu.
     */
    public List<Position> getShootedPositions() {
        List<Position> shootedPositions = new ArrayList<>();
        shootedPositions.addAll(missedPositions);
        shootedPositions.addAll(destroyedShipPositions);
        return shootedPositions;
    }

    /**
     * Metodin avulla voi tarkastaa, onko tiettyyn sijaintiin jo ammuttu.
     *
     * @param position Sijainti, jota halutaan verrata jo ammuttuihin
     * sijainteihin
     * @return Boolean arvo true, jos sijaintiin on jo ammuttu ja false, jos ei
     * vielä ole
     */
    public boolean isAlreadyShot(Position position) {
        return getShootedPositions().contains(position);
    }

}
