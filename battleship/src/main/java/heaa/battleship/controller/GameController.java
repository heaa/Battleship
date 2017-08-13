
package heaa.battleship.controller;

import heaa.battleship.model.AIPlayer;
import heaa.battleship.model.HumanPlayer;
import heaa.battleship.model.Position;



public class GameController {
    private HumanPlayer human;
    private AIPlayer computer;
    
    
    public void playTurn(Position position) {
        computer.getGrid().shootGrid(position);
        
    }
    
    public void playAITurn() {
        // Do AI magic here or in the AI player model :)
        // Which is like: 
        Position position = computer.determineWhereToShoot(human.getGrid());
        human.getGrid().shootGrid(position);
    }
    
    
    
}
