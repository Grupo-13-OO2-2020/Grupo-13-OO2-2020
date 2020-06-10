package Grupo13OO2.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Persona;
import Grupo13OO2.Models.PersonaModel;
import Grupo13OO2.converters.PersonaConverter;
import Grupo13OO2.repositories.IPersonaRepository;
import Grupo13OO2.services.IPersonaService;

@Service("personaService")
public class PersonaService implements IPersonaService {
	@Autowired
	private IPersonaRepository personaRepository;

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;

	@Override
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}

	@Override
	public PersonaModel insertOrUpdate(PersonaModel personaModel) {
		Persona persona = personaRepository.save(personaConverter.modelToEntity(personaModel));
		return personaConverter.entityToModel(persona);
	}

	@Override
	public String delete(int id) {
		personaRepository.deleteById(id);
		return "Persona borrada" + id;
	}

	@Override
	public PersonaModel ListarId(int id) {

		Optional<Persona> persona = personaRepository.findById(id);

		return personaConverter.entityToModel(persona.get());
	}

}