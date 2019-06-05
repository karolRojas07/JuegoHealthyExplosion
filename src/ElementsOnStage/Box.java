/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsOnStage;

import Containers.Container;
import Spriters.StaticSprite;

/**
 * This is destroy for the Antibiotic to get pieces, powers, prizes or a weakness
 * @author usuario
 */
public abstract class Box extends StaticSprite{
    
    /**
     * 
     */
    private int resistance;
    /**
     * valor de puntaje de la caja
     */
    private int valueScore;
    /**
     * Create a new box
     * @param x position in the x axis
     * @param y position in the y axis
     * @param width width of the box
     * @param height height of the box
     * @param container where is located the box
     */
    

    public Box(int valueScore, int x, int y, int width, int height, Container container) {
        super(x, y, width, height, container);
        this.valueScore = valueScore;
        
    }
    
    public void deleteResistance()
    {
         resistance-=1;
    }
    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getValueScore() {
        return valueScore;
    }

    public int getResistance() {
        return resistance;
    }

    public void setValueScore(int valueScore) {
        this.valueScore = valueScore;
    }

    

    
    
    
    
    
}
