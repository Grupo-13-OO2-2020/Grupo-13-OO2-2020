package Grupo13OO2.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Grupo13OO2.Models.ClienteModel;;

public interface IClienteService {
	public List<ClienteModel> getAll();

	public ClienteModel insertOrUpdate(ClienteModel personaModel);

	public ClienteModel ListarId(int id);

	public String delete(int id);
	
	Page<ClienteModel> getAllPages(Pageable pageable);
}