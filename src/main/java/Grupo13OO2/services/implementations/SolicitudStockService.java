package Grupo13OO2.services.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import Grupo13OO2.Entities.SolicitudStock;
import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.converters.LocalConverter;
import Grupo13OO2.converters.SolicitudStockConverter;
import Grupo13OO2.repositories.ISolicitudStockRepository;
import Grupo13OO2.services.ISolicitudStockService;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.ProductoModel;

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

	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;

	@Override
	public List<SolicitudStockModel> getAll() {

		List<SolicitudStock> solicitudes = solicitudStockRepository.findAll();
		List<SolicitudStockModel> solicitudModels = new ArrayList<SolicitudStockModel>();
		for (SolicitudStock sS : solicitudes) {
			solicitudModels.add(solicitudStockConverter.entityToModel(sS));
		}
		return solicitudModels;

	}

	@Override
	public SolicitudStockModel insertOrUpdate(SolicitudStockModel solicitudStockModel) {
		solicitudStockModel.setVendedor(empleadoService.ListarId(solicitudStockModel.getVendedor().getId()));
		solicitudStockModel
				.setLocalDestinatario(localService.findById(solicitudStockModel.getLocalDestinatario().getId()));

		if (solicitudStockModel.getColaborador() != null) {
			solicitudStockModel.setColaborador(empleadoService.ListarId(solicitudStockModel.getColaborador().getId()));
		}
		SolicitudStock solicitudStock = solicitudStockRepository
				.save(solicitudStockConverter.modelToEntity(solicitudStockModel));
		return solicitudStockConverter.entityToModel(solicitudStock);
	}

	@Override
	public SolicitudStockModel ListarId(int id) {
		return solicitudStockConverter.entityToModel(solicitudStockRepository.findById(id));
	}

	@Override
	public String delete(int id) {
		solicitudStockRepository.deleteById(id);
		return "solictud cancelada" + id;
	}

	@Override
	public List<LocalModel> getLocalesCercanos(int idProducto, int idVendedor, int cantidad) {
		List<LocalModel> localesStock = new ArrayList<LocalModel>();
		ProductoModel producto = productoService.ListarId(idProducto);
		EmpleadoModel vendedor = empleadoService.ListarId(idVendedor);
		LocalModel local = vendedor.getLocal();
		for (LocalModel l : localService.getAll()) {
			if(!(l.getId() == local.getId())){
				if (localService.validarStockLocal(producto.getCodigoProducto(), cantidad, l.getId())) {
				localesStock.add(l);
				}
			}
			
		}
		Collections.sort(localesStock, new Comparator<LocalModel>() {
			@Override
			public int compare(LocalModel o1, LocalModel o2) {
				return Double.compare(o1.getDistanciaCoord(local, o1), o2.getDistanciaCoord(local, o2));
			}
		});

		return localesStock;
	}

	@Override
	public Page<SolicitudStockModel> getAllPages(Pageable pageable) {
		Page<SolicitudStock> solicitudes = solicitudStockRepository.findAll(pageable);
		Page<SolicitudStockModel> pages = solicitudes.map(new Function<SolicitudStock, SolicitudStockModel>() {
			public SolicitudStockModel apply(SolicitudStock solicitud) {
				SolicitudStockModel sSModel = solicitudStockConverter.entityToModel(solicitud);

				return sSModel;
			}
		});

		return pages;
	}

	@Override
	public Page<SolicitudStockModel> getAllPagesLocal(Pageable pageable, int id) {

		Page<SolicitudStock> solicitudes = solicitudStockRepository.findByLocal(id, pageable);
		Page<SolicitudStockModel> pages = solicitudes.map(new Function<SolicitudStock, SolicitudStockModel>() {
			public SolicitudStockModel apply(SolicitudStock solicitud) {
				SolicitudStockModel sSModel = solicitudStockConverter.entityToModel(solicitud);

				return sSModel;
			}
		});

		return pages;
	}
}
