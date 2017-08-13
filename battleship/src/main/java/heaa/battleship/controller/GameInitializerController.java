package heaa.battleship.controller;

import heaa.battleship.util.NavyTool;
import heaa.battleship.util.ShipBuilder;
import heaa.battleship.model.AIPlayer;
import heaa.battleship.model.Grid;
import heaa.battleship.model.HumanPlayer;
import heaa.battleship.model.Player;
import heaa.battleship.model.Position;
import heaa.battleship.model.Ship;
import java.util.List;
import java.util.Stack;

public class GameInitializerController {

    private AIPlayer computer;
    private HumanPlayer human;

    public void startGame() {
        this.computer = new AIPlayer();
        this.human = new HumanPlayer();
        Grid humanGrid = new Grid(NavyTool.createNavy());
        Grid aiGrid = new Grid(NavyTool.createNavy());
        humanGrid.setGridSize(10);
        aiGrid.setGridSize(10);
        this.human.setGrid(humanGrid);
        this.computer.setGrid(aiGrid);
        this.setAIShipsToGrid(this.computer, ShipBuilder.createStackOfShipLengths());
    }

    public void setAIShipsToGrid(AIPlayer computer, Stack<Integer> shipLengths) {
        while (!shipLengths.empty()) {
            try {
                addShipToGrid(
                        computer.getGrid(),
                        computer.determinePositionToPut(computer.getGrid()),
                        shipLengths.peek(),
                        computer.determineAlignment());
                shipLengths.pop();
            } catch (RuntimeException e) {
            }
        }
    }

    public void addShipToGrid(Grid grid, Position place, Integer shipLength, boolean horizontal) {
        List<Position> desiredPositions = ShipBuilder.buildDesiredPositions(shipLength, horizontal, place);

        if (grid.getNavy().canShipBeAdded(desiredPositions)) {
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
