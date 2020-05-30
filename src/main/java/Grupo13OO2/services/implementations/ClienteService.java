package Grupo13OO2.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Cliente;
import Grupo13OO2.Models.ClienteModel;
import Grupo13OO2.converters.ClienteConverter;
import Grupo13OO2.repositories.IClienteRepository;
import Grupo13OO2.services.IClienteService;

@Service("clienteService")
public class ClienteService implements IClienteService{
    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    @Qualifier("clienteConverter")
    private ClienteConverter clienteConverter;

    @Override
    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    @Override
    public ClienteModel insertOrUpdate(ClienteModel clienteModel){
        Cliente cliente = clienteRepository.save(clienteConverter.modelToEntity(clienteModel));
        return clienteConverter.entityToModel(cliente);
    }
    
    @Override
    public String delete(int id){
        clienteRepository.deleteById(id);
        return "Cliente borrada" + id;
    }

    @Override
	public ClienteModel ListarId(int id) {
        
        Optional<Cliente> cliente = clienteRepository.findById(id);
   
		return clienteConverter.entityToModel(cliente.get());
	}
}