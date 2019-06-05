/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stages;

import AudioPlayer.MusicPlayer;
import Containers.Container;
import ElementsOnStage.Antibiotic;
import ElementsOnStage.Bacterium;
import ElementsOnStage.BlockerBacterium;
import ElementsOnStage.Box;
import ElementsOnStage.Metal;
import ElementsOnStage.ThiefBacterium;
import ElementsOnStage.Wall;
import ElementsOnStage.Wood;
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
    
    /**
     * la direccion de la imagen del stage
     */
    private String url;
    
    /**
     * matriz del juego cargado
     */
    private int[][] tableGame ;
    /**
     * el antibiotico
     */
    private Antibiotic antibiotic;
    /**
     *  la caja
     */
    private Box box;
    /**
     * Arreglo  de cajas
     */
    private ArrayList<Box > boxes ;
    /**
     * bacteria
     */
    private Bacterium bacterium; 
    
    /**
     * arreglo de bacteria
     */
    private ArrayList<Bacterium> bacteriums ;

    /**
     * Score of gamer
     */
    private int score = 0 ;
   
    /**
     * 
     */
    private int life;
    
    /**
     * el puntaje para ganar
     */
    private int scoreEnd;
    
    /**
     *  music player
     */
    private MusicPlayer musicPlayer;
    
    /**
     * 
     */
    private int stateStage = 0 ;
    /**
     * constructor de la clase stage
     * @param x
     * @param y
     * @param width
     * @param height
     * @param container 
     * @param scoreEnd 
     */
    public Stage(int stateStage,int scoreEnd,int x, int y, int width, int height, Container container) {
        super(x, y, width, height, container);
        score = 0;
        this.scoreEnd = scoreEnd;
        this.stateStage =  stateStage ;
        boxes = new ArrayList<>();
        bacteriums = new ArrayList<>();
        musicPlayer = new MusicPlayer();
        
    }
    
    

    /**
     * guarda el tablero del juego como atributo
     * @param tableGame 
     */
    public void setTableGame(int[][] tableGame) {
        this.tableGame = tableGame;
    }
    
    /**
     * obtiene la direccion de la imagen
     * @return 
     */
    public String getUrl() {
        return url;
    }

    /**
     * guarda la direccion de la imagen del escenario
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url;
    }

   
 //                          METODOS Y FUNCIONES   
    /**
     * Crea los elementos que contiene el tablero de juego 
     */
    public void fixElements()
    {
        for(int column = 0 ; column < tableGame[0].length; column ++)
        {
            for(int file = 0 ; file < tableGame.length; file ++)
            {
                if (tableGame[file][column] == 1)
                        {
                           
                            box = new Wall(file*42, column*50,super.getContainer());
                            box.setContainer(this);
                            box.setColor(Color.DARK_GRAY);
                            boxes.add(box);
                        }
                        else if (tableGame[file][column] == 2)
                        {
                            box = new Wood(file*42, column*50,super.getContainer());
                            box.setContainer(this);
                            box.setColor(null);
                            boxes.add(box);
                        }
                        else if(tableGame[file][column] == 3)
                        {
                           antibiotic = new Antibiotic(file*42,column*50,super.getContainer());
                         
                           antibiotic.setColor(null);
                           antibiotic.setContainer(this);
                           
                        }
                        else if(tableGame[file][column] == 4)
                        {
                            box = new Metal(file*42, column*50,super.getContainer());
                            box.setContainer(this);
                            box.setColor(null);
                            boxes.add(box);
                        }
                   
                
            }
            
        }
        creatBacterium();
        creatBacteriumTime(); 
  
    }
    
    /**
     * eventos del teclado del antibiotico
     * @param evt 
     */
     public void keyPressed(KeyEvent evt) 
    {
        
        // TODO
        // System.out.println("[WORLD] Key pressed: " + evt.getKeyChar());

        // crea bombas
        if(evt.getKeyCode() == KeyEvent.VK_B)
        {
             musicPlayer.playThrowBombAudio();
            antibiotic.addBomb(this.getContainer()); 
            antibiotic.getContainer().refresh();
            exploitTime();
            antibiotic.getContainer().refresh();
                      

             
        }
    
        ////////////////////////////////////////////////////////////////////////
        
        // se mueve eb las 4 direcciones
        if(evt.getKeyCode() == KeyEvent.VK_UP    ||
           evt.getKeyCode() == KeyEvent.VK_DOWN  ||
           evt.getKeyCode() == KeyEvent.VK_LEFT  ||
           evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            musicPlayer.playWalkAudio();
            Sprite other=  checkLimitsBox() ;
            checkLimitsBacterium();
            antibiotic.move(evt.getKeyCode(),other);
            
        }
    }
     
     
     /**
     *  La bacteria crea cajas 
     */
    private void addBoxBacterium()
    {  
 
        if(bacterium.isIndicator() == false)
        {
           int nX = bacterium.getX();
           int nY = bacterium.getY();
           box = new Wood(nX-box.getWidth(),nY,super.getContainer());
           box.setContainer(this);
           boxes.add(box);
           
        } 
    }
    
      /**
      * Mide  el tiempo para crear la caja la bacteria
      */
      public  void addBoxBacteriumTime()
    {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = null;
        task1 = () -> this.addBoxBacterium();
        service.scheduleAtFixedRate(task1,2,1, TimeUnit.SECONDS); 
    //scheduleWithFixedDelay es aconsejable usarlo cuando no importa que se siga un patron de tiempo, distinto a scheduleFixedRate que se ejecuta cronologicamente siempre
    }
      
      /**
      * mide el tiempo de  nacer una bacteria
      */
      public  void creatBacteriumTime()
   {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = null;
        task1 = () -> creatBacterium();
          service.scheduleAtFixedRate(task1,6,5, TimeUnit.SECONDS); 
    //scheduleWithFixedDelay es aconsejable usarlo cuando no importa que se siga un patron de tiempo, distinto a scheduleFixedRate que se ejecuta cronologicamente siempre
   }
    /**
     *  crea la bacteria blocqueadora, teniendo en cuenta la posicion incial y el lugar donde se dirige Aleatoriamente
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
     *  crea la bacteria, teniendo en cuenta la posicion incial y el lugar donde se dirige Aleatoriamente
     */
    private void creatBacteriumThief()
    {
          int[] positionEnd= chooseRandomPositionBacterium();
          int[] positionInit = chooseRandomPositionBacterium(); 
          bacterium = new ThiefBacterium(positionInit[0],positionInit[1],this,positionEnd[0],positionEnd[1]);
          bacteriums.add(bacterium);
          bacterium.setSprite(antibiotic);
          bacterium.setBoxes(boxes);  
           bacteriums.add(bacterium);
          this.addBoxBacteriumTime();


    }
     
     /**
      * mide el tiempo de la bomba en explotar
      */
      public  void exploitTime()
      {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = null;
        task1 = () -> antibiotic.deleteBomb();
        musicPlayer.playBombExplosionAudio();
        service.scheduleAtFixedRate(task1,2,1, TimeUnit.SECONDS);
            
       //scheduleWithFixedDelay es aconsejable usarlo cuando no importa que se siga un patron de tiempo, distinto a scheduleFixedRate que se ejecuta cronologicamente siempre
      }
      
      /**
       * El tiempo para explotar la caja
       * @param other  un sprite
       */
      public void exploitTimeBox(Sprite other)
      {
         ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
         Runnable task1 = null;
         this.tableGame[other.getX()/42][other.getY()/50] = 0;
         this.getValueScoreTotal();
        
         
         
            task1 = () -> boxes.remove(other);
         
            bacterium.setBoxes(boxes);
            service.scheduleAtFixedRate(task1,2,1, TimeUnit.SECONDS);
            other.getContainer().refresh();
         
         
      }
      /**
       * 
       */
      private void getValueScoreTotal()
      {
          score+=box.getValueScore();
      }
      
      /**
       * tiempo para explotar la bacteria
       * @param Bacterium la bacteria a la cual se elimina
       */
        public void exploitTimeBacterium(Bacterium bacterium)
      {
         ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
         Runnable task1 = null;
         this.tableGame[bacterium.getX()/42][bacterium.getY()/50] = 0;
        if(bacterium.isIndicator())
        {
          task1 = () -> bacteriums.remove(bacterium);
          getValueScoreTotal();
        }
        else
        {
           task1 = () -> bacteriums.remove(bacterium);
           getValueScoreTotal();
            
        }
        
         
         service.scheduleAtFixedRate(task1,3,2, TimeUnit.SECONDS);
        
      }
      
     /**
     * Revisa los limites del antibiotico con las cajas y la bacteria
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
                
                  musicPlayer.playAntibioticAudio();
                  life= life-1;
                  score-=bacterium.getValueScore();
                  return bacterium;
            }
            if(state  )
            {
                 
                System.out.println("box "+box.getResistance());
               
                  tableGame[box.getX()/42][box.getY()/50]=0;
                  exploitTimeBox(box);
                  
               
            
            }
            else
            {
                box.deleteResistance();
            }
             
        }
                
      
        return box;
      
    }  
    /**
     * Revisa los limites de la bacteria con la bomba para explotar
    */
    public void checkLimitsBacterium() {
        
         
        for(int i = 0; i < bacteriums.size(); i++) {
            bacterium = bacteriums.get(i);
            boolean state  = exploitBomb(bacterium);
            
            if(state)
            {
              musicPlayer.playBlockerBacteriumAudio();
              exploitTimeBacterium(bacterium); 
               
            }
         
        }  
           
    }  
    
    /**
     * gestiona si la bomba colisiona con un sprite para explotarlo
     * @return 
     */
    private boolean exploitBomb(Sprite other) {
        
        boolean estado = false;
        for(int i = 0; i < antibiotic.getBombs().size(); i++) {
            
           //antibiotic.setBomb( antibiotic.getBombs().get(i));
           
           estado = antibiotic.getBombs().get(i).checkCollision(other);
            System.out.println("box "+box.getResistance());
            
           return estado;
           
        }
        return estado; 
    }  
   
    /**
     * Escoge la posicion  de la bacteria para el inicio y el final de su trayectoria
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
        
      /**
     * Dibuja el escenario en el juego
     * @param g 
     */
    @Override
    public void draw(Graphics g) { 
       
        super.paint(g);
        
        
    }
    /**
     * Repinta otra ves el escenario
     */
