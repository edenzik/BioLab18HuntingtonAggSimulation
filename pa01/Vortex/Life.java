import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the life icon. It manages its actions as part of the game, but is the exact same object 
 * that keeps track of the life the player has.
 * 
 * @author (Eden Zik) 
 * @version (1.0)
 */
public class Life extends Actor
{
    /**
     * This method makes sure the player has a nonzero life count, and that the life's location is not
     * where the game stores the life the player has.
     * It also sets up a variable called duration, which manages how long it is going to stay on the board.
     * If player picks up life, it adds to the lift count and updates the life count, which removes itself.
     * If the player has more than 8 lives, it does nothing and removes itself.
     */
    int duration = 0;
    public void act() 
    {
        
        if ((Space.life >0) && (getY()!=30) && (getOneIntersectingObject(Player.class)!=null) && this!=null)
        {
            if (Space.life<8)
            {
            Space.life++;
            Space.modifyLife = true;
            }
            else
            {
                getWorld().removeObject(this);
            }
        }
        
        else if (getY()!=30) 
        {
        duration++;
        if (duration>750)
        {
            getWorld().removeObject(this);
        }
        }
    }   
}
