/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;


import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import java.sql.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "HistorialPacientes")
@SessionScoped
public class RegistroConsultaBean implements Serializable {
    
    private final ServiciosPacientes servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
    List<Paciente> pacientes;
    int idPaciente;
    String tipoId;
    String nombre;
    Date fechaNacimiento;
    Eps eps;
    Eps epsSeleccionada;
    //
    Paciente pacienteSelecionado; 
    String NuevoResumen;
    Long    CostoNuevo;
    Date FechaConsulta;
    //
    public void setNuevoResumen(String NueResum){
        NuevoResumen=NueResum;

    }
    public void setCostoNuevo(Long cost){
        CostoNuevo=cost;
    }
    public void setFechaConsulta(Date nuevFecha){
        FechaConsulta=nuevFecha;
    }
    
    public Paciente getPacienteSelecionado(){
    
        return pacienteSelecionado;
    }
    public void setPacienteSeleccionado(Paciente paciente){
        pacienteSelecionado=paciente;
    }

    public Set<Consulta> getConsultaspacSeleccionado(){
        return pacienteSelecionado.getConsultas();
    
    }

    public List<Paciente> getPacientes() throws ExcepcionServiciosPacientes {
        return servicepacientes.consultarPacientes();
    }
    
    public List<Eps> getListaEPS() throws ExcepcionServiciosPacientes
    {
        return servicepacientes.obtenerEPSsRegistradas();
    }
    public void setAgregarNuevaCons() throws ExcepcionServiciosPacientes{
        int tam= getConsultaspacSeleccionado().size();
        Consulta con=new Consulta(FechaConsulta,NuevoResumen,CostoNuevo);
        servicepacientes.agregarConsultaPaciente(tam+1, pacienteSelecionado.getTipoId(), con);
    
    }
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    //public long costoConsul(){
      //  return pacienteSelecionado.getConsultas().g
        
    
    //}

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Eps getEPSSeleccionada() {
        return epsSeleccionada;
    }

    public void setEPSSeleccionada(Eps epsSeleccionada) {
        this.epsSeleccionada = epsSeleccionada;
    }
    
    public void registrarPaciente() throws ExcepcionServiciosPacientes
    {
        servicepacientes.registrarNuevoPaciente(new Paciente(idPaciente, tipoId, nombre, fechaNacimiento, epsSeleccionada));
    }

    public RegistroConsultaBean() throws ExcepcionServiciosPacientes {
        //pacienteSelecionado= new Paciente(12,"CC","PEPITO", Date.valueOf("12-12-12"),new Eps("pepa", "12312"));
        //Consulta con=new Consulta(Date.valueOf("12-1-1") , "Se murio", 99999);    
        //pacienteSelecionado.setConsultas( (Set<Consulta>) con);
        pacienteSelecionado=servicepacientes.consultarPaciente(1, "CC");

    }

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }


}
