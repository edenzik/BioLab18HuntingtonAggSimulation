import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot) 
import java.util.*;

/**
 * This is World Space, where the game will take place. 
 * It features a moving background and populates the world, while keeping track of the score.
 * The first four static variables set up the moving background, which I modified based on code I found online.
 * Counter sets up the scorekeeper, while diff life and modify life set up the difficulty and life counters.
 * 
 * @author (Eden Zik) 
 * @version (1/24/13)
 */
public class Cell extends World 
{ 
    /**
     * The Space() method sets up the initial variables for the world. 
     * Super sets up world size.
     * setSpeed sets up the speed of the game.
     * Several background variables set up the background moving
     * Populate() sets up the initial population, spaceship included.
     */
    public Cell()
    {
        super(600,600,1);                                         //Sets up the size of the world                               
        
        Greenfoot.setSpeed(50);                                     //Sets the speed for the gameplay                            
        
        populate();                                                 //Populates the world                                     
    }

    /**
     * The method puts initial objects in place, such as the player,
     * the NASA logo, and the counter
     */
    public void populate()                                       
    {
        addObject(new Player(), 350, 200);                          //Adds Player
    }
    /**
     * act() is a method which continously executes throughout the game.
     * Besides scrolling, it also introudces several elements into the game at random, 
     * Depending on the value of diff (the difficulty).
     */
    public void act()
    {
        List<Huntingtin> objectList = getObjects(Huntingtin.class);
        for (Huntingtin a: objectList){
            if (!canMove(a.getX(),a.getY()) && a.getIsAgg()==false)
            {
                a.removeChain();
                removeObject(a);
            }
        }
        if (Greenfoot.getRandomNumber(1000)<30) addElements();
        
    }
      
    /**
     * Adds objects at random depending on a certain constant.
     * If the object is helpful, diff decreases its frequency.
     * If the object is harmful, diff increases its frequency.
     */
    private void addElements()
    {
        addObject(new Huntingtin(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }
    
    private boolean canMove(int x, int y)
    {
        return !(x>=getWidth()-1 || x<=1 || y>=getHeight()-1 || y<=1);
    }
}

