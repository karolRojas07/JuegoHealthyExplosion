/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spriters;

import Containers.Container;

/**
 *
 * @author maria
 */
public abstract class StaticSprite extends Sprite{

    public StaticSprite(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

   
    public StaticSprite(int x, int y, int width, int height, Container container) {
        super(x, y, width, height,container);
    }

    
   
 
    
    
}
