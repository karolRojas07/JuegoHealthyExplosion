/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Readers;

import Containers.Container;
import Stages.Estomach;
import Stages.Heart;
import Stages.Lung;
import Stages.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Read the information about any stage
 * @author Maaría y Karol
 */
public class ReaderStage implements DataGameReader{

    /**
     * The Stage 
     */
    private Stage stage ;
    
    /**
     * To read where to put the wall box
     */
    private final int[][] tableGame;
    
    /**
     * Create new ReaderStage
     */
    public ReaderStage() {  tableGame = new int[19][16]; }  
    
    /**
     * Read the stage
     * @param file the name of the file to read the stage
     * @param container where is painted the stage
     * @return the stage read
     */   
    @Override
    public Stage read(String file, Container container)
    {
        try{
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
                        stage= new Estomach(0,10000,0,0,container);
                        stage.setLife(100);
                    }
                    if(parts[0].contains("L"))
                    {
                        stage= new Lung(0,15000,0,0,container);
                          stage.setLife(100);
                    }
                    if(parts[0].contains("H"))
                    {
                        stage=new Heart(0,25000,0,0,container);
                        stage.setLife(100);
                    }
                    else
                    {
                        System.out.println("no se pone ");
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
              
              return stage;
             
            
        } catch (FileNotFoundException ex) { }
          catch (IOException ex) { }
        
        return stage;
    }
}

