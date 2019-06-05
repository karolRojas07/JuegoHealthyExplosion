/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stages;

import Containers.Container;
import java.awt.Rectangle;

/**
 *
 * @author usuario
 */
public class Lung extends Stage{
    
    /**
     * 
     * @param x
     * @param y
     * @param container 
     */
    public Lung(int stateStage,int scoreEnd,int x, int y, Container container) {
        super(stateStage,scoreEnd,x, y, 800,700, container);
        super.setImage("src/images/2level_Lung.png");
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    
}
