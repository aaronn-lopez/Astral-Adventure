public abstract class Character extends Gameobject{
    Character(Transform transform, String spritePath){
        super(transform, spritePath);
    }

    void move(){};
}
