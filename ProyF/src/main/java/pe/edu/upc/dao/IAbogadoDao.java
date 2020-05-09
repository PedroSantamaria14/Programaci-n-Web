package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Abogado;

public interface IAbogadoDao {
	
	public void insertar (Abogado abogado);
	
	public  List<Abogado> listar();
	
}
