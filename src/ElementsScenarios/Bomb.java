/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import Spriters.StaticSprite;
import java.awt.Graphics;

/**
 *
 * @author Maria y Karol
 */
public class Bomb extends StaticSprite{
    
    /**
     * Create a new bomb
     * @param x the position in the x axis
     * @param y the position in the x axis
     * @param container where is going to be painted the bomb
     */
    public Bomb(int x, int y, Container container) {
        super(x, y, 42,42,container);
        super.setImage("src/Images/bomba.png"); 
    }
    
    /**
     * Paint the bomb
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        super.paint(g);
    }
}
