package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.repository.IEspecialidadRepository;
import pe.edu.upc.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadRepository esR;

	@Override
	@Transactional
	public Integer insert(Especialidad especialidad) {
		int rpta = esR.buscarNombreEspecialidad(especialidad.getName());
		if (rpta == 0) {
			esR.save(especialidad);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void delete(long idEspecialidad) {
		esR.deleteById(idEspecialidad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Especialidad> list() {
		// TODO Auto-generated method stub
		return esR.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

}
