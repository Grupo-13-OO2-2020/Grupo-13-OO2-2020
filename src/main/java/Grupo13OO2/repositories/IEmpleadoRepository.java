package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Grupo13OO2.Entities.Empleado;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
	public abstract Empleado findById(int id);
	
	@Query("SELECT e FROM Empleado e WHERE e.apellido LIKE %?1%")
	public List<Empleado> findAll(String keyword);
}