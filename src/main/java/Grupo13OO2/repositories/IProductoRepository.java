package Grupo13OO2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Producto;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
	public abstract Producto findById(int id);
}
