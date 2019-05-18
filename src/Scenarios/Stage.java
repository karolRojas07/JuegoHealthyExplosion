/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenarios;

import Containers.Container;
import ElementsScenarios.Antibiotic;
import ElementsScenarios.Bomb;
import ElementsScenarios.Box;
import ElementsScenarios.Wall;
import ElementsScenarios.Wood;
import Spriters.Sprite;
import Spriters.StaticSprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public abstract class Stage extends StaticSprite implements Container{
    
    
    
    
    private String url;

    private int[][] tableGame ;
    
    private Antibiotic antibiotic;
    
    private Box box;
    
    private ArrayList<Box > boxes ;

    
    public int[][] getTableGame() {
        return tableGame;
    }

    public void setTableGame(int[][] tableGame) {
        this.tableGame = tableGame;
    }
    
    
    
    public Stage(int x, int y, int width, int height, Container container) {
        super(x, y, width, height, container);
        boxes = new ArrayList<>();
       
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Antibiotic getAntibiotic() {
        return antibiotic;
    }

    public Box getBox() {
        return box;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }
    
    
    /**
     * 
     */
    public void fixElements()
    {
        for(int column = 0 ; column < tableGame[0].length; column ++)
        {
            for(int file = 0 ; file < tableGame.length; file ++)
            {
                if (tableGame[file][column] == 1)
                        {
                           
                            box = new Wall(file*42, column*50);
                            box.setContainer(this);
                            box.setColor(Color.DARK_GRAY);
                            boxes.add(box);
                        }
                        else if (tableGame[file][column] == 2)
                        {
                            box = new Wood(file*42, column*50);
                            box.setContainer(this);
                            box.setColor(null);
                            boxes.add(box);
                        }
                        else if(tableGame[file][column] == 3)
                        {
                           antibiotic = new Antibiotic(file*42,column*50);
                           antibiotic.setColor(null);
                           antibiotic.setContainer(this);
                           
                        }
                
            }
            
        }
         
    }
    
    
     /**
     * 
     * @param g 
     */
    public void drawBox(Graphics g) {  
        
        
        for(Box b : boxes){
            if(b instanceof Wall)
            {
            b.draw(g);}
        }
        
        this.draw(g);
        
          for(Box b : boxes){
            if(b instanceof Wood){
            b.draw(g);}
        }
         antibiotic.draw(g);
    }
   
    /**
     * 
     * @param evt 
     */
     public void keyPressed(KeyEvent evt) 
    {
        
        // TODO
        // System.out.println("[WORLD] Key pressed: " + evt.getKeyChar());

        if(evt.getKeyCode() == KeyEvent.VK_B)
        {
            antibiotic.createBomb(this.getContainer()); 
             antibiotic.getContainer().refresh();
              exploit();
            
               
        }
    
        ////////////////////////////////////////////////////////////////////////

        if(evt.getKeyCode() == KeyEvent.VK_UP    ||
           evt.getKeyCode() == KeyEvent.VK_DOWN  ||
           evt.getKeyCode() == KeyEvent.VK_LEFT  ||
           evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
          
            Sprite other=  checkLimitsWall() ;
            antibiotic.move(evt.getKeyCode(),other);
            
            
        }
    }
     private void exploit()
     {
     long startTime = System.currentTimeMillis();
             System.out.println("tiempo ");  
            antibiotic.deleteBomb();
            
           long estimatedTime = System.currentTimeMillis() - 100;}
      /**
     * 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {  
        
    
        super.paint(g);
        
        
    }
//    @Override
    public void refresh() {
       
        super.getContainer().refresh();
    } 
     
      /**
     * 
     */
    public Sprite checkLimitsWall() {
        
         
        for(int i = 0; i < boxes.size(); i++) {
            box = boxes.get(i);
           boolean control = antibiotic.checkCollision(box);
           
            
            if(control) {
                
                  return box;
                // antibiotic.setValidateBox(control);
           
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
       
        return box;
      
    }  
    
    
    
}
