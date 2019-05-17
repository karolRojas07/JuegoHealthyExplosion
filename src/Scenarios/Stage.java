/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenarios;

import Containers.Container;
import Spriters.StaticSprite;
import java.awt.Graphics;

/**
 *
 * @author usuario
 */
public abstract class Stage extends StaticSprite{
    
    private String url;

    public Stage(int x, int y, int width, int height, Container container) {
        super(x, y, width, height, container);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
  
    
}
