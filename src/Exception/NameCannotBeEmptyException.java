/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author KAREN TATIANA
 */
public class NameCannotBeEmptyException extends RuntimeException{

    @Override
    public String getMessage() {
        return "You must put a name to the game" ;
    }
    
    
    
}
