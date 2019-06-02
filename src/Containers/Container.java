/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Containers;

import java.awt.Rectangle;

/**
 * It is used in each object that implements it or has it to update their 
 * graphic statuss
 * @author maria y karol
 */
public interface Container {
    
    /**
     * To update in the view
     */
    public void refresh();
    
    /**
     * return the object's area
     * @return 
     */
    public Rectangle getBoundaries();
    
}
