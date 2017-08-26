package heaa.battleship.model;
/**
 * 
 * Pelin asetukset sisältävä staattinen luokka.
 */

public class GameSettings {
    private int gridSize;
    private HumanPlayer humanPlayer;
    private AIPlayer aiPlayer;
    private static GameSettings instance;
    
    private GameSettings() {}
    
    public static GameSettings getInstance() {
        if(instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }
    
    public void setGridSize(int size) {
        this.gridSize = size;
    }
    public int getGridSize() {
        return gridSize;
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public void setHumanPlayer(HumanPlayer humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    public AIPlayer getAiPlayer() {
        return aiPlayer;
    }

    public void setAiPlayer(AIPlayer aiPlayer) {
        this.aiPlayer = aiPlayer;
    }
    
    
}
