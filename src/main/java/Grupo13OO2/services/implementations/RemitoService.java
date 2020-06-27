package Grupo13OO2.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public List<RemitoModel> getAll() {
		List<Remito> remitos = remitoRepository.findAll();
		List<RemitoModel> remitoModels = new ArrayList<RemitoModel>();
		for(Remito r : remitos) {
			remitoModels.add(remitoConverter.entityToModel(r));
		}
		return remitoModels;
	}

	@Override
	public RemitoModel insertOrUpdate(RemitoModel remitoModel) {
		remitoModel.setVendedor(empleadoService.ListarId(remitoModel.getVendedor().getId()));

		Remito remito = remitoConverter.modelToEntity(remitoModel);
		remitoRepository.save(remito);

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

	@Override
	public Page<RemitoModel> getAllPages(Pageable pageable) {
		Page<Remito> remitos= remitoRepository.findAll(pageable);
		Page<RemitoModel> pages= remitos.map(new Function <Remito, RemitoModel>(){
			public RemitoModel apply(Remito remito) {
				RemitoModel remitoModel= remitoConverter.entityToModel(remito);
				return remitoModel;
			}
		});
		
		return pages;
	}

	@Override
	public Page<RemitoModel> getAllPagesLocal(Pageable pageable, int id) {

		Page<Remito> remitos= remitoRepository.findByLocal(id, pageable);
		Page<RemitoModel> pages= remitos.map(new Function <Remito, RemitoModel>(){
			public RemitoModel apply(Remito remito) {
				RemitoModel remitoModel= remitoConverter.entityToModel(remito);
				return remitoModel;
			}
		});
		
		return pages;
	}

	@Override
	public List<RemitoModel> listAll(String keyword) {
		List<RemitoModel> models= new ArrayList<RemitoModel>();
		List<Remito> remitos=	remitoRepository.findAll(keyword);
		for(Remito r: remitos) {
			models.add(remitoConverter.entityToModel(r));
			
		}
		
		return models;
	}

}
