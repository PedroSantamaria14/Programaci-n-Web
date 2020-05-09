package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IAbogadoDao;
import pe.edu.upc.entity.Abogado;
import pe.edu.upc.service.IAbogadoService;
@Named
@RequestScoped
public class AbogadoServiceImpl implements IAbogadoService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAbogadoDao mD;
	
	@Override
	
	public void insertar (Abogado abogado) {
		mD.insertar(abogado);
	}
	
	@Override
	public List <Abogado>listar(){
		return mD.listar();
	}
	

}
