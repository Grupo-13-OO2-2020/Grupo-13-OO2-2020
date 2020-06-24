package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Grupo13OO2.Entities.Local;

@Repository("localRepository")
public interface ILocalRepository extends JpaRepository<Local, Integer> {
	public abstract Local findById(int id);
	
	@Query(nativeQuery= true, value="select * from Local l where l.direccion LIKE %?1%")
	public List<Local> findAll(String keyword);
}
