package Grupo13OO2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Producto;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
	public abstract Producto findById(int id);

	@Query("SELECT p FROM Producto p WHERE p.descripcion LIKE %?1%")
	public List<Producto> findAll(String keyword);
}
