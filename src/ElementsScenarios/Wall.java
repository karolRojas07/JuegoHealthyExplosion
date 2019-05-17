/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author maria
 */
public class Wall extends Box{

    public Wall(int x, int y) {
        super(x, y, 66, 63);
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
