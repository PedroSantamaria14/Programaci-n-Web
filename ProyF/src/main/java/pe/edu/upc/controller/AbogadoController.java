package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Abogado;
import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.service.IAbogadoService;
import pe.edu.upc.service.IEspecialidadService;

@Named
@RequestScoped
public class AbogadoController implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private IAbogadoService aService;
	@Inject
	private IEspecialidadService eService;
	
	private Abogado abogado;
	private Especialidad especialidad;
	
	List <Especialidad>listaEspecialidades;
	List <Abogado>listaAbogados;
	
	@PostConstruct
	public void init() {
		especialidad=new  Especialidad();
		abogado=new Abogado();
		listaAbogados=new ArrayList<Abogado>();
		listaEspecialidades=new ArrayList<Especialidad>();
		
		
		this.listar();
		this.listAbogado();
	}
	public String nuevoAbogado() {
		this.setAbogado(new Abogado());
		return "abogado.xhtml";
		
	}
	public void insertar () {
		try {
			aService.insertar(abogado);
			limpiarAbogado();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void listar () {
		try {
			listaEspecialidades= eService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listAbogado() {
		try {
			listaAbogados=aService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void limpiarAbogado() {
		this.init();
		
	}
	
	
	
	public Abogado getAbogado() {
		return abogado;
	}
	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
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
	public List<Abogado> getListaAbogados() {
		return listaAbogados;
	}
	public void setListaAbogados(List<Abogado> listaAbogados) {
		this.listaAbogados = listaAbogados;
	}
	
	

	
}
