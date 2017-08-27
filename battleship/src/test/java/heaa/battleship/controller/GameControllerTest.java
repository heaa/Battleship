
package heaa.battleship.controller;

import heaa.battleship.exception.AlreadyShotException;
import heaa.battleship.exception.GameEndedException;
import heaa.battleship.model.AIPlayer;
import heaa.battleship.model.GameSettings;
import heaa.battleship.model.Grid;
import heaa.battleship.model.HumanPlayer;
import heaa.battleship.model.Navy;
import heaa.battleship.model.Position;
import heaa.battleship.model.Ship;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class GameControllerTest {
    private HumanPlayer human;
    private AIPlayer computer;
    private GameController controller;
    
    @Before
    public void setUp() {      
        this.controller = new GameController();
        this.human = new HumanPlayer();
        this.computer = new AIPlayer();
        this.controller.setHuman(human);
        this.controller.setComputer(computer);
        Ship testShip1 = new Ship(1);
        Ship testShip2 = new Ship(2);
        List<Position> testShip1Positions = new ArrayList();
        testShip1Positions.add(new Position(1,1));
        testShip1.setPositions(testShip1Positions);
        
        List<Position> testShip2Positions = new ArrayList();
        testShip2Positions.add(new Position(2,2));
        testShip2.setPositions(testShip2Positions);
        
        Navy humanNavy = new Navy();
        Navy computerNavy = new Navy();
        humanNavy.addShip(testShip1);
        humanNavy.addShip(testShip2);
        
        computerNavy.addShip(testShip1);
        computerNavy.addShip(testShip2);
        
        Grid humanGrid = new Grid(humanNavy);
        Grid computerGrid = new Grid(computerNavy);
        this.human.setGrid(humanGrid);
        this.computer.setGrid(computerGrid);
        humanGrid.setGridSize(10);
        computerGrid.setGridSize(10);
    }
    
    @Test
    public void playTurnTest() {
        Position shootingPosition = new Position(1,1);
        this.controller.playTurn(shootingPosition);
        assertEquals(1, this.computer.getGrid().getNavy().getShips().size());
    }
    @Test(expected = GameEndedException.class)
    public void gameEndsTest() {
        Position shootingPosition1 = new Position(1,1);
        Position shootingPosition2 = new Position(2,2);
        this.controller.playTurn(shootingPosition1);
        this.controller.playTurn(shootingPosition2);
    }
    @Test(expected = AlreadyShotException.class) 
    public void alreadyShotTest() {
        Position shootingPosition1 = new Position(3,3);
        this.controller.playTurn(shootingPosition1);
        this.controller.playTurn(shootingPosition1);
    }
}
