/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author campitos
 */

@ComponentScan
@Controller
@EnableAutoConfiguration
public class Aplicacion {

  
    @RequestMapping("/")
    @CrossOrigin
    @ResponseBody String hola(){
        
        return "Hola mundo";
    }
    public static void main(String[] args) {
        // TODO code application logic here
        SpringApplication.run(Aplicacion.class, args);
        
    }
    
}
