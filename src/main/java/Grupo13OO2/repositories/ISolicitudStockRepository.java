package Grupo13OO2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.SolicitudStock;

@Repository("solicitudStockRepository")
public interface ISolicitudStockRepository extends JpaRepository<SolicitudStock, Integer> {
	public abstract SolicitudStock findById(int id);
}
