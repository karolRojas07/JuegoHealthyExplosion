/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Readers;

import Controlador.Game;

/**
 * Read the information data of the game from a JSON file
 * @author Maria y Karol
 */
public interface DataGameReader {
    
    
    /**
     * Read 
     * @param path the name of the file
     */   
    public void read(String path);
  
    /**
      * Read
      * @param game the controller of the game
      */
    public void read(Game game);
    
    
}
