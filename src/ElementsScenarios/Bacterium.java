/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import Spriters.MobileSprite;

/**
 *
 * @author usuario
 */
public abstract class Bacterium extends MobileSprite{

    private String url ;

    public Bacterium(String url, int x, int y, int width, int height,Container container) {
        super(x, y, width, height,container);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    
    
    
}
