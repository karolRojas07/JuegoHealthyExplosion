/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spriters;

import Containers.Container;

/**
 *
 * @author maria
 */
public abstract class MovableSprite extends Sprite implements Runnable {
    
    private Thread thread;
    

    public MovableSprite(int x, int y, int width, int height, Container container) {
        super(x, y, width, height, container);
         thread = new Thread(this);
    }

    public Thread getThread() {
        return thread;
    }
    
    @Override
    public abstract void run();

    public void setThread(Thread thread) {
        this.thread = thread;
    }
    
    
    
}
