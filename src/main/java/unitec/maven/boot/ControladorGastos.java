/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author campitos
 */
@RestController
@RequestMapping("/")
public class ControladorGastos {
    
    @RequestMapping(value="/gastos", method=RequestMethod.GET,
            headers={"Accept=application/json"})
    @ResponseBody ArrayList<Gastos> obtenerTodos()throws Exception{
        DAOGastos dao=new DAOGastos();
       return  dao.buscarTodos();     
    }
    
    @RequestMapping(value="/gastos/{idTarjeta}/"
            + "{concepto}/{fecha}/{cantidad}",
            method=RequestMethod.POST,
            headers={"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable Integer idTarjeta,
            @PathVariable String concepto,
            @PathVariable Date fecha, @PathVariable Float cantidad )throws Exception{
         DAOGastos dao=new DAOGastos();
         Gastos g=new Gastos();
               g.setIdTarjeta(new Tarjeta(idTarjeta));
               g.setCantidad(cantidad);
               g.setFecha(fecha);
               g.setConcepto(concepto);
               
               dao.guardar(g);
               return "Gastos guardado con exito";
               
    }
            
    
}
