package pe.edu.upcdaoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IClienteDao;
import pe.edu.upc.entity.Cliente;

public class ClienteDaoImpl implements IClienteDao, Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="a")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar (Cliente cliente){
		try {
			em.persist(cliente);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List <Cliente>listar() {
		List <Cliente>lista =new ArrayList<Cliente>();
		
		try {
			Query q =em.createQuery("select m from Cliente m");
			lista=(List<Cliente>)	q.getResultList();
			}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	

}
