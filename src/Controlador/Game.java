/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Containers.Container;
import Readers.DataGameReader;
import Stages.Stage;
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
     * name of the file where is the information data about the Estomach Stage
     */
    private static final String ESTOMACH_FILE="StomachScenario.txt" ;
   
    /**
     * name of the file where is the information data about the Lung Stage
     */
    private static final String LUNG_FILE="LungScenario.txt" ;
    
    /**
     * name of the file where is the information data about the Heart Stage
     */
    private static final String HEART_FILE="HeartScenario.txt" ;
    
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
     * @param x position in the x axis of the game
     * @param y position in the x axis of the game

     */
    public Game(int x, int y) {
      super(x, y, 800, 700);
    }
    
    /**
     * Define the reader of the stage data information
     * @param readerStage the reader of the information
     */
    public void setReaderStage(DataGameReader readerStage) {
        this.readerStage = readerStage;
    }
    
    /**
     * Define the stage of the game
     * @param stage Stage where is playing the user
     */
    public void setStage(int stage) { 
        switch(stage)
        {
            case 0:
                this.stage=readerStage.read(ESTOMACH_FILE,super.getContainer());
                break;
            case 1:
                this.stage=readerStage.read(LUNG_FILE,super.getContainer());
                break;
            case 2:
                this.stage=readerStage.read(HEART_FILE,super.getContainer());
                break;
        }
    }
    
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
      * Uptdate tshe game in the view
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
