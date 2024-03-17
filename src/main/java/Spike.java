public class Spike extends Alien{
    Spike(Transform transform){
        super(transform, "src/main/Sprites/Spike.png");
    }

   //If you hit a spike your oxygen decreases by 5% or 5 seconds
    @Override
    public void decreaseOxygen() {
        GameManager.gameManager.oxygen -= 480;
    }
}
