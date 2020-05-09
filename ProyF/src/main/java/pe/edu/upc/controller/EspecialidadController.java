package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.service.IEspecialidadService;
@Named
@RequestScoped
public class EspecialidadController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private IEspecialidadService mService;
	private Especialidad especialidad;
	List <Especialidad>listaEspecialidades;
	
	@PostConstruct
	public void init() {
		this.listaEspecialidades=new ArrayList<Especialidad>();
		this.especialidad= new Especialidad();
		this.listar();
	}
	public String nuevoCliente() {
		this.setEspecialidad(new Especialidad());
		return "cliente.xhtml";
		
	}
	public void insertar () {
		try {
			mService.insertar(especialidad);
			limpiarEspecialidad();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void listar () {
		try {
			listaEspecialidades= mService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void limpiarEspecialidad() {
		this.init();
		
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public List<Especialidad> getListaEspecialidades() {
		return listaEspecialidades;
	}
	public void setListaEspecialidades(List<Especialidad> listaEspecialidades) {
		this.listaEspecialidades = listaEspecialidades;
	}
	
}
