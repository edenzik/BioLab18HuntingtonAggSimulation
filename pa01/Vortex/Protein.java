import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Protein here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Protein extends Actor
{
    /**
     * Act - do whatever the Protein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    private void firedUpon()
    {
        Missile missile = (Missile) getOneIntersectingObject(Missile.class);
        getWorld().removeObject(missile);
        getWorld().addObject(new Explosion(), getX(), getY());
        addScore(((randX+randY)*randSpeed)/10);
        getWorld().removeObject(this);
    }
}
