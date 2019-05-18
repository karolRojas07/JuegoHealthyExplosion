/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author usuario
 */
public class Wood extends Box{

    public Wood(int x, int y) {
        super(x, y, 42, 48);
        BufferedImage image =super.setImage("src/Images/cajaMadera.jpg");
        super.setImage(image); 
    }
    
    @Override
    public void draw(Graphics g) {
        
        super.paint(g);
        
    }
    
    
    
}
