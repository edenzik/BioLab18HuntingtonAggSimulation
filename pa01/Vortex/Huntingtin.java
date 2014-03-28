import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Huntingtin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Huntingtin extends Molecule
{
    protected void addedToWorld()
    {
        getWorld().addObject(new PolyQ(), getX()+10, getY()+10);
    }
    
    /**
     * Act - do whatever the Huntingtin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
}
