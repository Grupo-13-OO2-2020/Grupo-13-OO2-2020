package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Grupo13OO2.Entities.SolicitudStock;

@Repository("solicitudStockRepository")
public interface ISolicitudStockRepository extends JpaRepository<SolicitudStock, Integer> {
	
	public abstract SolicitudStock findById(int id);
	

	@Query(nativeQuery= true, value=  "select * from SolicitudStock s inner join Pedido p on s.id=p.id inner join Empleado e on p.vendedor_id=e.id inner join Local l on e.local_id=l.id inner join Empleado n on s.colaborador_id=n.id inner join Local m on s.local_di=m.id where l.direccion LIKE %?1%")
	public List<SolicitudStock> findAll(String keyword);

}
