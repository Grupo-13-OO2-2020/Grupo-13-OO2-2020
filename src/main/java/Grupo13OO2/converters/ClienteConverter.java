package Grupo13OO2.converters;

import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Cliente;
import Grupo13OO2.Models.ClienteModel;

@Component("clienteConverter")
public class ClienteConverter {
	public ClienteModel entityToModel(Cliente objeto) {
		return new ClienteModel(objeto.getId(), objeto.getNombre(), objeto.getDni(), objeto.getApellido(),
				objeto.getFechaNacimiento(), objeto.getEmail(), objeto.getNumero(), objeto.getCuit(), objeto.getCuil());
	}

	public Cliente modelToEntity(ClienteModel objeto) {
		return new Cliente(objeto.getId(), objeto.getNombre(), objeto.getDni(), objeto.getApellido(),
				objeto.getFechaNacimiento(), objeto.getEmail(), objeto.getNumero(), objeto.getCuit(), objeto.getCuil());
	}
}