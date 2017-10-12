/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.services.*;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Date;

/**
 *
 * @author hcadavid
 * Clases de equivalencia
 * CLASE 1: SI recibe un paciente valido lo agrega lo agrega al Map pacientes.
 * Retorna Null
 * 
 * METODO agregarConsultaPaciente
 * 
 * CE1: hay error en persistencia o paciente no existe
 * Resultado esperado: Error
 * 
 * CE2: no hay error en persistencia y paciente existe
 * Resultado esperado: se agrega una consulta al paciente especificado.
 * 
 * Condiciones de frontera:
 * 
 * CF1: no hay error en persistencia y paciente no existe
 * Clases relacionadas: CE1,CE2
 * Resultado esperado: Error - El paciente no existe
 * 
 * CF2: hay error en persistencia y paciente existe
 * Clases relacionadas: CE1,CE2
 * Resultado esperado: Error - Error en persistencia
 * 
 * CF3: hay error en persistencia y paciente no existe
 * Clases relacionadas: CE1
 * Resultado esperado: Error
 * 
 * CF4: no hay error en persistencia y paciente existe
 * Clases relacionadas: CE2
 * Resultado esperado: Se agrega una consulta al paciente especificado.
 */
public class ServiciosPacientesTest {
    @Test
    public void testRegistroPaciente() throws ExcepcionServiciosPacientes{
        Paciente pa1 = new Paciente(132456,"CC","PEPITA",Date.valueOf("1982-02-25"), new Eps("PEPITAS", "1241241"));
        Paciente pa2=new Paciente(9587456, "TI","Pepote",Date.valueOf("2004-01-29"), new Eps("PEPIToS", "124646"));
        ServiciosPacientes ps=new ServiciosHistorialPacientesFactory().getInstance().getServiciosPaciente();
        ps.registrarNuevoPaciente(pa2);
        ps.registrarNuevoPaciente(pa1);    
    
    }
    
    @Test
    public void testAgregarConsultaPacienteCE1() throws ExcepcionServiciosPacientes {
        
//        Consulta con= new Consulta();    
//        //con = new Consulta(Date.valueOf("12-1-1") , "Se murio", 99999);
//
//        ServiciosPacientes sp= ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
//
//        try {
//            sp.agregarConsultaPaciente(9999, "TI", con);
//        } catch (ExcepcionServiciosPacientes ex) {
//            assertEquals("No se esta lanzando la excepcion adecuada para CF1"
//                    ,"El paciente con identificacion 123 no existe",ex.getMessage());
//        }
    }
    
    @Test
    public void testAgregarConsultaPacienteCE2()throws ExcepcionServiciosPacientes    {
        ServiciosPacientes sp= ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
        
        try {
            Consulta c=new Consulta();
            sp.registrarNuevoPaciente(new Paciente(132456,"CC","PEPITA",Date.valueOf("1982-02-25"), new Eps("PEPITAS", "1241241")));
            sp.agregarConsultaPaciente(132456,"CC",c);
            
            assertTrue("No se esta agregando correctamente la consulta",sp.obtenerConsultasEps("PEPITAS").contains(c));
        } catch (ExcepcionServiciosPacientes ex) {
            Logger.getLogger(ServiciosPacientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    
    
    
}
