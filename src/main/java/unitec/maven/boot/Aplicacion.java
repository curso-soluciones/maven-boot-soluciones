/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

import java.util.Date;
import org.apache.catalina.core.ApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
    @ResponseBody
    String hola() {

        return "Hola mundo";
    }

    public static void main(String[] args)throws Exception{
        // TODO code application logic here
        SpringApplication.run(Aplicacion.class, args);
        Tarjeta t=new Tarjeta();
           t.setNombre("Banamex");
          t.setDiaCorte(28);
        Gastos g1=new Gastos();
        g1.setIdTarjeta(new Tarjeta(2));
        g1.setFecha(new Date());
        g1.setConcepto("six de gerber");
        g1.setCantidad(200f); 
     
    SessionFactory fac=           HibernateUtilidades.getSessionFactory();
   Session ses=               fac.openSession();
   Transaction tranza=ses.beginTransaction();
   ses.save(g1);
   tranza.commit();
 ses.close();
        System.out.println("guardado con exito");
            
          
    }

}
