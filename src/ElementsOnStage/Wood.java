/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsOnStage;

import Containers.Container;
import java.awt.Graphics;

/**
 * It's the easiest kind of box to destroy with just one hit
 * @author María y Karol
 */
public class Wood extends Box{

    
    public Wood(int x, int y, Container container) {
        super(x, y, 42, 48,container);
        super.setImage("src/Images/cajaMadera.jpg");
        super.setResistance(1);
    }
    
    @Override
    public void draw(Graphics g) {
        
        super.paint(g);
        
    }
}
