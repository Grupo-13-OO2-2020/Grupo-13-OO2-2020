package Grupo13OO2.services.implementations;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.SolicitudStock;
import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.converters.SolicitudStockConverter;
import Grupo13OO2.repositories.ISolicitudStockRepository;
import Grupo13OO2.services.ISolicitudStockService;

@Service("solicitudStockService")
public class SolicitudStockService implements ISolicitudStockService {
	
	@Autowired
    private ISolicitudStockRepository solicitudStockRepository;

    @Autowired
    @Qualifier("solicitudStockConverter")
    private SolicitudStockConverter solicitudStockConverter;

	@Override
	public List<SolicitudStock> getAll() {
		
		return solicitudStockRepository.findAll();
	}

	@Override
	public SolicitudStockModel insertOrUpdate(SolicitudStockModel solicitudStockModel) {
		SolicitudStock solicitudStock=solicitudStockRepository.save(solicitudStockConverter.modelToEntity(solicitudStockModel));
		return solicitudStockConverter.entityToModel(solicitudStock);
	}

	@Override
	public SolicitudStockModel ListarId(int id) {
		Optional<SolicitudStock> solicitudStock=solicitudStockRepository.findById(id);
		return solicitudStockConverter.entityToModel(solicitudStock.get());
	}

	@Override
	public String delete(int id) {
		solicitudStockRepository.deleteById(id);
		return "solictud cancelada"+ id;
	}

}