//    @Override
    public void refresh() {
        super.getContainer().refresh();
    } 
    
     /**
     * Dibuja en el contenedor los elementos del escenario
     * @param g 
     */
    public void drawBox(Graphics g) {  
        
          try
        {
            for(Box b : boxes){
                if(b instanceof Wall)
                {
                b.draw(g);}
            }
        }catch(java.util.ConcurrentModificationException e)
        {
            System.out.println("excepcion");
        }
        this.draw(g);
       
        try
        {
         for(Box b : boxes){
            if(b instanceof Wood){
            b.draw(g);
            }else if (b instanceof Metal)
            {
               b.draw(g);
            }
         }
        }catch(java.util.ConcurrentModificationException e)
        {
            System.out.println("excepcion");  
        }
          antibiotic.draw(g);
          
        try
        {
          if(bacteriums != null){
            for(Bacterium b : bacteriums){
             b.draw(g);  
           }
         }
          
        }catch(java.util.ConcurrentModificationException e)
        {
            System.out.println("excepcion");
        }
     
        
    }
    
   /**
    * 
    * @return 
    */
    
    public int checkStateStage(){
    
      
        if( score >= scoreEnd)
        {
            System.out.println("score "+score+" life "+life);
            System.out.println(scoreEnd);
           stateStage = 1;
           return 1;
              
        }
        else if (life <= 0)
        {
            stateStage = 2;
            return 2;
        }
        return 0;
    
    }
           

    
    /**
     * 
     * @return 
     */
    public int getScore() {
        return score;
    }
   
    

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getScoreEnd() {
        return scoreEnd;
    }

    
    public int getStateStage() {
        return stateStage;
    }
    
 
    
}
