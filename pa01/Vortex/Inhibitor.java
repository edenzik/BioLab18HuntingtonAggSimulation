import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inhibitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inhibitor extends Actor
{
    /**
     * Act - do whatever the Inhibitor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Player player = (Player) getOneIntersectingObject(Player.class);
        int speed = player.speed;
        if (canMove(getX(), getY()))
        {
           move(speed*3);
        }
        else
        {
            getWorld().removeObject(this);
        }
    }   
    
    private boolean canMove(int x, int y)
    {
        return !(x>=getWorld().getWidth()-20 || x<=20 || y>=getWorld().getHeight()-20 || y<=20);
    }
}



