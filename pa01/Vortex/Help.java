import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the help screen, which contains the navigation menu and a desicrption of the game.
 * 
 * @author (Eden Zik) 
 * @version (1.3)
 */
public class Help extends World
{

    /**
     * Constructor for objects of class Help.
     * 
     */
    public Help()
    {    
        super(600, 600, 1);                     // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

    }
    
    /**
     * This method changes the image of the navigiation menu to one that fits the screen it is in.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
