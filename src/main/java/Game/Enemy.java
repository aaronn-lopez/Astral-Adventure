package Game;

import Game.GameManager;

/**
 * <p>Abstract 'enemy' class for any entity that can cause damage to the player.</p>
 */
public abstract class Enemy extends Character {
    Enemy(Transform transform, String spritePath) {
        super(transform, spritePath);
    }

    /**
     * <p>Abstract method called on collision with player.</p>
     */
    public abstract void decreaseOxygen();

    @Override
    public void onHit() {
        GameManager.gameManager.enemies.remove(this);

        decreaseOxygen();

        Cell currentCell = GameManager.getCell(GameManager.gameManager.player.Transform.gridX, GameManager.gameManager.player.Transform.gridY);
        currentCell.enemy = null;
    }
}
