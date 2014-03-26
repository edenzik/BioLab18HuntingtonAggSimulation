import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This is the counter method, which keeps track of the score the player has.
 * 
 * @author (Eden Zik) 
 * @version (1.0)
 */
public class Counter  extends Actor
{
    private int totalCount = 0;

    public Counter()
    {
        setImage(new GreenfootImage("0", 20, Color.WHITE, Color.BLACK));
    }

    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        if (Space.life>0)
        {
        totalCount += amount;
        }
        setImage(new GreenfootImage("" + totalCount, 20, Color.WHITE, Color.BLACK));
    }
}
