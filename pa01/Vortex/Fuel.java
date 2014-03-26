import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is fuel, adds speed to the player
 * 
 * @author (Eden Zik) 
 * @version (1.2)
 */
public class Fuel extends Actor
{
    /**
     * Starts a random size, grows.
     * If it gets too small, disappears.
     */
    int rand = Greenfoot.getRandomNumber(99)+1;
    int sizeFactor = 0;
    public void act() 
    {
        turn(10);
        consume();
        if (rand-sizeFactor<=1)
        {
            getWorld().removeObject(this);
        }
        if (Greenfoot.getRandomNumber(100)<10)
        {
            getImage().scale(rand-sizeFactor, rand-sizeFactor);
            sizeFactor++;
        }

        
    }
    
    /**
     * Sets the scale to the random value
     */
    protected void addedToWorld(World Space)
    {
       getImage().scale(rand, rand);
    }
    
    /**
     * Adds speed to the player once it is consumed.
     */
    private void consume()
    {
            Player player = (Player) getOneObjectAtOffset(0, 0, Player.class);
            if (player != null) {
               if ((Greenfoot.getRandomNumber(99)+1)<=(rand-sizeFactor))
               {
               player.speed++;
            }
            Greenfoot.playSound("Fuel.wav");   
            getWorld().removeObject(this);
            }
    }
    
}
