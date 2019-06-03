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
 * Read the information about any stage
 * @author Maaría y Karol
 */
public class ReaderStage implements DataGameReader{

    private ArrayList<Box> boxes;
    private Game game;
    private Stage stage ;
    private int[][] tableGame;

    public ReaderStage() {
        boxes = new ArrayList<>();
        tableGame = new int[19][16];
    }
    
    /**
     * Get the list of the boxes in the stage
     * @return 
     */
    public ArrayList<Box> getBoxes() { return boxes; }



    /**
     * 
     * @param file the name of the file
     */
    @Override
    public void read( String file) {
        
        try {
             RandomAccessFile reader = new RandomAccessFile(file, "r");
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
                    for(int i = 0;  i< parts.length ; i++ )
                    {  
                       tableGame[i][column-2] = Integer.parseInt(parts[i]); 
                    } 
                 }   
             }
             stage.setTableGame(tableGame);
             stage.fixElements();
             reader.close();
        } catch (FileNotFoundException ex) { } 
          catch (IOException ex) {        }     
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
            
        } catch (FileNotFoundException ex) { }
          catch (IOException ex) { }
    }
    
    
    
}

