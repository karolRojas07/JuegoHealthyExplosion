/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Readers;

import Controlador.Game;
import ElementsOnStage.Antibiotic;
import ElementsOnStage.Box;
import Scenarios.Estomach;
import Scenarios.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ReaderStage implements DataGameReader{

    private ArrayList<Box> boxes = new ArrayList<>();
    private Game game;
    private Stage stage ;
    private Box box;
    private Antibiotic antibiotic;
    private int[][] tableGame = new int[19][16];

//    public ReaderStage(Game game) {
//        this.game = game;
//    }
//

    
    
    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public Antibiotic getAntibiotic() {
        return antibiotic;
    }

    
    /**
     * 
     * 
     * @param game 
     */
    @Override
    public void read( String path) {
        
        try {
            
             RandomAccessFile reader = new RandomAccessFile(path, "r");
             String line =  null;
             int column = 0;
             while ( (line = reader.readLine() ) != null )
             {
                 
                 column +=1;
                 String[] parts = line.split(" ");
               
                 if( column == 1)
                 {
                     if(parts[0].contains("E"))
                     {
                         stage = new Estomach(0,0,game);
                         game.setStage(stage);
                      
                     }
                 }
                 else if (column < tableGame[0].length)
                 {
                    for(int file = 0;  file< parts.length ; file++ )
                    {  
                       tableGame[file][column-2] = Integer.parseInt(parts[file]); 
                       
                    } 
                 }   
             }
              stage.setTableGame(tableGame);
              stage.fixElements();
             reader.close();
            
        } catch (FileNotFoundException ex) {
            
          
        } catch (IOException ex) {
            
           
        }
        
            
    }

    @Override
    public void read(Game game) {
       try {
            
             RandomAccessFile reader = new RandomAccessFile("StomachScenario.txt", "r");
             String line =  null;
             int column = 0;
             while ( (line = reader.readLine() ) != null )
             {
                 
                 column +=1;
                 String[] parts = line.split(" ");
               
                 if( column == 1)
                 {
                     if(parts[0].contains("E"))
                     {
                         stage = new Estomach(0,0,game);
                         game.setStage(stage);
                      
                     }
                 }
                 else if (column < tableGame[0].length)
                 {
                    for(int file = 0;  file< parts.length ; file++ )
                    {  
                       tableGame[file][column-2] = Integer.parseInt(parts[file]); 
                       
                    } 
                 }   
             }
              stage.setTableGame(tableGame);
              stage.fixElements();
             reader.close();
            
        } catch (FileNotFoundException ex) {
            
          
        } catch (IOException ex) {
            
           
        }
    }
    
    
    
}

