package Grupo13OO2.converters;

import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Models.EmpleadoModel;

@Component("empleadoConverter")
public class EmpleadoConverter {
	public EmpleadoModel entityToModel(Empleado objeto) {
		return new EmpleadoModel(objeto.getId(), objeto.getNombre(), objeto.getDni(), objeto.getApellido(), objeto.getFechaNacimiento(), objeto.getHorarioEntrada(), objeto.getHorarioSalida(),
				objeto.getTipoEmpleado(), objeto.getSueldo(), objeto.getIdLocal());
	}

	public Empleado modelToEntity(EmpleadoModel objeto) {
		return new Empleado(objeto.getId(), objeto.getNombre(), objeto.getDni(), objeto.getApellido(),
				objeto.getFechaNacimiento(), objeto.getHorarioEntrada(), objeto.getHorarioSalida(),
				objeto.getTipoEmpleado(), objeto.getSueldo(), objeto.getIdLocal());
	}
}