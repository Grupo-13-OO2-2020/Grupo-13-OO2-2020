package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Cliente;


@Repository("clienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
	public abstract Cliente findById(int id);
	
	@Query(nativeQuery= true, value="select * from Cliente c inner join Persona p on p.id=c.id where p.apellido LIKE %?1%")
	public List<Cliente> findAll(String keyword);
}