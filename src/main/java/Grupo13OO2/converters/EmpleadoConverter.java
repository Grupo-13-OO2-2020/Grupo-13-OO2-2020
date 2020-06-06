package Grupo13OO2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Models.EmpleadoModel;

@Component("empleadoConverter")
public class EmpleadoConverter {

	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	public EmpleadoModel entityToModel(Empleado objeto) {
		return new EmpleadoModel(objeto.getId(), objeto.getNombre(), objeto.getDni(), objeto.getApellido(),
				objeto.getFechaNacimiento(), objeto.getHorarioEntrada(), objeto.getHorarioSalida(),
				objeto.getTipoEmpleado(), objeto.getSueldo(), objeto.isGerente(),
				localConverter.entityToModel(objeto.getLocal()));
	}

	public Empleado modelToEntity(EmpleadoModel objeto) {
		return new Empleado(objeto.getId(), objeto.getNombre(), objeto.getDni(), objeto.getApellido(),
				objeto.getFechaNacimiento(), objeto.getHorarioEntrada(), objeto.getHorarioSalida(),
				objeto.getTipoEmpleado(), objeto.getSueldo(), objeto.isGerente(),
				localConverter.modelToEntity(objeto.getLocal()));
	}

	public EmpleadoModel entityToModelSetEmpleados(Empleado objeto) {
		return new EmpleadoModel(objeto.getId(), objeto.getNombre(), objeto.getDni(), objeto.getApellido(),
				objeto.getFechaNacimiento(), objeto.getHorarioEntrada(), objeto.getHorarioSalida(),
				objeto.getTipoEmpleado(), objeto.getSueldo(), objeto.isGerente());
	}

	public Empleado modelToEntitySetEmpleados(EmpleadoModel objeto) {
		return new Empleado(objeto.getId(), objeto.getNombre(), objeto.getDni(), objeto.getApellido(),
				objeto.getFechaNacimiento(), objeto.getHorarioEntrada(), objeto.getHorarioSalida(),
				objeto.getTipoEmpleado(), objeto.getSueldo(), objeto.isGerente());
	}
}