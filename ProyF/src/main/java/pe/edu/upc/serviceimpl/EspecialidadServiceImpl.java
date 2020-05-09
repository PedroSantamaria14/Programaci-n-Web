package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IEspecialidadDao;
import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.service.IEspecialidadService;
@Named
@RequestScoped
public class EspecialidadServiceImpl implements IEspecialidadService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEspecialidadDao mD;
	
	@Override
	
	public void insertar (Especialidad especialidad) {
		mD.insertar(especialidad);
	}
	
	@Override
	public List <Especialidad>listar(){
		return mD.listar();
	}
	

}
