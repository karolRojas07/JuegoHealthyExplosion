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
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Antibiotic extends StaticSprite{

    public static final int STEP = 8;
    private boolean validateBox = false;
    private Bomb bomb;
    private ArrayList<Bomb> bombs ;

    public Antibiotic(int x, int y) {
        super(x, y, 53, 50);
        BufferedImage image =super.setImage("src/Images/personajePrincipal.png");
        super.setImage(image); 
        bombs = new ArrayList<>();
    }

    public boolean isValidateBox() {
        return validateBox;
    }

    public void setValidateBox(boolean validateBox) {
        this.validateBox = validateBox;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }
    
    /**
     * 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        
         for(Bomb bomb : bombs)
        {
           
           bomb.draw(g);
           bomb.getContainer().refresh();
        }
        super.paint(g);
       
    }
    /**
     * 
     * @param g 
     */
    public void drawBomb(Graphics g)
    {
       
        for(Bomb bomb : bombs)
        {
           
           bomb.draw(g);
           bomb.getContainer().refresh();
        }
       
    }
    
    /**
     * 
     * @param direction
     * @param other 
     */
    public void move(int direction, Sprite other)
    {
        int nx = getX();
        int ny = getY();
        
        
        switch(direction)
        {
            
            case KeyEvent.VK_UP:
                setY(getY() - STEP);
            break;
            case KeyEvent.VK_DOWN:
            {
                System.out.println("abajo");
               setY(getY() + STEP);
            }break;
            case KeyEvent.VK_LEFT:
                setX(getX() - STEP);
            break;
            case KeyEvent.VK_RIGHT:
                setX(getX() + STEP);
            break;
            
            default:
                System.err.println("[PLAYER.MOVE] Invalid Direction: " + direction);
            break;
        }
        
         if(this.checkCollision(other))
        {
            System.out.println(" caja "+isValidateBox());  
            setX(nx);
            setY(ny);
             
            
     
        }
        if(isOutOfGameSection())
        {
            setX(nx);
            setY(ny);
           
        }
        else
        {
            //super.updateGameSection();
          super.getContainer().refresh();
        }
    }
        /**
         * 
         */
        public void createBomb(Container container)
        {
            bomb = new Bomb(this.getX() ,this.getY()-this.getHeight()+10,container );
            bombs.add(bomb);
            
        }
        public void deleteBomb()
        {
            for(Bomb bomb : bombs)
            {
               bombs.remove(bomb);
            }
        }

    public Bomb getBomb() {
        return bomb;
    }

    public ArrayList<Bomb> getBombs() {
        
        return bombs;
    }
    
    
    
    
    
}
