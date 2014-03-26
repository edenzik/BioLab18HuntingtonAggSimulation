import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot) 

/**
 * This is World Space, where the game will take place. 
 * It features a moving background and populates the world, while keeping track of the score.
 * The first four static variables set up the moving background, which I modified based on code I found online.
 * Counter sets up the scorekeeper, while diff life and modify life set up the difficulty and life counters.
 * 
 * @author (Eden Zik) 
 * @version (1/24/13)
 */
public class Space extends World 
{ 
    /**Sets up background image*/
    private static final GreenfootImage bgImage = new GreenfootImage("space1.jpeg"); 
    /**Sets speed of motion*/
    private static final int scrollSpeed = 1;
    /**Makes variable scrollingImage*/
    private GreenfootImage scrollingImage;
    /**Sets default scroll position*/
    private int scrollPosition = 0;                                   
    
    /**Sets up counter variable*/
    private Counter theCounter;                                       
    
    /**diff increases at random times and makes enemies more frequent*/
    public static int diff = 1;
    /**life is a static variable with the initial number of lives*/
    public static int life = 5;   
    /**modify life can be affected by objects when the number of lives has been changed*/                   
    public static boolean modifyLife = true;                                            
    
    /**
     * The Space() method sets up the initial variables for the world. 
     * Super sets up world size.
     * setSpeed sets up the speed of the game.
     * Several background variables set up the background moving
     * Populate() sets up the initial population, spaceship included.
     */
    public Space()
    {
        super(600, 600, 1);                                         //Sets up the size of the world                               
        
        Greenfoot.setSpeed(50);                                     //Sets the speed for the gameplay
        
        GreenfootImage background = new GreenfootImage(600, 600);   //Sets up a new background to scroll
        scrollingImage = getScrollingImage(600, 600);               //Sets up scrollingImage
        background.drawImage(scrollingImage, 0, 0);                 //Fills scrollingImage on background
        setBackground(background);                                 
        
        populate();                                                 //Populates the world                                     
    }

    /**
     * The method puts initial objects in place, such as the player,
     * the NASA logo, and the counter
     */
    public void populate()                                       
    {
        addObject(new Player(), 350, 200);                          //Adds Player
        addObject(new NASA(), 300, 30);                             //Adds NASA logo on top
        theCounter = new Counter();                                 //Sets up counter
        addObject(theCounter, 30, 30);                              //Adds Counter
    }
    
    /**
     * Sets up the counter
     */
    public Counter getCounter()                                     //Counter Method                        
    {
        return theCounter;
    }

    /**
     * act() is a method which continously executes throughout the game.
     * Besides scrolling, it also introudces several elements into the game at random, 
     * Depending on the value of diff (the difficulty).
     */
    public void act()                                              
    {
        if(scrollSpeed > 0 && scrollPosition <= 0) {                //Scrolls width of screen
            scrollPosition = getWidth();
        }
        if(scrollSpeed < 0 && scrollPosition >= getWidth()) {
            scrollPosition = 0;
        }
        scrollPosition -= scrollSpeed;
        paint(scrollPosition);                                      //Continuesly scrolls
        
        if (modifyLife == true)                                     //If life is modified
        {
            removeObjects(getObjects(Life.class));                  //Remove all current Life.object
            addLives();                                             //Execute addlives method
            modifyLife = false;                                     //Once modification is done
        }
        
        addElements();                                              //Adds helpful/ enemy elements

        if (Greenfoot.getRandomNumber(1000)==1)                     //Increases the difficulty by 1 ever 10000 frames
        {
            diff++;
        }
        
        if (diff==499)                                              //Resets difficulty every 10000 frames
        {
            diff=1;
            addScore(500);
        }
    }
      
    /**
     * Adds objects at random depending on a certain constant.
     * If the object is helpful, diff decreases its frequency.
     * If the object is harmful, diff increases its frequency.
     */
    private void addElements()
    {
        randomLife(2000);                                       
        astroid(100);
        comet(500);
        gold(500);
        fuel(500);
        blackHole(2000);
        enemy(1000);
        wormhole(2000);
    }
    
    /**
     * Adds life icons at the top at 30 space incraments
     */
    private void addLives()
    {
        for (int i=0; i<life; i++)
        {
            addObject(new Life(), 570-i*30, 30);
        }
    }
    
