package pe.edu.upcdaoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IAbogadoDao;
import pe.edu.upc.entity.Abogado;

public class AbogadoDaoImpl implements IAbogadoDao, Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="a")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar (Abogado abogado){
		try {
			em.persist(abogado);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List <Abogado>listar() {
		List <Abogado>lista =new ArrayList<Abogado>();
		
		try {
			Query q =em.createQuery("select m from Abogado m");
			lista=(List<Abogado>)	q.getResultList();
			}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	

}
