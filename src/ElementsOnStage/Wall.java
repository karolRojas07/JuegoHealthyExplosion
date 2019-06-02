/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsOnStage;

import Containers.Container;
import java.awt.Graphics;

/**
 *
 * @author maria
 */
public class Wall extends Box{

    public Wall(int x, int y, Container container) {
        super(x, y, 42, 48,container);
    }

    /**
     * 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        
        g.fillRect(super.getX(),super.getY(),super.getWidth(),super.getHeight());
        
    }
    
    
    
}
