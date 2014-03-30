import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PolyQ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PolyQ extends Molecule
{
  private Huntingtin father;
    protected void addedToWorld(World world)
    {
        GreenfootImage img = getImage();
        img.scale(img.getWidth()/20,img.getHeight()/20);
        setImage(img);
    }
    
  public void act() 
    {
        move(getSpeed());
        setRotation(getFather().getRotation());
        if (isTouching(PolyQ.class) && Greenfoot.getRandomNumber(100)<10){
            PolyQ touchingChain = (PolyQ) getOneIntersectingObject(PolyQ.class);
            getFather().setIsAgg(true);
            Huntingtin newFather = touchingChain.getFather();
            newFather.setIsAgg(true);
        if (!newFather.equals(getFather()) && newFather.getRotation()-getFather().getRotation()<=1)
        {
            
            int newRotation = 90;
            int newSpeed = 1;
            newFather.setSpeed(newSpeed);
            setRotation(newRotation);
            getFather().setRotation(newRotation);
            getFather().setChainRotation(newRotation);
            setSpeed(newSpeed);
            getFather().setSpeed(newSpeed);
            getFather().setChainSpeed(newSpeed);
        }
            
            
        }
    }
    
  public void setFather(Huntingtin father){
      this.father = father;
  }
  
  public Huntingtin getFather(){
      return this.father;
  }
    
}
