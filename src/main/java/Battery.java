public class Battery extends Collectable{
    Battery(Transform transform){
        super(transform, "src/main/Sprites/Battery.png");
    }

    //Increase score by 100 points and add to total collected batteries
    @Override
    public void collect() {
        GameManager.gameManager.baseScore += 100;
        GameManager.gameManager.completionCount++;
    }
}
