package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.service.IClienteService;
@Named
@RequestScoped
public class ClienteController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private IClienteService mService;
	private Cliente cliente;
	List <Cliente>listaClientes;
	
	@PostConstruct
	public void init() {
		this.listaClientes=new ArrayList<Cliente>();
		this.cliente= new Cliente();
		this.listar();
	}
	public String nuevoCliente() {
		this.setCliente(new Cliente());
		return "cliente.xhtml";
		
	}
	public void insertar () {
		try {
			mService.insertar(cliente);
			limpiarCliente();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void listar () {
		try {
			listaClientes= mService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void limpiarCliente() {
		this.init();
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
}
