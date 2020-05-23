package Grupo13OO2.services.implementations;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Pedido;
import Grupo13OO2.Models.PedidoModel;
import Grupo13OO2.converters.PedidoConverter;
import Grupo13OO2.repositories.IPedidoRepository;
import Grupo13OO2.services.IPedidoService;


@Service("pedidoService")
public class PedidoService implements IPedidoService {
	
	@Autowired
    private IPedidoRepository pedidoRepository;

    @Autowired
    @Qualifier("pedidoConverter")
    private PedidoConverter pedidoConverter;

    @Override
    public List<Pedido> getAll(){
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoModel insertOrUpdate(PedidoModel pedidoModel){
        Pedido pedido = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
        return pedidoConverter.entityToModel(pedido);
    }
    
    @Override
    public String delete(int id){
    	pedidoRepository.deleteById(id);
        return "pedido borrada" + id;
    }

    @Override
	public PedidoModel ListarId(int id) {
        
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        

		return pedidoConverter.entityToModel(pedido.get());
	}

	
	
	

}
