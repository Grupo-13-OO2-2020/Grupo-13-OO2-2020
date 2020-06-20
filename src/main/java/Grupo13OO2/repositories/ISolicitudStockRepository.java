package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Grupo13OO2.Entities.SolicitudStock;

@Repository("solicitudStockRepository")
public interface ISolicitudStockRepository extends JpaRepository<SolicitudStock, Integer> {
	public abstract SolicitudStock findById(int id);
	
	@Query("SELECT s FROM SolicitudStock s WHERE s.fecha LIKE %?1%")
	public List<SolicitudStock> findAll(String keyword);
}
