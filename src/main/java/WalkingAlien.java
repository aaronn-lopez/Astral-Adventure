public class WalkingAlien extends Alien{
    WalkingAlien(Transform transform){
        super(transform, "src/main/Sprites/Battery.png");
        dir = Directions.Right;
    }

    public Directions dir;
    void Patrol(){
        if(!move(dir)){
            switch(dir){
                case Directions.Up:
                    dir = Directions.Down;
                    break;
                case Directions.Down:
                    dir = Directions.Up;
                    break;
                case Directions.Right:
                    dir = Directions.Left;
                    break;
                case Directions.Left:
                    dir = Directions.Right;
                    break;
                default:
                    break;
            }
        }
    }
}
