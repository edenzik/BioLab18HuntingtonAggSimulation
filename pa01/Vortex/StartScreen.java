import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the start screen, which holds the navigation menu (green text) and the game's logo.
 * 
 * @author (Eden Zik) 
 * @version (2.4)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        super(600, 600, 1);                 // Create a new world with 600x400 cells with a cell size of 1x1 pixels.3
        addObject(new Navigate(), 182, 460);   //Adds the start Object
    }

    /**
     * This resets the static variables in the game to their default positions.
     */

}
