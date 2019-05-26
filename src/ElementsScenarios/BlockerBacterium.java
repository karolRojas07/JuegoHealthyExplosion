/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import Spriters.Sprite;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.ParseConversionEvent;

/**
 *
 * @author usuario
 */
public class BlockerBacterium extends Bacterium {

   
    public BlockerBacterium(int x, int y, Container container,int xSide, int ySide) {
        super("src/Images/constructoraBacterium.png", x, y,51,50, container,xSide,ySide);
        
         BufferedImage image = super.setImage(super.getUrl());
         super.setImage(image);
        
         this.getThread().start();
        
    }
    
    
    @Override
    public void move()
    {
        
        int nX = this.getX();
        int nY = this.getY();
        int step = 7;
//       System.out.println("X "+nX+" Y "+nY);
         for(int fila = 0; fila < step; fila++)
            {
               Sprite sprite = this.checkLimitsSprite();
                 
               if(this.checkCollision(sprite) & this.getySide()> nY)
               {
                   this.setX(nX-step);
                   this.setY(nY+step);
               }
               else if(this.checkCollision(sprite) & this.getySide()< nY)
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
                              
                              
                }
                this.getContainer().refresh();
            }
         
    }
    /**
     * 
     */
    @Override
    public void run() {
        
        
         while(true)
        {
            //this.setX(this.getX()+10);
            
            //super.getContainer().refresh();
            //this.getContainer().refresh();
            
            try {
                Thread.sleep(200);
                
                 move();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bacterium.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
    }
    
   

    /**
     * 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        
        super.paint(g);
    }

  
    
   

    
    
    
}
