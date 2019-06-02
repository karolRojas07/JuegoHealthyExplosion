/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import Spriters.Sprite;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class BlockerBacterium extends Bacterium {

   /**
    * Create a new Blocker Bacterium
    * @param x position in the x axis
    * @param y position in the y axis
    * @param container Where is located the blocker bacterium
    * @param finalX  position in the x axis where the blocker bacterium finish its work
    * @param finalY  position in the y axis where the blocker bacterium finish its work
    */
    public BlockerBacterium(int x, int y, Container container,int finalX, int finalY) {
        super(x, y,51,50, container,finalX,finalY);
        super.setImage("src/Images/constructoraBacterium.png");
        
        super.getThread().start();
    }
    
    /**
    * The movement of the blocker bacterium
    */
    @Override
    public void move()
    {
        
        int nX = this.getX();
        int nY = this.getY();
        int step = 7;
        
         for(int fila = 0; fila < step; fila++)
            {
               Sprite sprite = this.checkLimitsSprite();
                 
               if(this.checkCollision(sprite) & this.getFinalY()> nY)
               {
                   this.setX(nX-step);
                   this.setY(nY+step);
               }
               else if(this.checkCollision(sprite) &  this.getFinalY()< nY)
               {
                   this.setX(nX-step);
                   this.setY(nY-step);
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
                      System.out.println(this.isIndicator());        
                              
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
