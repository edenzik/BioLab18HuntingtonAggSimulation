import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is Gold, which adds points to the player.
 * 
 * @author (Eden Zik) 
 * @version (1.2)
 */
public class Gold extends Actor
{
    /**
     * Starts out a random size, disappears once it gets too small.
     */
    int rand = Greenfoot.getRandomNumber(99)+1;
    int pointFactor = 0;
    public void act() 
    {
        turn(10);
        consume();
        if (rand-pointFactor<=1)
        {
            getWorld().removeObject(this);
        }
        if (Greenfoot.getRandomNumber(100)<10)
        {
            getImage().scale(rand-pointFactor, rand-pointFactor);
            pointFactor++;
        }

        
    }
    
    /**
     * Sets the scale at whatever random size was deicded upon.
     */
    protected void addedToWorld(World Space)
    {
       getImage().scale(rand, rand);
    }
    
    /**
     * Deletes itself once it is consumed.
     */
    private void consume()
    {
        Player player = (Player) getOneObjectAtOffset(0, 0, Player.class);
        if (player != null) {
          Greenfoot.playSound("Fuel.wav");   
          addPoints();
          getWorld().removeObject(this);
        }
    }
    
    /**
     * Adds points to the player according to the current size.
     */
    private void addPoints()
    {
        Space spaceWorld = (Space) getWorld();
        Counter counter = spaceWorld.getCounter();
        counter.bumpCount(rand-pointFactor);
    }
}
