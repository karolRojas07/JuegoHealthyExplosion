/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsOnStage;

import Containers.Container;
import Spriters.Sprite;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An enemy of the antibiotic who steals the pieces of the antibiotic
 * @author Maria y Karol
 */
public class ThiefBacterium extends Bacterium{
    
    /**
     * Create a new Thief bacterium
    * @param x position in the x axis
    * @param y position in the y axis
    * @param container Where is located the Thief bacterium
    * @param xSide width of the Thief bacterium
    * @param ySide heigth of the blocker bacterium
     */
    public ThiefBacterium(int x, int y, Container container, int xSide, int ySide) {
        super(150,x, y, 51,50, container, xSide, ySide);
        super.setImage("src/Images/ThiefBacterium.png");
        
    }
     
    /**
    * The movement of the blocker bacterium
    */
    @Override
    public void move()
    {
        
        int nX = this.getX();
        int nY = this.getY();
        int step = 5;
        
         for(int fila = 0; fila < step; fila++)
            {
               Sprite sprite = this.checkLimitsSprite();
                 
               if(this.checkCollision(sprite) |  this.getFinalY()< nX)
               {
                   this.setX(nX-step);
                   
               }
               else if(this.checkCollision(sprite) &  this.getFinalY()< nY)
               {
                   this.setX(nX+step);
                  
               }
               else
               {
                     this.setX(nX+step);
               }
              
               
                 if(this.isOutOfGameSection())
                {
                    this.setX(nX);
                    this.setY(nY);
                }
                if(this.checkCollision(sprite))
                {
                      
                      this.setX(nX);
                      this.setY(nY);
                      this.setIndicator(true);  
                }
                this.getContainer().refresh();
            }
         
    }
    
    /**
    * Start the thread to make the s blocker baterium move by its own
    */
    @Override
    public void run() {
         while(true)
        {
            try {
                Thread.sleep(200);
                move();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bacterium.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
    }
    
   

    /**
     * Paint the blocker bacterium
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        
        super.paint(g);
    }
    

}
