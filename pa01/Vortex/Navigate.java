import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the navigation menu
 * 
 * @author (Eden Zik) 
 * @version (3.0)
 */
public class Navigate extends Actor
{
    /**
     * This is the method that you can use to navigate.
     * If the player presses a button, screen changes.
     */
    public void act() 
    {

        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Cell());
        }
        
        if (Greenfoot.isKeyDown("H"))
        {
            Greenfoot.setWorld(new Help());
        }
       
        if (Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(new StartScreen());// Add your action code here.
        }
       
        if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new StartScreen());// Add your action code here.
        }
    }    
}
