/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Readers;

import Controlador.Game;
import ElementsScenarios.Antibiotic;
import ElementsScenarios.Box;
import ElementsScenarios.Wall;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ReaderStage implements DataGameReader{

    private ArrayList<Box> boxes = new ArrayList<>();
    private Box box;
    private Antibiotic antibiotic;

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public Antibiotic getAntibiotic() {
        return antibiotic;
    }
    
    /**
     * 
     * @param game 
     */
    @Override
    public void read(Game game) {
        
        try {
            
             RandomAccessFile reader = new RandomAccessFile("StomachScenario.txt", "r");
             String line =  null;
             int column = 0;
             while ( (line = reader.readLine() )!= null )
             {
                 
                 column +=1;
                 String[] parts = line.split(" ");
                
                 for(int file = 0;  file< parts.length ; file++ )
                 {
                     
                     if (parts[file].contentEquals("1"))
                     {
                         box = new Wall(file*42, column*50);
                         box.setContainer(game);
                         box.setColor(Color.DARK_GRAY);
                         boxes.add(box);
                     }
                     else if(parts[file].contentEquals("3"))
                     {
                        antibiotic = new Antibiotic(file*42,column*50);
                        antibiotic.setContainer(game);
                         
                     }
                 }
                 
             }
             reader.close();
            
        } catch (FileNotFoundException ex) {
            
          
        } catch (IOException ex) {
            
           
        }
        
            
    }
    
    
    
}

