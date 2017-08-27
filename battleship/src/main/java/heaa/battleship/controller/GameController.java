package heaa.battleship.controller;

import heaa.battleship.exception.AlreadyShotException;
import heaa.battleship.exception.GameEndedException;
import heaa.battleship.model.AIPlayer;
import heaa.battleship.model.HumanPlayer;
import heaa.battleship.model.Position;

/**
 *
 * Luokka, jonka avulla hallinnoidaan pelaajia ja pelivuoroja.
 */
public class GameController {

    private HumanPlayer human;
    private AIPlayer computer;

    /**
     * Metodi huolehtii pelivuoron kulusta. Ensin ammutaan pelaajan klikkaamaan
     * ruutuun, jonka jälkeen tarkastetaan, loppuiko peli. Jos ei loppunut, niin
     * on tekoälyn vuoro, jonka jälkeen tarkastetaan uudelleen, loppuiko peli.
     * Pelin loppuessa metodi sulkee ohjelman.
     *
     * @param position Sijainti, johon pelaaja haluaa ampua
     */
    public void playTurn(Position position) {

        shoot(position);

        if (gameEnded()) {
            throw new GameEndedException();
        }
        playAITurn();
        if (gameEnded()) {
            throw new GameEndedException();
        }
    }

    private void shoot(Position position) throws AlreadyShotException {
        if (!computer.getGrid().isAlreadyShot(position)) {
            computer.getGrid().shootGrid(position);
        } else {
            throw new AlreadyShotException();
        }
    }

    private boolean gameEnded() {
        return !human.hasShips() || !computer.hasShips();
    }

    private void shutGameOff() {
        System.exit(0);
    }

    /**
     * Metodi, joka vastaa tekoälyn pelivuorosta. Ensin määritetään sijainti,
     * johon ammutaan vastustajan eli ihmispelaajan ruudukosta. Sitten tekoäly
     * ampuu kyseiseen sijaintiin.
     *
     */
    public void playAITurn() {
        Position position = computer.determineWhereToShoot(human.getGrid());
        human.getGrid().shootGrid(position);
    }

    public HumanPlayer getHuman() {
        return human;
    }

    public void setHuman(HumanPlayer human) {
        this.human = human;
    }

    public AIPlayer getComputer() {
        return computer;
    }

    public void setComputer(AIPlayer computer) {
        this.computer = computer;
    }

}
