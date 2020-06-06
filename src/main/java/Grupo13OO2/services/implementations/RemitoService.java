package Grupo13OO2.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import Grupo13OO2.Entities.Remito;
import Grupo13OO2.Models.RemitoModel;
import Grupo13OO2.converters.RemitoConverter;
import Grupo13OO2.repositories.IRemitoRepository;
import Grupo13OO2.services.IRemitoService;

@Service("remitoService")

public class RemitoService implements IRemitoService {

	@Autowired
	private IRemitoRepository remitoRepository;

	@Autowired
	@Qualifier("remitoConverter")
	private RemitoConverter remitoConverter;

	@Autowired
	@Qualifier("empleadoService")
	private EmpleadoService empleadoService;

	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;

	@Override
	public List<Remito> getAll() {
		return remitoRepository.findAll();
	}

	@Override
	public RemitoModel insertOrUpdate(RemitoModel remitoModel) {
		remitoModel.setVendedor(empleadoService.ListarId(remitoModel.getVendedor().getId()));

		Remito remito = remitoRepository.save(remitoConverter.modelToEntity(remitoModel));

		return remitoConverter.entityToModel(remito);
	}

	@Override
	public RemitoModel ListarId(int id) {
		Optional<Remito> remito = remitoRepository.findById(id);
		return remitoConverter.entityToModel(remito.get());
	}

	@Override
	public String delete(int id) {
		remitoRepository.deleteById(id);
		return "solictud cancelada" + id;
	}

}
