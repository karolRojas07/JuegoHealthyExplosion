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
 * @author Maria y Karol
 */
public class Heart extends Stage{

    public Heart(int stateStage,int scoreEnd,int x, int y, Container container) {
        
        super(stateStage,scoreEnd,x, y,800,700, container);
        super.setImage("src/images/3level_Heart.png");
    }

    @Override
    public Rectangle getBoundaries() {
    
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
}
