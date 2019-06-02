/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsScenarios;

import Containers.Container;
import Spriters.Sprite;
import Spriters.StaticSprite;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * the main character of the game which is controlled by the player
 * @author Maria y Karols
 */
public class Antibiotic extends StaticSprite{
    
    /**
     * the speed of the Antibiotic
     */
    private final int STEP = 8;
    
    /**
     * The bombs tha has put the antibiotic
     */
    private ArrayList<Bomb> bombs ;
      
    /**
     * create a new an
     * @param x
     * @param y 
     */
    public Antibiotic(int x, int y) {
        super(x, y, 53, 50);
        super.setImage("src/Images/antibioticoFront.png");
        bombs = new ArrayList<>();
    }
    
    /**
     * get the bombs 
     * @return all bombs that has the antibiotic
     */
    public ArrayList<Bomb> getBombs() { return bombs; } 
    
    /**
     * paint the antibiotic 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {super.paint(g); }
    
    /**
     *  paint the bombs
     * @param g 
     */
    public void putBomb(Graphics g)
    {
       try
        {
            for(Bomb bomb : bombs)
           {
              bomb.draw(g);
              bomb.getContainer().refresh();
           }
        }catch(java.util.ConcurrentModificationException e)
        {
            System.out.println("[ANTIBIOTIC.DRAW] "+ e.getMessage());
        }
    }
    
    /**
     * Move the Antibiotic 
     * @param direction
     * @param other 
     */
    public void move(int direction, Sprite other)
    {
         if(this.checkCollision(other) | isOutOfGameSection())
        {
           System.err.println("ANTIBIOTIC.MOVE] No se puede mover en esta dirección: "+direction);
        }
        else {  
            switch(direction)
            {
                case KeyEvent.VK_UP:
                    super.setImage("src/Images/antibioticoBack.png");
                    setY(getY() - STEP);
                break;

                case KeyEvent.VK_DOWN:
                    super.setImage("src/Images/antibioticoFront.png");
                    setY(getY() + STEP);
                break;

                case KeyEvent.VK_LEFT:
                    super.setImage("src/Images/antibioticoLeft.png");
                    setX(getX() - STEP);
                break;

                case KeyEvent.VK_RIGHT:
                    super.setImage("src/Images/antibioticoRigth.png");
                    setX(getX() + STEP);
                break;

                default:
                    System.err.println("[ANTIBIOTIC.MOVE] Invalid Direction: " + direction);
                break;
            }
            super.getContainer().refresh();  
         }
        
    }
    
    /**
     * add a new bomb
     * @param container
     */
    public void addBomb(Container container)
    {
        Bomb bomb = new Bomb(this.getX() ,this.getY()-this.getHeight()+10,container );
        bombs.add(bomb);

    }
    
    /**
     * delete a bomb
     */
    public void deleteBomb()
    {
        bombs.forEach((bomb) -> {
            bombs.remove(bomb);
    });
    }

    
}
