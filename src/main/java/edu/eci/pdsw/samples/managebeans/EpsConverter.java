/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;

import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author DANIEL CIFUENTES
 */
@FacesConverter("epsConverter")
public class EpsConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Eps resp=null;
        ServiciosPacientes s=ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
        try {
            List<Eps> listaEps=s.obtenerEPSsRegistradas();
            for(int i=0;i<listaEps.size();i++)
                if(listaEps.get(i).getNombre().equals(value))
                    resp=listaEps.get(i);
        } catch (ExcepcionServiciosPacientes ex) {
            Logger.getLogger(EpsConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(value);
        System.out.println(resp.getNombre());
        return resp;
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o!=null)
            return ((Eps)o).getNombre();
        else return null;
    }
    
}
