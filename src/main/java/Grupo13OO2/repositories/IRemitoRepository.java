package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Remito;

@Repository("remitoRepository")
public interface IRemitoRepository extends JpaRepository<Remito, Integer> {
	public abstract Remito findById(int id);

	@Query(nativeQuery= true, value=  "select * from Remito r inner join Pedido p on r.id=p.id inner join Empleado e on p.vendedor_id=e.id inner join Local l on e.local_id=l.id where l.direccion LIKE %?1%")
	public List<Remito> findAll(String keyword);

}
