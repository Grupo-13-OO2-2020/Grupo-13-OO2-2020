package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Grupo13OO2.Entities.Remito;

public interface IRemitoRepository extends JpaRepository<Remito, Integer> {
	
//	
//	@Query("select r from Remito r inner join Pedido p on p.id=r.id inner join Empleado e on p.vendedor_id=e.id inner join Local l on e.local_id = l.id  where l.direccion LIKE %?1%")
//	public List<Remito> findAll(String keyword);
	
	@Query(nativeQuery= true, value=  "select p.*,r.forma_de_pago FROM remito r INNER JOIN pedido p on r.id = p.id INNER JOIN producto pr on p.producto_id = pr.id WHERE pr.descripcion LIKE %?1%")
	public List<Remito> findAll(String keyword);
	
}
