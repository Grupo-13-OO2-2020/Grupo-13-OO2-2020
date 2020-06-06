package Grupo13OO2.services;

import java.util.List;

import Grupo13OO2.Entities.Persona;
import Grupo13OO2.Models.*;

public interface IPersonaService {

	public List<Persona> getAll();

	public PersonaModel insertOrUpdate(PersonaModel personaModel);

	public String delete(int id);

	public PersonaModel ListarId(int id);
}