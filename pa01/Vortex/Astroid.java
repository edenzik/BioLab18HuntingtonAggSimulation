import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is an astroid of random dimensions and random speed that comes out of one place and does not change direction.
 * 
 * @author (Eden Zik) 
 * @version (4.0)
 */
public class Astroid extends Actor
{
    /**
     * Creates a random X and a random Y, which are the dimensinos of the astroid. 
     * Then it generates a random speed that is up to twice the speed of the player.
     */
    int randX = Greenfoot.getRandomNumber(90)+10;
    int randY = Greenfoot.getRandomNumber(90)+10;
    int randSpeed = Greenfoot.getRandomNumber(Player.speed*2)+1;
    
    /**
     * This act method continously checks if the astroid is in bounds. If not, it deletes itself.
     * If it gets hit by a missile it removes itself from the game.
     * If it hits another astroid, it explodes and removes both from the game
     * If it hits the player it initiates an explosion and damages the player, and then removes itself.
     * 
     */
    public void act() 
    {
    if (canMove(getX(), getY()))
      {
        move(randSpeed); 
        if (getOneIntersectingObject(Missile.class)!=null)
        {
            firedUpon();
        }
        else if (getOneIntersectingObject(Astroid.class)!=null)
        {
            collide();
        }
        else if (getOneIntersectingObject(Player.class)!=null)
        {
            hurt();
        }
      }
      else
      {
          addScore(((randX+randY)*randSpeed)/20);
          getWorld().removeObject(this);
       }
    }
    
    /**
     * If it gets hit by a missile, it explodes and removes itself from the game along with the missile.
     */
    private void firedUpon()
    {
        Missile missile = (Missile) getOneIntersectingObject(Missile.class);
        getWorld().removeObject(missile);
        getWorld().addObject(new Explosion(), getX(), getY());
        addScore(((randX+randY)*randSpeed)/10);
        getWorld().removeObject(this);
    }
    
    /**
     * If the astroid collides with another astroid, it explodes and removes itself from the game.
     */
    private void collide()
    {
       getWorld().addObject(new Explosion(), getX(), getY());
       getWorld().removeObject(getOneIntersectingObject(Astroid.class));
       getWorld().removeObject(this);
    }
    
    /**
     * If the astroid hits a player, it damages the player and removes itself from the game.
     */
    private void hurt()
    {
        Player player = (Player) getOneIntersectingObject(Player.class);
        player.damage();
        getWorld().removeObject(this);
     }

     /**
      * Method which checks if the astroid is within the bounderies of the screen.
      */
    private boolean canMove(int x, int y)
    {
        if (x>=getWorld().getWidth()-20 || x<=20 || y>=getWorld().getHeight()-20 || y<=20) {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * Sets the astroid to a random size once it is added, and orients itself the opposite direction from which it came
     */
    protected void addedToWorld(World Space)
    {
        getImage().scale(randX, randY);  
        turnTowards(600-getX(), 600-getY());
    }
    
    /**
     * This method adds points to the player.
     */
    private void addScore(int num)
    {
        Space spaceWorld = (Space) getWorld();
        Counter counter = spaceWorld.getCounter();
        counter.bumpCount(5);
    }

}
