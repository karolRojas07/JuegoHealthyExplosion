/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spriters;

import Containers.Container;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author maria
 */
public abstract class Sprite {
    
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private Container container;
    private BufferedImage image;
    
    

    public Sprite(int x, int y, int width, int height) {
        
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
      // setColor(new Color((int)(Math.random()*256), 
//                           (int)(Math.random()*256), 
//                           (int)(Math.random()*256)));
        setContainer(null);
     
        
    }

     public Sprite(int x, int y, int width, int height, Container container)
    {
        this(x, y, width, height);
        setContainer(container);
    }
    
     
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    

    /**
     * 
     * @param g 
     */
     public void paint(Graphics g)
    {
        // TODO

        if(getColor() != null)
        {
            g.setColor(getColor());
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
        
        if(getImage() != null){
          
            g.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(),null);
        }
    }
     
     
     /**
      * 
      * @param filename
      * @return 
      */
      public BufferedImage setImage(String filename)
    {
        try 
        {
            setImage(ImageIO.read(new File(filename)));
            
            return getImage();
        } 
        catch (IOException e) 
        {
            // There was a problem reading the selected image.
        }
        
        return null;
    }
    
      /**
       * 
       * @return 
       */
      public boolean isOutOfGameSection()
    {
        if(getContainer() == null)
            return false;
        
        Rectangle bounds = getContainer().getBoundaries();
        
        return !(getX() >= bounds.getX() &
                 getY() >= bounds.getY() &
                 getX() + getWidth()  <= bounds.getX() + bounds.getWidth() &
                 getY() + getHeight() <= bounds.getY() + bounds.getHeight());
    }
    
//    /**
//     * 
//     * @param box
//     * @return 
//     */
//      
//    public boolean checkCollision(Sprite box )
//    {
//        if( box.y <= this.y+this.height & box.y >= this.y & box.x+box.width == this.x  
//           & box.x+box.width < this.x+this.getWidth() &
//           box.y+box.height <= this.y+this.getHeight() & box.y+box.height >= this.y)
//        {
//            System.out.println(true);
//            return true;
//        }
//        
//            return false;
//        
//    }

    /**
     * 
     */
    public void updateGameSection()
    {
        if(getContainer() != null)
            getContainer().refresh();
    }
    /**
     * 
     * @param other
     * @return 
     */
    public boolean checkCollision(Sprite other)
    {
        // Collision x-axis?
        boolean collisionX = this.getX() + this.getWidth() >= other.getX() &&
            this.getX() < other.getX() + other.getWidth();

        // Collision y-axis?
        boolean collisionY = this.getY() + this.getHeight() >= other.getY() &&
            this.getY() < other.getY() + other.getHeight();

        // Collision only if on both axes
        return collisionX && collisionY;        
    }
    /**
     *  method abstract
     */
    public abstract void draw(Graphics g);
    
    
}
