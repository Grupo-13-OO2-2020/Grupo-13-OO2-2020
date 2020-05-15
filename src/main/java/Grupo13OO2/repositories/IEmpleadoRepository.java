package Grupo13OO2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Grupo13OO2.Entities.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
    
}