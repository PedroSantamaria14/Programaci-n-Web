package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Especialidad;

public interface IEspecialidadService {
	public Integer insert(Especialidad especialidad);

	public void delete(long idEspecialidad);

	List<Especialidad> list();

}
