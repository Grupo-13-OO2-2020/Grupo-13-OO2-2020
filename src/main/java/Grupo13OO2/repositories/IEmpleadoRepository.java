package Grupo13OO2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Empleado;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
	public abstract Empleado findById(int id);

	@Query(value = "SELECT * FROM empleado WHERE local_id = ?1 ORDER BY ?#{#pageable}",
       countQuery = "SELECT count(*) FROM empleado WHERE local_id = ?1",
       nativeQuery = true)
	Page<Empleado> findByLocal(int local, Pageable pageable);
}