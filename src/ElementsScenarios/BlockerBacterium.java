/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
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
          super.getThread().start();
    }

   

    /**
     * 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        
        super.paint(g);
    }

    /**
     * 
     */
    @Override
    public void run() {
        
         while(true)
        {
            super.setX(super.getX()+5);
            super.getContainer().refresh();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BlockerBacterium.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
