public abstract class Enemy extends Character {
    Enemy(Transform transform, String spritePath) {
        super(transform, spritePath);
    }

    public abstract void decreaseOxygen();
}
