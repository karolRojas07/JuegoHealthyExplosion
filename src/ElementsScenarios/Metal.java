/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import java.awt.Graphics;

/**
 * It's the strongest kind of box, it is destroy with two hits
 * @author María y Karol
 */
public class Metal extends Box {
    
    /**
      * Create a new box
     * @param x position in the x axis
     * @param y position in the y axis
     * @param width width of the box
     * @param height height of the box
     * @param container where is located the box
     */
    public Metal(int x, int y, int width, int height, Container container) {
        super(x, y, width, height, container);
    }

    /**
     * Paint the metal box
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
