/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Containers.Container;
import ElementsScenarios.Antibiotic;
import ElementsScenarios.Bomb;
import ElementsScenarios.Box;
import ElementsScenarios.Wall;
import ElementsScenarios.Wood;
import Readers.DataGameReader;
import Readers.ReaderStage;
import Scenarios.Estomach;
import Scenarios.Stage;
import Spriters.Sprite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author usuario
 */
public class Game extends Sprite implements Container{

    private DataGameReader readerStage ;
    private Stage stage;
   

    public Game(int x, int y, int width, int height) {
        super(x, y, width, height);
      
    }
    
    public void setReaderStage(DataGameReader readerStage) {
        this.readerStage = readerStage;
    }
    
    /**
     * guarda el escenario
     * @param stage 
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
   
    
    /**
     * 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
     
       
        g.setColor(Color.DARK_GRAY);
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        
        stage.drawBox(g);
     
        
    }

    
    /**
     * 
     * @param evt 
     */
     public void keyPressed(KeyEvent evt) 
    {
        
        
         stage.keyPressed(evt);
       
        
    }
      
   
     /**
      * 
      */
    @Override
    public void refresh() {
        super.getContainer().refresh();
        
        
    }

    /**
     * 
     * @return 
     */
    @Override
    public Rectangle getBoundaries() {
        
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public void mousePressed(MouseEvent evt) {
    }
    
    
    

    
}
