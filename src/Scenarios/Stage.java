/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scenarios;

import Containers.Container;
import ElementsScenarios.Antibiotic;
import ElementsScenarios.Bacterium;
import ElementsScenarios.BlockerBacterium;
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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
    
    private Bacterium bacterium; 

    
    public int[][] getTableGame() {
        return tableGame;
    }

    public void setTableGame(int[][] tableGame) {
        this.tableGame = tableGame;
    }
    
    
    
    public Stage(int x, int y, int width, int height, Container container) {
        super(x, y, width, height, container);
        
        boxes = new ArrayList<>();
       bacterium = new BlockerBacterium(3*50,12*42,this);
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
                           bacterium.setSprite(antibiotic);
                           antibiotic.setColor(null);
                           antibiotic.setContainer(this);
                           
                        }
                   
                
            }
            
        }
             bacterium.setBoxes(boxes);
             bacterium.setTableGame(tableGame);
         
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
         
         bacterium.draw(g);
      
       
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
            scheduleDelayTask1(1);
              antibiotic.getContainer().refresh();
           
             
        }
    
        ////////////////////////////////////////////////////////////////////////

        if(evt.getKeyCode() == KeyEvent.VK_UP    ||
           evt.getKeyCode() == KeyEvent.VK_DOWN  ||
           evt.getKeyCode() == KeyEvent.VK_LEFT  ||
           evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
          
            Sprite other=  checkLimitsBox() ;
            antibiotic.move(evt.getKeyCode(),other);
            antibiotic.getContainer().refresh();
            
        }
    }
     
     /**
      * mide el tiempo de la bomba en explotar
      */
      public  void scheduleDelayTask1(int option)
   {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = null;
   
        
          task1 = () -> antibiotic.deleteBomb();
           service.scheduleAtFixedRate(task1,5,1, TimeUnit.SECONDS);
      
       
    //scheduleWithFixedDelay es aconsejable usarlo cuando no importa que se siga un patron de tiempo, distinto a scheduleFixedRate que se ejecuta cronologicamente siempre
   }
      
      public void timeBox(Box box)
      {
         ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
         Runnable task1 = null;
         task1 = () -> boxes.remove(box);
         service.scheduleAtFixedRate(task1,4,1, TimeUnit.SECONDS);
         box.getContainer().refresh();
         
      }
      
     
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
    public Sprite checkLimitsBox() {
        
         
        for(int i = 0; i < boxes.size(); i++) {
            box = boxes.get(i);
            boolean controlAntibiotic  = antibiotic.checkCollision(box);
            boolean controlBacterium  = antibiotic.checkCollision(bacterium);
            boolean estado  = exploitBox( box);
        
            
            if(controlAntibiotic) {
                
                  return box;
            }
            else if( controlBacterium ) {
                
                  return bacterium;
            }
            if(estado)
            {
              tableGame[box.getX()/42][box.getY()/50]=0;
              timeBox( box);     
            }
        }
       
        return box;
      
    }  
    
    /**
     * 
     * @return 
     */
    private boolean exploitBox(Box box) {
        
        boolean estado = false;
        for(int i = 0; i < antibiotic.getBombs().size(); i++) {
            
           antibiotic.setBomb( antibiotic.getBombs().get(i));
           estado = antibiotic.getBomb().checkCollision(box);
           
           if(estado)
           {
               return estado;
           }
          
        }
        return estado;
       
      
      
    }  
    
    
    
}
