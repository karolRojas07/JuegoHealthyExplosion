/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsOnStage;

import Containers.Container;
import Spriters.MovableSprite;
import Spriters.Sprite;
import java.util.ArrayList;

/**
 * The enemy of the antibiotic
 * @author Maria y Karol
 */
public abstract class Bacterium extends MovableSprite{
   
   
    /**
     * boxes in the space
     */
    private  ArrayList<Box > boxes;
    
    /**
     * Necesary to know the collisions with others
     */
    private static Sprite sprite; 
    
    /**
     * position in the x axis where the bacterium finish its work
     */
    private int finalX ;
    
    /**
     * position in the y axis where the bacterium finish its work
     */
    private int finalY ;
    
    /**
     * indicate if has collided with an object
     */
    private static boolean indicator = false;
    
    /**
     * value of the score of the bacterium
     */
    private int valueScore;
    
    /**
     * 
     * @return 
     */
    public boolean isIndicator() {
        return indicator;
    }
    
    /**
     * 
     * @param indicator 
     */
    public void setIndicator(boolean indicator) {
        this.indicator = indicator;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Box> getBoxes() {
        return boxes;
    }
    
    /**
     * 
     * @param boxes 
     */
    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    /**
     * 
     * @return 
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * 
     * @param sprite 
     */
    public void setSprite(Sprite sprite) {
        Bacterium.sprite = sprite;
    }
    
    /**
     * get the value of finalX
     * @return the value of finalX
     */
    public int getFinalX() {
        return finalX;
    }

    /**
     * Get the value of of finalY
     * @return the value of finalY
     */
    public int getFinalY() {
        return finalY;
    }
    
    
    /**
     * Create a new bacterium
     * @param x position in the x axis
     * @param y position in the y axis
     * @param width width of the Bacterium
     * @param height heigth of the Bacterium
    * @param container Where is located the  bacterium
     * @param finalX  position in the x axis where the bacterium finish its work
     * @param finalY  position in the y axis where the bacterium finish its work
     */
    public Bacterium(int valueScore,int x, int y, int width, int height,Container container,int finalX, int finalY) {
        super(x, y, width, height,container);
        this.finalX = finalX;
        this.finalY = finalY;
        this.valueScore = valueScore;
        boxes = new ArrayList<>();
    }
    
    /**
     * The movement of the Bacterium
     */
    public abstract void move();

    /**
     * Validate if the Bacterium collide with other object
     * @return 
     */
    public Sprite checkLimitsSprite () {
        
     Box box = null;
     for(int i = 0; i < boxes.size(); i++) 
     {
         box = boxes.get(i);
         boolean control =this.checkCollision(box);
         boolean controlSprite = this.checkCollision(sprite);
         
         if(control) { return box; }
         else if(controlSprite) {return sprite; }
         
     }
     return box;
    }

    public int getValueScore() {
        return valueScore;
    }
    
    
    
}
