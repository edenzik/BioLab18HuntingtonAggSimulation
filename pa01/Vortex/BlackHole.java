import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The blackhole attracts the player towards it.
 * 
 * @author (Eden Zik) 
 * @version (1.0)
 */
public class BlackHole extends Actor
{
    /**
     * This randomizes the size of the blackhole.
     * Then if the player has life and is in range, it moves the player towards it.
     * Shrinks the hole over time
     */
    int rand = Greenfoot.getRandomNumber(99)+1;
    int sizeFactor = 0;
    public void act() 
    {
        turn(10);
       if (Space.life !=0 && getObjectsInRange((rand-sizeFactor)/2, Player.class)!=null)
       {
       java.util.List objects = getWorld().getObjects(Player.class); 
       Player player = (Player) objects.get(0);
       player.turnTowards(getX(), getY());
       player.move(1);
       }
       
        if (rand-sizeFactor<=10)
        {
            getWorld().removeObject(this);
        }
        if (Greenfoot.getRandomNumber(100)<20)
        {
            getImage().scale(rand-sizeFactor, rand-sizeFactor);
            sizeFactor++;
        }

    }    
    
    /**
     * Makes the blackhole a certain size.
     */
    protected void addedToWorld(World Space)
    {
       getImage().scale(rand, rand);
    }
}
