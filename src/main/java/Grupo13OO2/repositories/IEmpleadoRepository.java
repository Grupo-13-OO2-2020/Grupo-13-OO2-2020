package Grupo13OO2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Empleado;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
    public abstract Empleado findById(int id);
}