    /**
     * Paint scrolling image at given position and make sure the rest of
     * the background is also painted with the same image.
     */
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(scrollingImage, position, 0);
        bg.drawImage(scrollingImage, position - scrollingImage.getWidth(), 0);
    }
 
    /**
     * Returns an image with the given dimensions.
     */
    private GreenfootImage getScrollingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x, y);
            }
        }
        return image;
    } 
    
    /**
     * Creates Comets coming from random locations in the game.
     * The likleyhood of a Coment depends on "chance" inserted into the method.
     */
    private void comet(int chance)
    {
        int rand = Greenfoot.getRandomNumber(4*chance);
        int loc = Greenfoot.getRandomNumber(600);
        switch (rand)
        {
            case 1: addObject(new Comet(), loc, 30);
                    break;
            case 2: addObject(new Comet(), 30, loc);
                    break;
            case 3: addObject(new Comet(), loc, 570);
                    break;
            case 4: addObject(new Comet(), 570, loc);
                    break;
        }
        
    }
    
    /**
     * Creates Astroids coming from random locations in the game.
     * The likleyhood of a coment depends on "chance" inserted into the method.
     */
    private void astroid(int chance)
    {
        int rand = Greenfoot.getRandomNumber(4*chance);
        int loc = Greenfoot.getRandomNumber(600);
        switch (rand)
        {
            case 1: addObject(new Astroid(), loc, 30);
                    break;
            case 2: addObject(new Astroid(), 30, loc);
                    break;
            case 3: addObject(new Astroid(), loc, 570);
                    break;
            case 4: addObject(new Astroid(), 570, loc);
                    break;
        }
        
    }

    /**
     * Creates blackholes appearing at random locations in the game.
     * The likleyhood of a black hole depends on "chance" inserted into the method.
     */
    private void blackHole(int chance)
    {
        int rand = Greenfoot.getRandomNumber(chance);
        int locX = Greenfoot.getRandomNumber(540) + 30;
        int locY = Greenfoot.getRandomNumber(540) + 30;
        if (rand==1)
        {
            addObject(new BlackHole(), locX, locY);

        }
        
    }
    
    /**
     * Creates gold appearing at random locations in the game.
     * The likleyhood of gold depends on "chance" inserted into the method.
     */
    private void gold(int chance)
    {
        int rand = Greenfoot.getRandomNumber(chance);
        int locX = Greenfoot.getRandomNumber(540) + 30;
        int locY = Greenfoot.getRandomNumber(540) + 30;
        if (rand==1)
        {
            addObject(new Gold(), locX, locY);
        }
        
    }
    
    /**
     * Creates fuel appearing at random locations in the game.
     * The likleyhood of fuel depends on "chance" inserted into the method.
     */
    private void fuel(int chance)
    {
        int rand = Greenfoot.getRandomNumber(chance);
        int locX = Greenfoot.getRandomNumber(540) + 30;
        int locY = Greenfoot.getRandomNumber(540) + 30;
        if (rand==1)
        {
            addObject(new Fuel(), locX, locY);

        }
        
    }
    
    /**
     * Creates a random life object appearing at random locations in the game.
     * The likleyhood of a life object depends on "chance" inserted into the method.
     */
    private void randomLife(int chance)
    {
        int rand = Greenfoot.getRandomNumber(chance);
        int locX = Greenfoot.getRandomNumber(540) + 30;
        int locY = Greenfoot.getRandomNumber(540) + 50;
        if (rand==1)
        {
            addObject(new Life(), locX, locY);
        }
        
    }
   
    /**
     * Creates a wormhole appearing at random locations in the game.
     * The likleyhood of a wormhole depends on "chance" inserted into the method.
     */
    private void wormhole(int chance)
    {
        int rand = Greenfoot.getRandomNumber(chance);
        int locX = Greenfoot.getRandomNumber(540) + 30;
        int locY = Greenfoot.getRandomNumber(540) + 30;
        if (rand==1 && getObjects(Wormhole.class).isEmpty())
        {
            addObject(new Wormhole(), locX, locY);
        }
        
    }
    
    /**
     * Creates an enemy coming from random locations in the game.
     * The likleyhood of an enemy depends on "chance" inserted into the method.
     */
    private void enemy(int chance)
    {
        int rand = Greenfoot.getRandomNumber(4*chance);
        int loc = Greenfoot.getRandomNumber(600);
        switch (rand)
        {
            case 1: addObject(new Enemy(), loc, 30);
                    break;
            case 2: addObject(new Enemy(), 30, loc);
                    break;
            case 3: addObject(new Enemy(), loc, 570);
                    break;
            case 4: addObject(new Enemy(), 570, loc);
                    break;
        }
        
    }
    
    /**
     * Adds "num" points to the scoreboard.
     */
    private void addScore(int num)
    {
        Counter counter = getCounter();
        counter.bumpCount(num);
    }
}

