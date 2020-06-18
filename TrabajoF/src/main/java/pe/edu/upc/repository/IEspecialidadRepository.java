package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Especialidad;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Long> {
	@Query("select count(c.name) from Especialidad c where c.name =:name")
	public int buscarNombreEspecialidad(@Param("name") String nombreEspecialidad);
}
