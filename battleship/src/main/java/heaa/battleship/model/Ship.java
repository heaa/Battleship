package heaa.battleship.model;

import java.util.List;

/**
 *
 * Laivaa mallintava luokka.
 */
public class Ship {

    private List<Position> positions;
    private int length;

    /**
     * Konstruktori, joka palauttaa uuden laivaolion ja asettaa sille samalla
     * pituuden.
     *
     * @param length Integer-arvo, joka mallintaa laivan pituutta ruutuina
     */
    public Ship(int length) {
        this.length = length;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return this.positions;
    }

    /**
     * Metodi palauttaa tiedon, onko laivalla parametrina annettu sijainti.
     *
     * @param other Sijainti, johon laivan sijainteja halutaan verrata
     * @return Boolean-arvo true, jos laivalla on parametria vastaava sijainti
     * ja false, jos laivalla ei ole sijaintia.
     */
    public boolean hasPosition(Position other) {
        return positions.contains(other);
    }

    /**
     * Metodi poistaa laivalta parametrina annetun sijainnin.
     *
     * @param other Sijainti, joka laivalta halutaan poistaa
     */
    public void deletePosition(Position other) {
        for (Position position : this.positions) {
            if (position.equals(other)) {
                this.positions.remove(position);
                break;
            }
        }
    }

}
