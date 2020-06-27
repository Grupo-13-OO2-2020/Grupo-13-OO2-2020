package Grupo13OO2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.SolicitudStock;

@Repository("solicitudStockRepository")
public interface ISolicitudStockRepository extends JpaRepository<SolicitudStock, Integer> {

	public abstract SolicitudStock findById(int id);

	@Query(value = "SELECT pe.*,s.* FROM solicitud_stock s INNER JOIN pedido pe on pe.id= s.id WHERE s.local_id = ?1 ORDER BY ?#{#pageable}", countQuery = "SELECT count(*) FROM solicitud_stock WHERE local_id = ?1", nativeQuery = true)
	Page<SolicitudStock> findByLocal(int local, Pageable pageable);

//	@Query("select s from SolicitudStock s , Local l where s.local_id = l.id  and l.direccion LIKE %?1%")
//	public List<SolicitudStock> findAll(String keyword);
//	

}
