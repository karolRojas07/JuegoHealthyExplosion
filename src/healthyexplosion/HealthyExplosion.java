/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyexplosion;

import Controlador.Game;
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
        
        ScreenGame screenGame= new ScreenGame(gameWorld);
        
        screenGame.startGame();
    }
    
}
