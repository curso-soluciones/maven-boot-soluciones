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
        //Paso 1 abrrir una sesssion factory
 SessionFactory fac=       HibernateUtilidades.getSessionFactory();
  Session sesion= fac.openSession();
  Transaction tranza=sesion.beginTransaction();
  Tarjeta t=new Tarjeta();
          t.setDiaCorte(28);
          t.setNombre("BANAMEX");
        // sesion.save(t);
          
      Gastos g=new Gastos();
          g.setCantidad(300f);
          g.setConcepto("cena baile");
          g.setFecha(new Date()); 
          g.setIdTarjeta(new Tarjeta(1)); 
        // sesion.save(g);
          
          
         tranza.commit();
         sesion.close();
         System.out.println("Tarjeta guadada con exito");
 
          
    }

}
