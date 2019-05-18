/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import Spriters.StaticSprite;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author usuario
 */
public class Bomb extends StaticSprite{

    
    public Bomb(int x, int y, Container container) {
        super(x, y, 42,42,container);
        BufferedImage image =super.setImage("src/Images/bomba.png");
        super.setImage(image); 
    }

    @Override
    public void draw(Graphics g) {
        
        super.paint(g);
    }
    
}
