package Grupo13OO2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Lote;

@Repository("loteRepository")
public interface ILoteRepository extends JpaRepository<Lote, Integer> {
	public abstract Lote findById(int id);

	@Query(value = "SELECT * FROM lote WHERE local_id = ?1 ORDER BY ?#{#pageable}",
       countQuery = "SELECT count(*) FROM lote WHERE local_id = ?1",
       nativeQuery = true)
	Page<Lote> findByLocal(int local, Pageable pageable);
	
}
