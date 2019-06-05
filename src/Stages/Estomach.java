/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stages;

import Containers.Container;
import java.awt.Rectangle;

/**
 * The First Level
 * @author Maria y Karol
 */
public class Estomach extends Stage{
    
    /**
     * 
     * @param x
     * @param y
     * @param container 
     */
    public Estomach(int stateStage,int scoreEnd,int x, int y, Container container) {
        super(stateStage,scoreEnd,x, y, 800,700,container);
        super.setImage("src/images/1level_Estomach.png");
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
