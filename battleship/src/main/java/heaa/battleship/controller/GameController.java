package heaa.battleship.controller;

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
        computer.getGrid().shootGrid(position);
        if (gameEnded()) {
            shutGameOff();
        }

        playAITurn();
        if (gameEnded()) {
            shutGameOff();
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
