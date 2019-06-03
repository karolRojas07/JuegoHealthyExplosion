/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Readers;

import Controlador.Game;

/**
 *
 * @author usuario
 */
public interface DataGameReader {
    
 public void read(String path);

    public void read(Game game);
    
    
}
