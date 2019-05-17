/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyexplosion;

import Controlador.Game;
import Readers.ReaderStage;
import Views.ScreenGame;
import java.awt.Graphics;
import static javax.swing.Spring.height;

/**
 *
 * @author usuario
 */
public class HealthyExplosion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       Game game = new Game (0, 0,800, 800);
       ScreenGame screen = new ScreenGame(game);
       screen.setSize(800, 800); 
       screen.pack();
       ReaderStage reader = new ReaderStage();
       reader.read(game);
       game.setReaderStage(reader);
       screen.open();
       
    }

   
    
}
