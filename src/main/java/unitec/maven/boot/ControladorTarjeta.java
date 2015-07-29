/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.maven.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author campitos
 */

@Controller
@RequestMapping("/")
public class ControladorTarjeta {
    
    @RequestMapping(value="/tarjeta/{nombre}/{fechaCorte}", method = RequestMethod.POST, headers={"Accept=text/html"})
    @ResponseBody String guardarTarjeta(@PathVariable String nombre, @PathVariable Integer fechaCorte)throws Exception{
        Tarjeta t=new Tarjeta();
        t.setDiaCorte(fechaCorte);
        t.setNombre(nombre);
        DAOTarjeta dao=new DAOTarjeta();
        
        return "Tarjeta guardada con éxito";
    }
    
}
