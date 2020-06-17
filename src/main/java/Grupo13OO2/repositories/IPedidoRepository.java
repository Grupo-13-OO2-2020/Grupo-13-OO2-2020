package Grupo13OO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import Grupo13OO2.Entities.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {

	
}
