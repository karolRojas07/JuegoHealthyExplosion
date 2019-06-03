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
    
    /**
     * posicion en el eje horizontal del objeto
     */
    private int x;
    /**
     * posicion en el vertical del objeto
     */
    private int y;
    /**
     * el ancho del objeto
     */
    private int width;
    /**
     *  el alto del objeto
     */
    private int height;
    /**
     * color del objeto 
     */
    private Color color;
    /**
     * la clase que lo contiene para pintarlo
     */
    private Container container;
    /**
     * la imagen del objeto
     */
    private BufferedImage image;
    
    
    /**
     * constructor
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public Sprite(int x, int y, int width, int height) {
        
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        
//       setColor(new Color((int)(Math.random()*256), 
//                           (int)(Math.random()*256), 
//                           (int)(Math.random()*256)));
       // setContainer(null);
     
        
    }

    /**
     * constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param container 
     */
     public Sprite(int x, int y, int width, int height, Container container)
    {
        this(x, y, width, height);
        this.container=container;
    }
    
    
     /**
      * el obtener la pocicion horizontal
      * @return 
      */
    public int getX() {
        return x;
    }

    /**
     * el guardar la variable horizonta por el parametro de entrada
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * el obtener la variable vertical 
     * @return 
     */
    public int getY() {
        return y;
    }

    /**
     * el guardar por de la variable vertical por el parametro de entrada
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 
     * @return 
     */
    public int getWidth() {
        return width;
    }

    /**
     * 
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 
     * @return 
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 
     * @return 
     */
    public Container getContainer() {
        return container;
    }

    /**
     * 
     * @param container 
     */
    public void setContainer(Container container) {
        this.container = container;
    }

    /**
     * 
     * @return 
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * 
     * @param image 
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * 
     * @return 
     */
    public Color getColor() {
        return color;
    }

    /**
     * 
     * @param color 
     */
    public void setColor(Color color) {
        this.color = color;
    }
    

    /**
     * el dibuja las imagenes o las figuras.
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
      *  crea la imagen
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
       * revisa si esta en los limites del juego.
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
//     */
//    public void updateGameSection()
//    {
//        if(getContainer() != null)
//            getContainer().refresh();
//    }
    /**
     * revisa  toca otro objeto sprite
     * @param other
     * @return 
     */
    public boolean checkCollision(Sprite other)
    {
        // Collision x-axis?
        boolean collisionX = this.getX() + this.getWidth() >= other.getX()+10 &&
            this.getX() <= other.getX()-10 + other.getWidth();

        // Collision y-axis?
        boolean collisionY = this.getY() + this.getHeight() >= other.getY()+10 &&
            this.getY() <= other.getY()-10 + other.getHeight();
        
        // Collision only if on both axes
        return collisionX && collisionY;        
    }
    
    
    /**
     *  method abstract dibuja las imagenes
     */
    public abstract void draw(Graphics g);
    
    
}
