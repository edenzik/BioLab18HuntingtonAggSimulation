import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a comet which comes out of somewhere, and acts similar to an astroid but moves faster.
 * 
 * @author (Eden Zik) 
 * @version (1.0)
 */
public class Comet extends Actor
{
    /**
     * The comet generates a random size and a random speed.
     * If it can move, it moves until it intersects with a player, a missile, itself, or an astroid
     */
    int randSize = Greenfoot.getRandomNumber(50)+10;
    int randSpeed = Greenfoot.getRandomNumber(Player.speed*2)+9;
    public void act() 
    {
    
    if (canMove(getX(), getY()))
      {
        move(randSpeed); 
        if (getOneIntersectingObject(Missile.class)!=null)
        {
            fire();
        }
        else if (getOneIntersectingObject(Astroid.class)!=null)
        {
            collideWithAstroid();
        }
        else if (getOneIntersectingObject(Comet.class)!=null)
        {
            collideWithComet();
        }
        else if (getOneIntersectingObject(Player.class)!=null)
        {
            hurt();
        }
      }
      else
      {
          addScore(((2*randSize)*randSpeed)/20);
          getWorld().removeObject(this);
       }
    }
    
    /**
     * If a missile hits it, it explodes and vanishes along with the missile.
     */
    private void fire()
    {
        Missile missile = (Missile) getOneIntersectingObject(Missile.class);
        getWorld().removeObject(missile);
        getWorld().addObject(new Explosion(), getX(), getY());
        addScore(((randSize*2)*randSpeed)/10);
        getWorld().removeObject(this);
    }
    
    /** 
     * If it collides with an astroid it disappears after an explosion.
     */
    private void collideWithAstroid()
    {
        Astroid astroid = (Astroid) getOneIntersectingObject(Astroid.class);
        getWorld().removeObject(astroid);
        getWorld().addObject(new Explosion(), getX(), getY());
        getWorld().removeObject(this);
     }
    
     /**
      * If it collides with another comet it disappears.
      */
     private void collideWithComet()
    {
       getWorld().addObject(new Explosion(), getX(), getY());
       getWorld().removeObject(getOneIntersectingObject(Comet.class));
       getWorld().removeObject(this);
     }
     
     /**
      * Damages the player if it hits, then removes itself.
      */
    private void hurt()
    {
        Player player = (Player) getOneIntersectingObject(Player.class);
        player.damage();
        getWorld().removeObject(this);
     }

     /**
      * If can move, it will keep moving.
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
     * Once added, it turns in a random direction and goes in a random size.
     */
    protected void addedToWorld(World Space)
    {
        getImage().scale(randSize, randSize);  
        turnTowards(Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
    }
    
    /**
     * Adds score to the player.
     */
    private void addScore(int num)
    {
        Space spaceWorld = (Space) getWorld();
        Counter counter = spaceWorld.getCounter();
        counter.bumpCount(num);
    }

}
