/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Containers.Container;
import ElementsScenarios.Antibiotic;
import ElementsScenarios.Box;
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

    private ArrayList<Box> boxes ;
    private ReaderStage readerStage ;
    private Stage stage;
    private Antibiotic antibiotic;

    
    public Game(int x, int y, int width, int height) {
        super(x, y, width, height);
        boxes = new ArrayList<Box>();
    }

    
    public void setReaderStage(ReaderStage readerStage) {
        this.readerStage = readerStage;
    }
    
    /**
     * 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
     
        g.setColor(Color.DARK_GRAY);
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        stage = new Estomach(super.getX(),super.getY(),super.getWidth(),super.getHeight(),this);
        stage.draw(g);
        
        boxes = readerStage.getBoxes();
        for(Box b : boxes){
            b.draw(g);
        }
        antibiotic = readerStage.getAntibiotic();
        antibiotic.draw(g);
        super.paint(g);
    }

    
    /**
     * 
     * @param evt 
     */
     public void keyPressed(KeyEvent evt) 
    {
        // TODO
        // System.out.println("[WORLD] Key pressed: " + evt.getKeyChar());

        if(evt.getKeyCode() == KeyEvent.VK_Q)
        {
            System.exit(0);
        }
        
        ////////////////////////////////////////////////////////////////////////

        if(evt.getKeyCode() == KeyEvent.VK_UP    ||
           evt.getKeyCode() == KeyEvent.VK_DOWN  ||
           evt.getKeyCode() == KeyEvent.VK_LEFT  ||
           evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            antibiotic.move(evt.getKeyCode());
            checkLimitsWall() ;
        }
    }
      
    /**
     * 
     */
    private void checkLimitsWall() {
        
        for(int i = 0; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            boolean control = antibiotic.checkCollision(box);
            
            if(control) {
                
                System.out.println(" no ");
               
             
                
//                if(m instanceof MushroomBad) {
//                    gnome.toShrink(MushroomBad.CALORIES);
//                    container.refresh();
//                } else 
//                    if(m instanceof MushroomGood) {
//                        gnome.toSwell(MushroomGood.CALORIES);
//                        container.refresh();
//                    } else 
//                        System.out.println("ERROR: Mushroom type unknown.");
            }
        }
      
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
