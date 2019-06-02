/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Containers.Container;
import Readers.DataGameReader;
import Scenarios.Stage;
import Spriters.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 * The controller of the game
 * @author María y Karol
 */
public class Game extends Sprite implements Container{

    /**
     * It is responsible of read the data information about a stage
     */
    private DataGameReader readerStage ;
    
    /**
     * It means the level of the games
     */
    private Stage stage;
   
    /**
     * Create a new game
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public Game(int x, int y, int width, int height) {
        super(x, y, width, height);
      
    }
    
    /**
     * Define the reader of the stage data information
     * @param readerStage 
     */
    public void setReaderStage(DataGameReader readerStage) {
        this.readerStage = readerStage;
    }
    
    /**
     * Define the stage
     * @param stage 
     */
    public void setStage(Stage stage) { this.stage = stage;  }
    
    /**
     * Draw the stage
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        stage.drawBox(g);
    }

    /**
     * Get the event when a key is pressed and tell to the stage
     * @param evt 
     */
     public void keyPressed(KeyEvent evt) { stage.keyPressed(evt); }
      
   
     /**
      * Uptdate the game in the view
      */
    @Override
    public void refresh() { super.getContainer().refresh();}

    /**
     * Get the measurements of the game
     * @return Rectangle object that is used in the graph part
     */
    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
  
}
