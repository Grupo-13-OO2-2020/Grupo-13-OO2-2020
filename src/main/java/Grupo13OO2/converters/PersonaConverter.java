package Grupo13OO2.converters;

import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Persona;
import Grupo13OO2.Models.PersonaModel;

@Component("personaConverter")
public class PersonaConverter {
	public PersonaModel entityToModel(Persona persona) {
		return new PersonaModel(persona.getId(), persona.getNombre(), persona.getDni(), persona.getApellido(),
				persona.getFechaNacimiento());
	}

	public Persona modelToEntity(PersonaModel persona) {
		return new Persona(persona.getId(), persona.getNombre(), persona.getDni(), persona.getApellido(),
				persona.getFechaNacimiento());
	}
}