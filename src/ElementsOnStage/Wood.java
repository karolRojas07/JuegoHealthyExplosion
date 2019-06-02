/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsOnStage;

import Containers.Container;
import java.awt.Graphics;

/**
 * It's the easiest kind of box to destroy with just one hit
 * @author María y Karol
 */
public class Wood extends Box{

    /**
     * Create a new wood box
     * @param x position in the x axis
     * @param y position in the y axis
     * @param container where is located the box
     */
    public Wood(int x, int y, Container container) {
        super(x, y, 42, 50,container);
        super.setImage("src/Images/ImgWoodBox.jpg");
        super.setResistance(1);
    }
    
    /**
     * paint the wood box
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        
        super.paint(g);
        
    }
}
