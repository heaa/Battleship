package heaa.battleship.controller;

import heaa.battleship.util.NavyTool;
import heaa.battleship.util.ShipBuilder;
import heaa.battleship.model.AIPlayer;
import heaa.battleship.model.GameSettings;
import heaa.battleship.model.Grid;
import heaa.battleship.model.HumanPlayer;
import heaa.battleship.model.Player;
import heaa.battleship.model.Position;
import heaa.battleship.model.Ship;
import java.util.List;
import java.util.Stack;

/**
 *
 * Pelin alkua hallinnoiva luokka.
 */
public class GameInitializerController {

    private AIPlayer computer;
    private HumanPlayer human;

    /**
     * Metodia kutsumalla peli alkaa. Ensin luodaan pelaajat, pelaajille
     * ruudukot, joihin luodaan samalla laivastot. Pelaajille asetetaan sitten
     * ruudukot, joiden koot määrätään pelin asetusten mukaisesti. Metodi
     * asettaa myös tekoälyn ohjaamat laivat ruudukkoonsa.
     */
    public void startGame() {
        this.computer = new AIPlayer();
        this.human = new HumanPlayer();
        Grid humanGrid = new Grid(NavyTool.createNavy());
        Grid aiGrid = new Grid(NavyTool.createNavy());
        humanGrid.setGridSize(GameSettings.getInstance().getGridSize());
        aiGrid.setGridSize(GameSettings.getInstance().getGridSize());
        this.human.setGrid(humanGrid);
        this.computer.setGrid(aiGrid);
        this.setAIShipsToGrid(this.computer, ShipBuilder.createStackOfShipLengths());
    }

    /**
     * Metodia kutsumalla tekoälyn ohjaamat laivat saadaan asetettua ruudukkoon.
     * Metodi tarkastaa ensin, ettei parametrinä saatu pino laivojen pituuksista
     * ole tyhjä. Jos pino ei ole tyhjä, laivoja asetetaan yksi kerrallaan
     * ruudukkoon ja samalla poistetaan pinosta jo asetettujen laivojen
     * pituudet.
     *
     * @param computer tietokonepelaaja
     * @param shipLengths pino asetettavien laivojen pituuksista
     */
    public void setAIShipsToGrid(AIPlayer computer, Stack<Integer> shipLengths) {
        while (!shipLengths.empty()) {
            try {
                addShipToGrid(
                        computer.getGrid(),
                        computer.determinePositionToPut(computer.getGrid()),
                        shipLengths.peek(),
                        computer.selectAlignment());
                shipLengths.pop();
            } catch (RuntimeException e) {
            }
        }
    }

    /**
     * Metodia kutsumalla voi lisätä laivan ruudukkoon, jos sijainti on
     * mahdollinen huomioiden toivotut ruudut, muut jo asetetut laivat ja
     * ruudukon koko.
     *
     * @param grid Peliruudukko, johon halutaan lisätä laiva
     * @param place Paikka ruudukossa, josta laivan halutaan alkavan.
     * @param shipLength Asetettavan laivan pituus ruutuina.
     * @param horizontal Muuttuja, joka on tosi silloin kun laiva on
     * vaakasuuntainen ja epätosi kun laiva on pystysuuntainen.
     */
    public void addShipToGrid(Grid grid, Position place, Integer shipLength, boolean horizontal) {
        List<Position> desiredPositions = ShipBuilder.buildDesiredPositions(shipLength, horizontal, place);

        if (grid.getNavy().canShipBeAdded(desiredPositions, grid.getSize())) {
            Ship ship = new Ship(shipLength);
            ship.setPositions(desiredPositions);
            grid.getNavy().addShip(ship);
        } else {
            throw new RuntimeException("Ship can't be added here!");
        }
    }

    public Player getHumanPlayer() {
        return this.human;
    }

    public Player getAIPlayer() {
        return this.computer;
    }

}
