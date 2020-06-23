package Grupo13OO2.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Models.EmpleadoModel;

public interface IEmpleadoService {
	public List<EmpleadoModel> getAll();

	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel);

	public EmpleadoModel ListarId(int id);

	public String delete(int id);
	
	Page<EmpleadoModel> getAllPages(Pageable pageable);

	public double sueldoxEmpleado(EmpleadoModel empleado);
}