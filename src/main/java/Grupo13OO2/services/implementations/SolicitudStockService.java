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
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LocalModel;

@Service("solicitudStockService")
public class SolicitudStockService implements ISolicitudStockService {
	
	@Autowired
    private ISolicitudStockRepository solicitudStockRepository;

    @Autowired
    @Qualifier("solicitudStockConverter")
	private SolicitudStockConverter solicitudStockConverter;
	
	@Autowired
	@Qualifier("empleadoService")
	private EmpleadoService empleadoService; 

	@Autowired
	@Qualifier("localService")
	private LocalService localService; 

	@Override
	public List<SolicitudStock> getAll() {
		
		return solicitudStockRepository.findAll();
	}

	@Override
	public SolicitudStockModel insertOrUpdate(SolicitudStockModel solicitudStockModel) {
		solicitudStockModel.setVendedor(empleadoService.ListarId(solicitudStockModel.getVendedor().getId()));
		solicitudStockModel.setLocalDestinatario(localService.findById(solicitudStockModel.getLocalDestinatario().getId()));
		solicitudStockModel.setColaborador(empleadoService.ListarId(solicitudStockModel.getVendedor().getId()));

		SolicitudStock solicitudStock=solicitudStockRepository.save(solicitudStockConverter.modelToEntity(solicitudStockModel));
		
		return solicitudStockConverter.entityToModel(solicitudStock);
	}

	@Override
	public SolicitudStockModel ListarId(int id) {
		return solicitudStockConverter.entityToModel(solicitudStockRepository.findById(id));
	}

	@Override
	public String delete(int id) {
		solicitudStockRepository.deleteById(id);
		return "solictud cancelada"+ id;
	}

	// @Override
	// public void aceptarSolcitudStock(SolicitudStockModel solicitudStockModel,EmpleadoModel empleado,LocalModel local) {
	// 	solicitudStockModel.setColaborador(local.getEmpleado());
	// 	solicitudStockModel.setAceptado(true);
	// //	destinatario.consumoLote(solicitud.getProducto(), solicitud.getCantidad());
	// }

}
