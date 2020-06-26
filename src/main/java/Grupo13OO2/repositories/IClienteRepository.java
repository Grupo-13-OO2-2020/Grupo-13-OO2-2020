package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Cliente;

@Repository("clienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
	public abstract Cliente findById(int id);

	@Query(nativeQuery=true,value="Select e.*,pe.* from cliente e inner join persona pe on e.id = pe.id inner join pedido p on e.id = p.cliente_id  where  p.cliente_id=(:id)")
	public List<Cliente> findIfExist(int id);
}