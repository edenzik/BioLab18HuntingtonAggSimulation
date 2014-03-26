import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is an enemy which follows the player in an attempt to collide with it and kill it.
 * 
 * @author (Eden Zik) 
 * @version (1.0)
 */
public class Enemy extends Actor
{
    /**
     * The enemy uses the player's variable, locX and locY, to turn intself towards the player.
     * The enemy moves at 1 less than the speed of the player.
     * If the enemy gets hit by a missile, it dies.
     * If the enemy gets hit by an astroid, it dies
     * If the enemy gets hit by the player, it dies.
     * If the enemy collides with another enemy, it dies.
     * If the enemy collides with a comet, it dies.
     */
    public void act() 
    {
     if (canMove(getX(), getY()))
      {
        turnTowards(Player.locX, Player.locY);
        move(Player.speed-1); 
        if (getOneIntersectingObject(Missile.class)!=null)
        {
            firedUpon();
        }
        else if (getOneIntersectingObject(Astroid.class)!=null)
        {
            hitByAstroid();
        }
        else if (getOneIntersectingObject(Player.class)!=null)
        {
            hurtPlayer();
        }
        else if (getOneIntersectingObject(Enemy.class)!=null)
        {
            collide();
        }
        
        else if (getOneIntersectingObject(Comet.class)!=null)
        {
            hitByComet();
        }
      }
      else
      {
          addScore(20);
          getWorld().removeObject(this);
       }
    } 
    
    /**
     * If the enemy gets hit by a missile, it proceeds to remove the missile and explode.
     * Then it adds points to the counter and removes itself.
     */
        private void firedUpon()
    {
        Missile missile = (Missile) getOneIntersectingObject(Missile.class);
        getWorld().removeObject(missile);
        explode();
        addScore(100);
        getWorld().removeObject(this);
    }
    
    /**
     * Enemy removes astroid, explodes, removes itself.
     */
    private void hitByAstroid()
    {
        getWorld().removeObject(getOneIntersectingObject(Astroid.class));
        explode();
        getWorld().removeObject(this);
    }

    /**
     * Enemy damages player by calling the player damage method, then removes self.
     */
    private void hurtPlayer()
    {
        Player player = (Player) getOneIntersectingObject(Player.class);
        player.damage();
        getWorld().removeObject(this);
    }
     
    /**
     * Enemy removes other enemy, explodes, removes self.
     */
    private void collide()
    {
       getWorld().removeObject(getOneIntersectingObject(Enemy.class));
       explode();
       getWorld().removeObject(this);
    }
    
    /**
     * Enemy removes comet, explodes, removes self.
     */
    private void hitByComet()
    {
       getWorld().removeObject(getOneIntersectingObject(Comet.class));
       explode();
       getWorld().removeObject(this);
    }
    
    /**
     * This method test if the enemy is within the bounderies of the world. If not, it returns false and is removed.
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
     * This method adds an explosion at the current location.
     */
    private void explode() 
    {
        getWorld().addObject(new Explosion(), getX(), getY());
    }
    
    /**
     * This method adds points to the player.
     */
    private void addScore(int num)
    {
        Space spaceWorld = (Space) getWorld();
        Counter counter = spaceWorld.getCounter();
        counter.bumpCount(num);
    }
}
