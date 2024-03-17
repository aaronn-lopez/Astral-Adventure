public abstract class Alien extends Character {
    Alien(Transform transform, String spritePath) {
        super(transform, spritePath);
    }

    public abstract void decreaseOxygen();
}
