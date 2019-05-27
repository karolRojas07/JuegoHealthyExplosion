/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyexplosion;

import Controlador.Game;
import Readers.DataGameReader;
import Readers.ReaderStage;
import Views.Homepage;
import Views.ScreenGame;
import java.awt.Color;
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
       
       Homepage homePage = new Homepage(null,true);
       Game game = new Game (0, 0,800,700);
       ScreenGame screen = new ScreenGame(game);
       
      
       screen.setSize(800, 700); 
       screen.pack();
       screen.setHomePage(homePage);
       DataGameReader reader = new ReaderStage();
       reader.read(game);
       game.setReaderStage(reader);
       screen.openScreen();
    
       
    }

    
   
    
}
