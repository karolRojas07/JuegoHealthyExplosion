/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenarios;

import Containers.Container;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author usuario
 */
public class Estomach extends Stage{

    public Estomach(int x, int y,Container container) {
        super(x, y, 800, 800, container);
        super.setUrl("src/images/nivel1_Estomago.png");
        super.setImage(this.getUrl());
        super.setImage(super.getImage());
    }

   

    

    @Override
    public Rectangle getBoundaries() {
       return new Rectangle(getX(), getY(), getWidth(), getHeight());
        
    }

   
    
    
    
    
}
