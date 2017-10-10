/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import java.util.List;
import edu.eci.pdsw.samples.entities.Paciente;

/**
 *
 * @author 2116387
 */
public interface PacienteDAO {
    
    public List<Paciente> loadAll();
    
    public void load();
    
    public void loadByID();
}
