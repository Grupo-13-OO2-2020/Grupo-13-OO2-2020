package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Grupo13OO2.Entities.Lote;

@Repository("loteRepository")
public interface ILoteRepository extends JpaRepository<Lote, Integer> {
	public abstract Lote findById(int id);
	
	@Query(nativeQuery= true, value="select * from Lote l inner join Producto p on p.id=l.id inner join Local a on a.id=l.id where a.direccion LIKE %?1%")
	public List<Lote> findAll(String keyword);
}
