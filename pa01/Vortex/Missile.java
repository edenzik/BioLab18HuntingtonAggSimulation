import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the object fired by the player, which proceeds to leave the world once it is out of bounds.
 * 
 * @author (Eden Zik) 
 * @version (1.0)
 */
public class Missile extends Actor
{
    /**
     *This act method moves as long as it is within the bounds, at a speed three times faster than the players speed.
     *If it is out of bounds, it is removed from the world.
     */
    public void act() 
    {        
        Player player = (Player) getOneIntersectingObject(Player.class);
        int speed = player.speed;
        if (canMove(getX(), getY()))
        {
           move(speed*3);
        }
        else
        {
            getWorld().removeObject(this);
        }
    }
   
    /**
     * This method test if the missile is within the bounderies of the world. If not, it returns false and is removed.
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
}

