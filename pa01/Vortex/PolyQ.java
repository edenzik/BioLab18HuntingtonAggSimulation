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
  int counter = 0;
    protected void addedToWorld(World world)
    {
        GreenfootImage img = getImage();
        img.scale(img.getWidth(),img.getHeight());
        setImage(img);
    }
    
  public void act() 
    {
        if(!this.getFather().getIsAgg())
        {
            move(getSpeed());
            setRotation(getFather().getRotation());
        }
        if(!this.getFather().getIsInhibited())
        {
            if (this.isTouching(PolyQ.class)){
                PolyQ touchingChain = (PolyQ) getOneIntersectingObject(PolyQ.class);
                Huntingtin newFather = touchingChain.getFather();
                if(!newFather.equals(this.getFather()) && !newFather.getIsInhibited() && newFather.getRotation()-getFather().getRotation()<=30)
                {
                    counter++;
                    System.out.println("here "+counter);
                    getFather().setIsAgg(true);
                    newFather.setIsAgg(true);
                   if (!newFather.equals(getFather()) )
                    {
                        
                        int newRotation = 90;
                        //int newSpeed = 0;
                        //newFather.setSpeed(newSpeed);
                        setRotation(newRotation);
                        getFather().setRotation(newRotation);
                        getFather().setChainRotation(newRotation);
                       // setSpeed(newSpeed);
                        //getFather().setSpeed(newSpeed);
                        //getFather().setChainSpeed(newSpeed);
                    }
                }
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
