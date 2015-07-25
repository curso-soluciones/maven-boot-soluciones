/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author T-107
 */
public class DAOProducto {
    
    //Tendriamos que crear algo parecido a lo del parcial
    public static void guardar(Producto p)throws Exception{
    SessionFactory fac=    HibernateUtilidades.getSessionFactory();
      Session ses= fac.openSession();
      Transaction tranza= ses.beginTransaction();
      //Guardamos
      ses.save(p);
      ses.close();
    }
    
}
