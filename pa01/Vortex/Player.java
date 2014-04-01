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
    public static int speed = 100;
    public static int locX = 0;
    public static int locY = 0;
    
    public void act() 
    {
        control();
        this.locX=getX();
        this.locY=getY();
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
          GreenfootImage img = new GreenfootImage ("MagicSchoolBusRight.png");  
          img.mirrorVertically();
          setImage(img);
      }
      if (Greenfoot.isKeyDown("right")) 
      {
          setRotation(0);
          setImage("MagicSchoolBusRight.png");
      }
      if (Greenfoot.isKeyDown("up")) 
      {
          setRotation(270);
          setImage("MagicSchoolBusRight.png");
      }
      if (Greenfoot.isKeyDown("down")) 
      {
          setRotation(90);
          GreenfootImage img = new GreenfootImage ("MagicSchoolBusRight.png");  
          img.mirrorVertically();
          setImage(img);
          
      }
      if (getOneIntersectingObject(Molecule.class) == null) move(speed);
      if (Greenfoot.getKey()=="space")
      {
         if (getWorld().getObjects(Inhibitor.class).isEmpty())
         {
             Greenfoot.playSound("Missile.wav");
             getWorld().addObject(new Inhibitor(), getX(), getY());
             Inhibitor inhibitor = (Inhibitor) getOneObjectAtOffset(0, 0, Inhibitor.class);
             inhibitor.setRotation(getRotation());
      }
        
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
        speed = 5;
    }
    
    private boolean canMove()
    {
        return !(getX()>=getWorld().getWidth()-20 || getX()<=20 || getY()>=getWorld().getHeight()-20 || getY()<=20 && getOneIntersectingObject(Molecule.class) == null);
    }
   
}
