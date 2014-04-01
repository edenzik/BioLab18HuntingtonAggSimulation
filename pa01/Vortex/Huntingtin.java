import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Huntingtin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Huntingtin extends Molecule
{
    private boolean isAgg = false;
    private boolean isInhibited = false;
    private int polyQNum = 3;
    private int chainOrientationX = randomPositive();
    private int chainOrientationY = randomPositive();
    private int maxLength = 12;
    private int chainDistanceX = Greenfoot.getRandomNumber(maxLength)+4;
    private int chainDistanceY = maxLength - chainDistanceX;
    private List<PolyQ> chainList = new ArrayList<PolyQ>();
    
    public void act() 
    {
        if(!this.getIsAgg())
        {
            move(speed);
            bounce();
        }
    }
    
    public void bounce()
    {
        World world = this.getWorld();
        int h = world.getHeight();
        int w = world.getWidth();
        if(this.getX()<=0 || this.getX()+this.getImage().getWidth()/3 >= w || this.getY()<= 0 || this.getY() + this.getImage().getHeight()/3>=h)
        {
            if(this.isInhibited)
            {
                for(PolyQ pq: chainList)
                {
                    world.removeObject(pq);
                }
                world.removeObject(this);
            }
            else
            {
                this.setRotation(this.getRotation()-70);
            }
        }
    }
    
    protected void addedToWorld(World world)
    {
        GreenfootImage img = getImage();
        img.scale(img.getWidth(),img.getHeight());
        img.rotate(Greenfoot.getRandomNumber(360));
        setRotation(Greenfoot.getRandomNumber(360));
        
        Cell c = (Cell) this.getWorld();
        
        polyQNum = c.numPolyQ;
        
        for (int i=1; i<=polyQNum; i++){
            PolyQ polyq = new PolyQ();
            chainList.add(polyq);
            getWorld().addObject(polyq, getX()+i*chainDistanceX*chainOrientationX, getY()+i*chainDistanceY*chainOrientationY);
            polyq.setFather(this);
        }
        setImage(img);
    }
    
    private int randomPositive(){
        int num = Greenfoot.getRandomNumber(100);
        if (num>50){
            return 1;
        }
        return -1;
    }
    
    public void setChainRotation(int rotation){
        for (PolyQ chain : chainList){
            chain.setRotation(rotation);
        }
    }
    
    public void setChainSpeed(int speed){
        for (PolyQ chain : chainList){
            chain.setSpeed(speed);
        }
    }
    
    public void removeChain(){
        for (PolyQ chain : chainList){
            getWorld().removeObject(chain);
        }
    }
    
    public boolean getIsAgg(){
        return isAgg;
    }
    
    public void setIsAgg(boolean isAgg){
        this.isAgg = isAgg;
    }
    
     public boolean getIsInhibited(){
        return isInhibited;
    }
    
    public void setIsInhibited(boolean _isInhibited){
        this.isInhibited = _isInhibited;
    }
    
}
