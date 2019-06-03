/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenarios;

import Containers.Container;
import java.awt.Rectangle;

/**
 *
 * @author usuario
 */
public class Lung extends Stage{

    public Lung(int x, int y, int width, int height, Container container) {
        super(x, y, 512, 512, container);
    }

    @Override
    public Rectangle getBoundaries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
