package heaa.battleship.model;
/**
 * 
 * Pelin asetukset sisältävä staattinen luokka.
 */

public class GameSettings {
    private static int gridSize;
    private static HumanPlayer humanPlayer;
    private static AIPlayer aiPlayer;
    
    private GameSettings() {}
    
    public static void setGridSize(int size) {
        gridSize = size;
    }
    public static int getGridSize() {
        return gridSize;
    }

    public static HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public static void setHumanPlayer(HumanPlayer humanPlayer) {
        GameSettings.humanPlayer = humanPlayer;
    }

    public static AIPlayer getAiPlayer() {
        return aiPlayer;
    }

    public static void setAiPlayer(AIPlayer aiPlayer) {
        GameSettings.aiPlayer = aiPlayer;
    }
    
    
}
