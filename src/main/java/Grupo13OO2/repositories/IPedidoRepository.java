package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import Grupo13OO2.Entities.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {

	@Query("SELECT p FROM Pedido p WHERE p.fecha LIKE %?1%")
	public List<Pedido> findAll(String keyword);
}
