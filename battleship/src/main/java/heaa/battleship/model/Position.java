
package heaa.battleship.model;


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

    public boolean equals(Position other) {
        return this.i == other.i && this.j == other.j;
    }

    @Override
    public String toString() {
        return this.i + " " + this.j;
    }
}
