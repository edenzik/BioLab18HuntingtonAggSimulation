import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a wormhole, which erases everything besides the player and the lives on the board.
 * This creates the illusion the player is in a different part of the universe.
 * 
 * @author (Eden Zik) 
 * @version (1.2)
 */
public class Wormhole extends Actor
{
    /**
     * This act method first spins the wormhole around to create a nice spinning illusion.
     * Then if the player lands on it it removes all the objects on the board but the life object, and adds 20 points.
     * Then it removes itself.
     */
    public void act() 
    {
        turn(3);
        if (getOneIntersectingObject(Player.class)!=null)
        {
            World world = getWorld();
            world.removeObjects(world.getObjects(Astroid.class));
            world.removeObjects(world.getObjects(Comet.class));
            world.removeObjects(world.getObjects(Gold.class));
            world.removeObjects(world.getObjects(Fuel.class));
            world.removeObjects(world.getObjects(BlackHole.class));
            world.removeObjects(world.getObjects(Enemy.class));
            Greenfoot.playSound("Wormhole.wav");
            addScore(20);
            world.removeObject(this);
        }
    }    

    /**
     * This method adds points to the player.
     */
    private void addScore(int num)
    {
        Space spaceWorld = (Space) getWorld();
        Counter counter = spaceWorld.getCounter();
        counter.bumpCount(num);
    }
}
