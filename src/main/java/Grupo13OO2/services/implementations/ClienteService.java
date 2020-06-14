package Grupo13OO2.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page; 

import Grupo13OO2.Entities.Cliente;
import Grupo13OO2.Models.ClienteModel;
import Grupo13OO2.converters.ClienteConverter;
import Grupo13OO2.repositories.IClienteRepository;
import Grupo13OO2.services.IClienteService;

@Service("clienteService")
public class ClienteService implements IClienteService {
	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;

	@Override
	public List<ClienteModel> getAll() {
		List<Cliente> clientes= clienteRepository.findAll();
		List<ClienteModel> clienteModels= new ArrayList<ClienteModel>();
		for (Cliente cM : clientes) {
			clienteModels.add(clienteConverter.entityToModel(cM));
		}
		
		 return clienteModels;
	}
	
	

	@Override
	public ClienteModel insertOrUpdate(ClienteModel clienteModel) {
		Cliente cliente = clienteRepository.save(clienteConverter.modelToEntity(clienteModel));
		return clienteConverter.entityToModel(cliente);
	}

	@Override
	public String delete(int id) {
		clienteRepository.deleteById(id);
		return "Cliente borrada" + id;
	}

	@Override
	public ClienteModel ListarId(int id) {

		return clienteConverter.entityToModel(clienteRepository.findById(id));
	}



	@Override
	public Page<ClienteModel> getAllPages(Pageable pageable) {
		Page<Cliente> clientes= clienteRepository.findAll(pageable);
		Page<ClienteModel> pages = clientes.map(new Function<Cliente, ClienteModel>(){
		   
			public ClienteModel apply(Cliente cliente) {
		        ClienteModel model =  clienteConverter.entityToModel(cliente);
		        return model;
		        }
		});
		
		return pages;
	}
}