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

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    Eps epsSeleccionada;
    //
    Paciente pacienteSeleccionado;
    String NuevoResumen;
    Long    CostoNuevo;
    Date FechaConsulta;

    public String getNuevoResumen() {
        return NuevoResumen;
    }

    public void setNuevoResumen(String NuevoResumen) {
        this.NuevoResumen = NuevoResumen;
    }

    public Long getCostoNuevo() {
        return CostoNuevo;
    }

    public void setCostoNuevo(Long CostoNuevo) {
        this.CostoNuevo = CostoNuevo;
    }

    public Date getFechaConsulta() {
        return FechaConsulta;
    }

    public void setFechaConsulta(Date FechaConsulta) {
        this.FechaConsulta = FechaConsulta;
    }
    
    public void setPacienteSeleccionado(Paciente paciente){
        this.pacienteSeleccionado=paciente;
    }
    
    public Paciente getPacienteSeleccionado(){
    
        return pacienteSeleccionado;
    }
    

    public Set<Consulta> getConsultaspacSeleccionado(){
        return pacienteSeleccionado.getConsultas();
    
    }

    public List<Paciente> getPacientes() throws ExcepcionServiciosPacientes {
        return servicepacientes.consultarPacientes();
    }
    
    public List<Eps> getListaEPS() throws ExcepcionServiciosPacientes
    {
        return servicepacientes.obtenerEPSsRegistradas();
    }
    public void agregarConsulta() throws ExcepcionServiciosPacientes{
        servicepacientes.agregarConsultaPaciente(pacienteSeleccionado.getId(),pacienteSeleccionado.getTipoId(),new Consulta(FechaConsulta,NuevoResumen,CostoNuevo));
    
    }
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

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
        System.out.println("pasaGet");
        return epsSeleccionada;
    }

    public void setEPSSeleccionada(Eps epsSeleccionada) {
        System.out.println("pasaSet");
        this.epsSeleccionada = epsSeleccionada;
    }
    
    public void registrarPaciente() throws ExcepcionServiciosPacientes
    {
        System.out.println("pasaReg");
        servicepacientes.registrarNuevoPaciente(new Paciente(idPaciente, tipoId, nombre, fechaNacimiento, epsSeleccionada));
    }

    public RegistroConsultaBean() throws ExcepcionServiciosPacientes {
        //pacienteSeleccionado= new Paciente(12,"CC","PEPITO", Date.valueOf("12-12-12"),new Eps("pepa", "12312"));
        //Consulta con=new Consulta(Date.valueOf("12-1-1") , "Se murio", 99999);    
        //pacienteSeleccionado.setConsultas( (Set<Consulta>) con);
        //pacienteSeleccionado=servicepacientes.consultarPaciente(1, "CC");

    }
    
    public String verConsultas()
    {
        return "registroconsultas";
    }

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }


}
