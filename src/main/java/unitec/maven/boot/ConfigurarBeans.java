/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author campitos
 */
@Configuration
public class ConfigurarBeans {
   /*
    Inyectamos la dependencia a travéz este bean
    */ 
    @Bean
    Leer Leer(){
     return new LeerMysql();
    } 
    
}
