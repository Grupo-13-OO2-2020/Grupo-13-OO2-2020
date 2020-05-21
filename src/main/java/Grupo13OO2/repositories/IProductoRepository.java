package Grupo13OO2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Grupo13OO2.Entities.Producto;

public interface IProductoRepository extends JpaRepository <Producto,Integer> {

}
