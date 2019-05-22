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

/**
 *
 * @author usuario
 */
public class BlockerBacterium extends Bacterium {

   
    
    
    
    public BlockerBacterium(int x, int y, Container container) {
        super("src/Images/constructoraBacterium.png", x, y,51,50, container);
         BufferedImage image = super.setImage(super.getUrl());
         super.setImage(image);
         this.getThread().start();
        
    }
    
    
    @Override
    public void move()
    {
        int nX = this.getX();
        int nY = this.getY();
        int step = 3;
        for (int i = 0; i < step; i++) { 
            
            Sprite sprite = this.checkLimitsSprite();
            this.setX(this.getX() +step);
            if(this.isOutOfGameSection())
            {
                this.setX(this.getX());
            }
            if(this.checkCollision(sprite))
            {
                  this.setX(nX);
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
