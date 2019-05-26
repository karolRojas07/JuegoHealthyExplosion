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
    
    private ArrayList<Bacterium> bacteriums ;

    
    public int[][] getTableGame() {
        return tableGame;
    }

    public void setTableGame(int[][] tableGame) {
        this.tableGame = tableGame;
    }
    
    
    
    public Stage(int x, int y, int width, int height, Container container) {
        super(x, y, width, height, container);
        
        boxes = new ArrayList<>();
        bacteriums = new ArrayList<>();
       
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
        creatBacterium();
        creatBacteriumTime(); 
  
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
         
         if(bacteriums != null){
            for(Bacterium b : bacteriums){
            b.draw(g);
           
        }
         }
          
        
       
    }
    /**
     * 
     */
    private void addBoxBacterium()
    {  
 
        if(bacterium.isIndicator() == false)
        {
           int nX = bacterium.getX();
           int nY = bacterium.getY();
           box = new Wood(nX-box.getWidth(),nY);
           box.setContainer(this);
           boxes.add(box);
           
        } 
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
            scheduleDelayTask1();
            antibiotic.getContainer().refresh();
           
             
        }
    
        ////////////////////////////////////////////////////////////////////////

        if(evt.getKeyCode() == KeyEvent.VK_UP    ||
           evt.getKeyCode() == KeyEvent.VK_DOWN  ||
           evt.getKeyCode() == KeyEvent.VK_LEFT  ||
           evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
          
            Sprite other=  checkLimitsBox() ;
            checkLimitsBacterium();
            antibiotic.move(evt.getKeyCode(),other);
//          
            
        }
    }
       /**
      * mide el tiempo de crear  cajas la bacteria
      */
      public  void addBoxBacteriumTime()
   {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = null;
        task1 = () -> this.addBoxBacterium();
        service.scheduleAtFixedRate(task1,5,5, TimeUnit.SECONDS);
      
       
    //scheduleWithFixedDelay es aconsejable usarlo cuando no importa que se siga un patron de tiempo, distinto a scheduleFixedRate que se ejecuta cronologicamente siempre
   }
      /**
      * mide el tiempo de crear  cajas la bacteria
      */
      public  void creatBacteriumTime()
   {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = null;
        task1 = () -> creatBacterium();
        service.scheduleAtFixedRate(task1,20,10, TimeUnit.SECONDS);
      
       
    //scheduleWithFixedDelay es aconsejable usarlo cuando no importa que se siga un patron de tiempo, distinto a scheduleFixedRate que se ejecuta cronologicamente siempre
   }
      /**
       * 
       */
      private void creatBacterium()
      {
            int[] positionEnd= chooseRandomPositionBacterium();
            int[] positionInit = chooseRandomPositionBacterium(); 
            bacterium = new BlockerBacterium(positionInit[0],positionInit[1],this,positionEnd[0],positionEnd[1]);
            bacteriums.add(bacterium);
            bacterium.setSprite(antibiotic);
            bacterium.setBoxes(boxes);  
             bacteriums.add(bacterium);
            this.addBoxBacteriumTime();
           
          
      }
     
     /**
      * mide el tiempo de la bomba en explotar
      */
      public  void scheduleDelayTask1()
      {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = null;
   
        
          task1 = () -> antibiotic.deleteBomb();
           service.scheduleAtFixedRate(task1,5,1, TimeUnit.SECONDS);
            
       
    //scheduleWithFixedDelay es aconsejable usarlo cuando no importa que se siga un patron de tiempo, distinto a scheduleFixedRate que se ejecuta cronologicamente siempre
      }
      
      /**
       * 
       * @param other 
       */
      public void timeBox(Sprite other)
      {
         ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
         Runnable task1 = null;
         this.tableGame[other.getX()/42][other.getY()/50] = 0;
        
            task1 = () -> boxes.remove(other);
        
         service.scheduleAtFixedRate(task1,4,1, TimeUnit.SECONDS);
         other.getContainer().refresh();
         
      }
      
      /**
       * 
       * @param other 
       */
        public void timeBacterium(Sprite other)
      {
         ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
         Runnable task1 = null;
         this.tableGame[other.getX()/42][other.getY()/50] = 0;
         
        task1 = () -> bacteriums.remove(other);
         
         service.scheduleAtFixedRate(task1,4,2, TimeUnit.SECONDS);
         other.getContainer().refresh();
         
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
            boolean state  = exploitBomb(box);
            
            
            if(controlAntibiotic) {
                
                  return box;
            }
            else if( controlBacterium ) {
                
                  return bacterium;
            }
            if(state)
            {
              tableGame[box.getX()/42][box.getY()/50]=0;
              timeBox(box);     
            }
           
        }
       
        return box;
      
    }  
      /**
     * 
     */
    public void checkLimitsBacterium() {
        
         
        for(int i = 0; i < bacteriums.size(); i++) {
            bacterium = bacteriums.get(i);
            boolean controlBacterium  = antibiotic.checkCollision(bacterium);
            boolean state  = exploitBomb(bacterium);
            
            if(state)
            {
              timeBacterium(bacterium) ;    
            }
           
        }   
    }  
    
    /**
     * 
     * @return 
     */
    private boolean exploitBomb(Sprite other) {
        
        boolean estado = false;
        for(int i = 0; i < antibiotic.getBombs().size(); i++) {
            
           antibiotic.setBomb( antibiotic.getBombs().get(i));
           estado = antibiotic.getBomb().checkCollision(other);
           
           if(estado)
           {
               return estado;
           }
          
        }
        return estado; 
    }  
   
    /**
     * Escoge la posicion final de la bacteria
     */
    private int[] chooseRandomPositionBacterium()
    {
        int x = 0;
        int y = 0;
        while(tableGame[x][y] != 0 )
        {
            if(x != antibiotic.getX()+5 & y != antibiotic.getY())
            {
              x = (int) (Math.random() * tableGame.length-1);
              y = (int)  (Math.random()*tableGame[0].length-1); 
            }          
        }
        int [] positionEnd = new int[2];
        positionEnd[0] = x*box.getWidth();
        positionEnd[1] = y*box.getHeight();
        System.out.println(positionEnd[0]+" "+positionEnd[1]);
        return positionEnd;
    }
}
