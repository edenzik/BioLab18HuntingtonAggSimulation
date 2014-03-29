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
    private int polyQNum = 10;
    private int chainOrientationX = randomPositive();
    private int chainOrientationY = randomPositive();
    private int maxLength = 12;
    private int chainDistanceX = Greenfoot.getRandomNumber(maxLength)+4;
    private int chainDistanceY = maxLength - chainDistanceX;
    private List<PolyQ> chainList = new ArrayList<PolyQ>();
    protected void addedToWorld(World world)
    {
        GreenfootImage img = getImage();
        img.scale(img.getWidth()/10,img.getHeight()/10);
        img.rotate(Greenfoot.getRandomNumber(360));
        setRotation(Greenfoot.getRandomNumber(360));
        
        
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
    
}
