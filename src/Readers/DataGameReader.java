/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Readers;

import Containers.Container;
import Stages.Stage;

/**
 * Read the information data of the game from a JSON file
 * @author Maria y Karol
 */
public interface DataGameReader {
    
    
    /**
     * Read the stage
     * @param file the name of the file to read the stage
     * @param container where is painted the stage
     * @return the stage read
     */   
    public Stage read(String file,Container container);
      
}
 