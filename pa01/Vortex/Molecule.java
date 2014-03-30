import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Protein here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Molecule extends Actor
{
    private int speed = 5;
    /**
     * Act - do whatever the Protein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(speed);
        
        
    }
    
    protected int getSpeed(){
        return speed;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    
}
