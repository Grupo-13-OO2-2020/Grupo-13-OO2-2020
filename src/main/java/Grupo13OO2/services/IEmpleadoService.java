package Grupo13OO2.services;

import java.util.List;

import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Models.EmpleadoModel;

public interface IEmpleadoService {
	public List<Empleado> getAll();

	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel);

	public EmpleadoModel ListarId(int id);

	public String delete(int id);
}