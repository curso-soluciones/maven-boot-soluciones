/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author campitos
 */

@Controller
@EnableAutoConfiguration
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
  
    @RequestMapping("/")
    @ResponseBody String hola(){
        
        return "Hola mundo";
    }
    public static void main(String[] args) {
        // TODO code application logic here
        SpringApplication.run(Aplicacion.class, args);
    }
    
}
