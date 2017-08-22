package heaa.battleship.util;

import heaa.battleship.model.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Luokka, jossa on apumetodeja laivojen asettamiseksi ruudukkoon.
 */

public class ShipBuilder {

    /**
     * Metodi, joka luo pinon yhden laivaston laivojen pituuksista.
     * @return Pino laivojen pituuksista
     */
    public static Stack<Integer> createStackOfShipLengths() {
        Stack<Integer> lengthStack = new Stack<>();
        lengthStack.add(5);
        lengthStack.add(4);
        lengthStack.add(3);
        lengthStack.add(3);
        lengthStack.add(2);
        lengthStack.add(1);
        return lengthStack;
    }

    /**
     * Metodi, joka palauttaa listan toivotuista sijainneista ruudukossa. Metodi ottaa
     * parametreina toivotun laivan pituuden, tiedon laivan vaaka- tai pystysuuntaisesta
     * asennosta ja ruudusta, josta laivan toivotaan alkavan. 
     * 
     * @param lenght Halutun laivan pituus
     * @param horizontal Boolean true, jos laiva halutaan asettaa vaakasuuntaisesti ja
     * false, jos pystysuuntaisesti.
     * @param startPosition Sijainti, josta laivan toivotaan alkavan.
     * @return Lista toivotuista sijainneista, joihin laiva halutaan asettaa
     */
    public static List<Position> buildDesiredPositions(int lenght, boolean horizontal, Position startPosition) {
        ArrayList<Position> desiredPositions = new ArrayList<>();
        
        for (int n = 0; n < lenght; n++) {
            if (horizontal) {
                desiredPositions.add(new Position(startPosition.getI(), startPosition.getJ() + n));
            } else {
                desiredPositions.add(new Position(startPosition.getI() + n, startPosition.getJ()));
            }
        }
        System.out.println(desiredPositions);
        return desiredPositions;
    }

}
