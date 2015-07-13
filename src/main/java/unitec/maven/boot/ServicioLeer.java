/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

/**
 *
 * @author campitos
 */
public class ServicioLeer {
    
    Leer leer;
    public ServicioLeer(){
        this.leer=leer;
    }
    
    public String servicioLeer(){
       return leer.leer();
    }
    
}
