package heaa.battleship.model;

/**
 *
 * Luokka, joka mallintaa sijaintia peliruudulla.
 */

public class Position {

    private int i;
    private int j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void setPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Position) {
            Position otherPos = (Position) other;
            return this.i == otherPos.i && this.j == otherPos.j;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.i;
        hash = 89 * hash + this.j;
        return hash;
    }

    @Override
    public String toString() {
        return this.i + " " + this.j;
    }
}
