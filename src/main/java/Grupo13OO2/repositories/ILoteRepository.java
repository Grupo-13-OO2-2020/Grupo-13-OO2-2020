package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Grupo13OO2.Entities.Lote;

@Repository("loteRepository")
public interface ILoteRepository extends JpaRepository<Lote, Integer> {
	public abstract Lote findById(int id);
	
	@Query("SELECT l FROM Lote l WHERE l.numeroDeLote LIKE %?1%")
	public List<Lote> findAll(String keyword);
}
