package heaa.battleship.model;

import java.util.List;
import java.util.Random;

public class AIPlayer extends Player {

    private Random random;

    public AIPlayer() {
        this.random = new Random();
    }

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

    public boolean isAlreadyShot(List<Position> shotPositions, Position position) {
        for (Position shotPosition : shotPositions) {
            if (position.equals(shotPosition)) {
                return true;
            }
        }
        return false;
    }

    public Position determinePositionToPut(Grid ownGrid) {
        int i = this.random.nextInt(ownGrid.getSize());
        int j = this.random.nextInt(ownGrid.getSize());
        return new Position(i, j);
    }

    public boolean determineAlignment() {
        return this.random.nextDouble() <= 0.49;
    }

}
