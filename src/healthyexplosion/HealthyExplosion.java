/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyexplosion;

import Controlador.Game;
import Readers.DataGameReader;
import Readers.ReaderStage;
import Views.ScreenGame;

/**
 *
 * @author usuario
 */
public class HealthyExplosion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Game gameWorld= new Game(0, 0);
        DataGameReader readerStage= new ReaderStage();
        
        gameWorld.setReaderStage(readerStage);
        ScreenGame screenGame= new ScreenGame(gameWorld);
        
        screenGame.startGame();
    }
    
}
