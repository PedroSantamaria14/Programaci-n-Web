package pe.edu.upcdaoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IEspecialidadDao;
import pe.edu.upc.entity.Especialidad;

public class EspecialidadDaoImpl implements IEspecialidadDao, Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="a")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar (Especialidad especialidad){
		try {
			em.persist(especialidad);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List <Especialidad>listar() {
		List <Especialidad>lista =new ArrayList<Especialidad>();
		
		try {
			Query q =em.createQuery("select m from Especialidad m");
			lista=(List<Especialidad>)	q.getResultList();
			}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	

}
