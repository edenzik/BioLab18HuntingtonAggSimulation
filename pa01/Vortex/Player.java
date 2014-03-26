import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This Player is a spaceship which can turn in all four directions in order to get gold and avoid astroids.
 * It can shoot missiles when the user presses space, and move according to the arrow keys.
 * The player is affected by things such as black holes and other things, and followed by enemies.
 * Once the player enters a wormhole, it is the only thing which remains.
 * 
 * @author (Eden Zik) 
 * @version (1/24/13)
 */
public class Player extends Actor
{
    public static int speed = 2;
    public static int locX = 0;
    public static int locY = 0;
    
    public void act() 
    {
        control();
        locX=getX();
        locY=getY();
        edge();

    }  
    
    /**
     * This control method is the key controls for the player.
     * When a key is called, the Player is rotated in the direction of indented motion, and the image of the 
     * ship is mirrord. Then the spaceship moves according to the speeed variable.
     * When space is pressed, the ship fires a missile which orients itself according to the oreintation of the
     * spaceship.
     */
    public void control() {
      if (Greenfoot.isKeyDown("left")) 
      {
          setRotation(180);
          GreenfootImage img = new GreenfootImage ("SpaceshipRight.gif");  
          img.mirrorVertically();
          setImage(img);
          move(speed);
      }
      if (Greenfoot.isKeyDown("right")) 
      {
          setRotation(0);
          setImage("SpaceshipRight.gif");
          move(speed);
      }
      if (Greenfoot.isKeyDown("up")) 
      {
          setRotation(270);
          setImage("Spaceship.gif");
          move(speed);
      }
      if (Greenfoot.isKeyDown("down")) 
      {
          setRotation(90);
          setImage("Spaceship.gif");
          move(speed);
      }
      if (Greenfoot.getKey()=="space")
      {
         if (getWorld().getObjects(Missile.class).isEmpty())
         {
             Greenfoot.playSound("Missile.wav");
             getWorld().addObject(new Missile(), getX(), getY());
             Missile missile = (Missile) getOneObjectAtOffset(0, 0, Missile.class);
             missile.setRotation(getRotation());
      }
        
      }
      
    }
    
    /** 
     * This method reduces the health of the Player, and takes it out of the game if the health gets too low.
     * Once this method is initialized, an explosion is added at the location the player dies.
     * If the player's health is greater than 1, his location is randomized and a single health dot is reduced.
     * Otherwise, the player dies and GAME OVER is displayed.
     */
    public void damage()
    {
        World world = getWorld();
        world.addObject(new Explosion(), getX(), getY());
        
            if (Space.life>1)
            {
               Space.life--;
               Space.modifyLife = true;
               setLocation(Greenfoot.getRandomNumber(200)+100, Greenfoot.getRandomNumber(200)+100);
            }
            else {
                Space.life = 0;
                Space.modifyLife = true;
                world.addObject(new Navigate(), 300, 300);
                for (Object navigate : world.getObjects(Navigate.class))  
                {  
                ((Navigate) navigate).setImage("GameOver.png");   
                }  
                world.removeObject(this);
            }
        }
      
   /**
    * This method is called when the player reaches the edge of the screen, at which point he spawns at the opposite end.
    * This is to allow continues motion.
    */
    public void edge()
   {
        if (locX==0 || locX==599)
        {
            setLocation(600-locX, locY);
        }
        if (locY==0 || locY==599)
        {
            setLocation(locX, 600-locY);
        }
    }
    
    /** 
     * This method is enacted once the player is added to the world. It resets the static variable speed to the default 2.
     */
    protected void addedToWorld(World Space)
    {
        speed = 2;
    }
   
}
