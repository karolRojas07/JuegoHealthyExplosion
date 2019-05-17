/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import Spriters.StaticSprite;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author usuario
 */
public class Antibiotic extends StaticSprite{

    public static final int STEP = 8;

    public Antibiotic(int x, int y) {
        super(x, y, 67, 63);
        BufferedImage image =super.setImage("src/Images/personajePrincipal.png");
        super.setImage(image); 
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
     * @param key 
     */
      public void keyPressed(int key)
    {
        
        if(key == KeyEvent.VK_UP |
           key == KeyEvent.VK_DOWN |
           key == KeyEvent.VK_LEFT |
           key == KeyEvent.VK_RIGHT)
            move(key);
    }
    
      /**
       * 
       * @param direction 
       */
    public void move(int direction)
    {
        int nx = getX();
        int ny = getY();
        
        switch(direction)
        {
            case KeyEvent.VK_UP:
                setY(getY() - STEP);
            break;
            case KeyEvent.VK_DOWN:
                setY(getY() + STEP);
            break;
            case KeyEvent.VK_LEFT:
                setX(getX() - STEP);
            break;
            case KeyEvent.VK_RIGHT:
                setX(getX() + STEP);
            break;
            
            default:
                System.err.println("[PLAYER.MOVE] Invalid Direction: " + direction);
            break;
        }
        
        if(isOutOfGameSection())
        {
            setX(nx);
            setY(ny);
        }
        
        else
            super.getContainer().refresh();
    }
    
    
    
}
