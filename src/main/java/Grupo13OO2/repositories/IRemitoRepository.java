package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import Grupo13OO2.Entities.Remito;

public interface IRemitoRepository extends JpaRepository<Remito, Integer> {

	@Query("SELECT r FROM Remito r WHERE r.fecha LIKE %?1%")
	public List<Remito> findAll(String keyword);
}
