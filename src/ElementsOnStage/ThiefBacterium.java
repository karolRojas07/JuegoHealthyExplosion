/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsOnStage;

import Containers.Container;
import java.awt.Graphics;

/**
 * An enemy of the antibiotic who steals the pieces of the antibiotic
 * @author Maria y Karol
 */
public class ThiefBacterium extends Bacterium{
    
    /**
     * Create a new Thief bacterium
    * @param x position in the x axis
    * @param y position in the y axis
    * @param container Where is located the Thief bacterium
    * @param xSide width of the Thief bacterium
    * @param ySide heigth of the blocker bacterium
     */
    public ThiefBacterium(int x, int y, Container container, int xSide, int ySide) {
        super(x, y, 51,50, container, xSide, ySide);
        super.setImage("src/Images/ThiefBacterium.png");
        
    }
     
    /**
     * Paint the Thief bacterium
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * The movement of the Thief Bacterium
     */
    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
    * Start the thread to make the Thief baterium move by its own
    */
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
