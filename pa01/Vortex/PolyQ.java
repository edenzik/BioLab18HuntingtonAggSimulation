import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PolyQ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PolyQ extends Protein
{
    PolyQ polyq = new PolyQ();
    protected void addedToWorld()
    {
        getWorld().addObject(polyq, getX()+5, getY()+5);
    }
    /**
     * Act - do whatever the PolyQ wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
