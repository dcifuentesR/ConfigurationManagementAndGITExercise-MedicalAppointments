/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 * Clases de equivalencia
 * CLASE 1: SI recibe un paciente valido lo agrega lo agrega al Map pacientes.
 * Retorna Null
 * 
 * 
 */
public class ServiciosPacientesTest {
    @Test
    public void testRegistroPaciente() throws ExcepcionServiciosPacientes{
        Paciente pa1 = new Paciente(132456,"CC","PEPITA",new Date("1982-02-25"), new Eps("PEPITAS", "1241241"));
        Paciente pa2=new Paciente(9587456, "TI","Pepote",new Date("20041-01-29"), new Eps("PEPIToS", "124646"));
        ServiciosPacientes ps = null;
        ps.registrarNuevoPaciente(pa2);
        ps.registrarNuevoPaciente(pa1);
        
        
        
    
    
    
    
    }
    

    
    
    
}
