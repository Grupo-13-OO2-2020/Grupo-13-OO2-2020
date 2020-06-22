package Grupo13OO2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Empleado;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
	public abstract Empleado findById(int id);
	
	//@Query("SELECT e FROM Empleado e WHERE e.user_id = ?1")
	@Query( 
			value="SELECT * FROM empleado e WHERE e.user_id= ?1",
			nativeQuery=true)
	public abstract Empleado findByUserId(int userId);
	@Query( 
	value="SELECT * FROM empleado e INNER JOIN user u on e.user_id=u.id  WHERE u.username= ?1",
	nativeQuery=true)
public abstract Empleado findByUserName(String userName);
}