/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Content_Of_Box;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Element inside a box
 * @author Maria y Karol
 */
public abstract class Content {
      private BufferedImage image;

    public void setImage(String image) {
        try{
            this.image=ImageIO.read(new File(image));
        }catch(IOException e)
        {
            System.err.println("[CONTENT.SET_IMAGE] No se puede leer la imagen");
        }
    }

    public BufferedImage getImage() {
        return image;
    }
    
}
