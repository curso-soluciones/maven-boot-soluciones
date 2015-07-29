/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DAOTarjeta {
    SessionFactory fac;
    Session ses;
    Transaction tranza;
  //Esta clase hara todas las operaciones de sql relacionadas a 
   //los gastos: guardar, buscarTodos, buscarPorId, borrar
   //y actualizar
    public DAOTarjeta(){
     fac=      HibernateUtilidades.getSessionFactory();
     ses= fac.openSession();
     tranza=ses.beginTransaction();
    }
    
    public void cerrarSesion(){
          tranza.commit();
        ses.close();
    }
    public  void guardar(Tarjeta g)throws Exception{
  
       ses.save(g);
    cerrarSesion();
    }
    
    public ArrayList<Tarjeta> buscarTodos()throws Exception{
   
     Criteria cri=   ses.createCriteria(Tarjeta.class);
    ArrayList<Tarjeta> gastos= (ArrayList<Tarjeta>) cri.list();
    cerrarSesion();
    return gastos;
    }
    
    public Tarjeta buscarPorId(Integer id)throws Exception{
       
   Criteria cri=     ses.createCriteria(Tarjeta.class);
Tarjeta gastos= (Tarjeta) cri.add(Restrictions.idEq(id)).uniqueResult();
cerrarSesion();
return gastos;
    }
    
public void actualizar(Tarjeta g)throws Exception{
   
    ses.update(g);
    cerrarSesion();
}

public void borrar(Tarjeta g)throws Exception{
  
    ses.delete(g);
    cerrarSesion();
}
    
    
     
    
}