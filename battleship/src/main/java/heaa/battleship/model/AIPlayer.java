package heaa.battleship.model;

import java.util.List;
import java.util.Random;

/**
 *
 * Tekoälypelaajaa mallintava luokka.
 */

public class AIPlayer extends Player {

    private Random random;

    /**
     * Konstruktori luo tekoälypelaajan ja samalla Random-luokan esiintymän
     * luokan sisäiseen käyttöön.
     */
    public AIPlayer() {
        this.random = new Random();
    }

    /**
     * Metodi palauttaa sijainnin vastustajan ruudukosta ampumista varten.
     *
     * @param enemyGrid Vastustajan ruudukko
     * @return Sijainti tekoälyn ampumista varten.
     */
    public Position determineWhereToShoot(Grid enemyGrid) {
        Position shoot = this.getRandomShootingPosition(enemyGrid);
        while (isAlreadyShot(enemyGrid.getShootedPositions(), shoot)) {
            shoot = getRandomShootingPosition(enemyGrid);
        }
        return shoot;
    }

    private Position getRandomShootingPosition(Grid enemyGrid) {
        int i = random.nextInt(enemyGrid.getSize());
        int j = random.nextInt(enemyGrid.getSize());
        Position shootPosition = new Position(i, j);
        return shootPosition;
    }

    /**
     * Metodi, joka kertoo, onko tiettyyn sijaintiin jo ammuttu.
     *
     * @param shotPositions Lista sijainneista, joihin on jo ammuttu.
     * @param position Sijainti, jota halutaan verrata jo ammuttuihin
     * sijainteihin.
     * @return Boolean true, jos sijaintiin on jo ammuttu ja false, jos ei vielä
     * ole.
     */
    public boolean isAlreadyShot(List<Position> shotPositions, Position position) {
        for (Position shotPosition : shotPositions) {
            if (position.equals(shotPosition)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi määrittää satunnaisen sijainnin ruudukosta laivan asettamista
     * varten.
     *
     * @param ownGrid Pelaajan ruudukko
     * @return Uusi sijaintiolio
     */
    public Position determinePositionToPut(Grid ownGrid) {
        int i = this.random.nextInt(ownGrid.getSize());
        int j = this.random.nextInt(ownGrid.getSize());
        return new Position(i, j);
    }

    /**
     * Metodi antaa tekoälylle boolean-arvon, jotta on mahdollista päättää laitetaanko laiva pysty- vai vaakasuuntaisesti ruudukkoon.
     * @return Boolean arvo true, jos satunnainen luku on pienempi tai yhtä suuri kuin 0.49 ja false, jos yli 0.49.
     */
    public boolean selectAlignment() {
        return this.random.nextDouble() <= 0.49;
    }

}
