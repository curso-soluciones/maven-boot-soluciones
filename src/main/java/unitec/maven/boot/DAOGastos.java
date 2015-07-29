/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author campitos
 */
public class DAOGastos {
    SessionFactory fac;
    Session ses;
    Transaction tranza;
  //Esta clase hara todas las operaciones de sql relacionadas a 
   //los gastos: guardar, buscarTodos, buscarPorId, borrar
   //y actualizar
    public void abrirSesion(){
     fac=      HibernateUtilidades.getSessionFactory();
     ses= fac.openSession();
     tranza=ses.beginTransaction();
    }
    
    public void cerrarSesion(){
          tranza.commit();
        ses.close();
    }
    public  void guardar(Gastos g)throws Exception{
    abrirSesion();
       ses.save(g);
    cerrarSesion();
    }
    
    public ArrayList<Gastos> buscarTodos()throws Exception{
        abrirSesion();
     Criteria cri=   ses.createCriteria(Gastos.class);
    ArrayList<Gastos> gastos= (ArrayList<Gastos>) cri.list();
    cerrarSesion();
    return gastos;
    }
    
    public Gastos buscarPorId(Integer id)throws Exception{
        abrirSesion();
   Criteria cri=     ses.createCriteria(Gastos.class);
Gastos gastos= (Gastos) cri.add(Restrictions.idEq(id)).uniqueResult();
cerrarSesion();
return gastos;
    }
    
public void actualizar(Gastos g)throws Exception{
    abrirSesion();
    ses.update(g);
    cerrarSesion();
}

public void borrar(Gastos g)throws Exception{
    abrirSesion();
    ses.delete(g);
    cerrarSesion();
}
    
    
     
    
}
