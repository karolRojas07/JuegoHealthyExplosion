/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import Spriters.MobileSprite;
import Spriters.Sprite;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public abstract class Bacterium extends MobileSprite{
    
    private ArrayList<Box > boxes ;
    private String url ;

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }
    
    

    public Bacterium(String url, int x, int y, int width, int height,Container container) {
        super(x, y, width, height,container);
        this.url = url;
        boxes = new ArrayList<>();}
        
      
    public abstract void move();


    public String getUrl() {
        return url;
    }
    
     public Sprite checkLimitsSprite () {
        
     Box box = null;
     for(int i = 0; i < boxes.size(); i++) 
     {
         box = boxes.get(i);
         boolean control =this.checkCollision(box);
         if(control)
         {
             return box;
         }
         
     }
     return box;

         
    }
     
    
    
}
