package Grupo13OO2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.SolicitudStock;
import Grupo13OO2.Models.SolicitudStockModel;

@Component("solicitudStockConverter")
public class SolicitudStockConverter {
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;

	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	public SolicitudStockModel entityToModel(SolicitudStock solicitudStock) {
		SolicitudStockModel sM;
		if (solicitudStock.getColaborador() != null) {
			sM = new SolicitudStockModel(solicitudStock.getId(), solicitudStock.getFecha(),
					productoConverter.entityToModel(solicitudStock.getProducto()), solicitudStock.getCantidad(),
					empleadoConverter.entityToModel(solicitudStock.getVendedor()),
					clienteConverter.entityToModel(solicitudStock.getCliente()),
					empleadoConverter.entityToModel(solicitudStock.getColaborador()), solicitudStock.isAceptado(),
					localConverter.entityToModel(solicitudStock.getLocalDestinatario()));
		} else {
			sM = new SolicitudStockModel(solicitudStock.getId(), solicitudStock.getFecha(),
					productoConverter.entityToModel(solicitudStock.getProducto()), solicitudStock.getCantidad(),
					empleadoConverter.entityToModel(solicitudStock.getVendedor()),
					clienteConverter.entityToModel(solicitudStock.getCliente()), null, false,
					localConverter.entityToModel(solicitudStock.getLocalDestinatario()));
		}
		return sM;
	}

	public SolicitudStock modelToEntity(SolicitudStockModel solicitudStock) {
		SolicitudStock s;
		if (solicitudStock.getColaborador() != null) {
			s = new SolicitudStock(solicitudStock.getId(), solicitudStock.getFecha(),
					productoConverter.modelToEntity(solicitudStock.getProducto()), solicitudStock.getCantidad(),
					empleadoConverter.modelToEntity(solicitudStock.getVendedor()),
					clienteConverter.modelToEntity(solicitudStock.getCliente()),
					empleadoConverter.modelToEntity(solicitudStock.getColaborador()), solicitudStock.isAceptado(),
					localConverter.modelToEntity(solicitudStock.getLocalDestinatario()));
		} else {
			s = new SolicitudStock(solicitudStock.getId(), solicitudStock.getFecha(),
					productoConverter.modelToEntity(solicitudStock.getProducto()), solicitudStock.getCantidad(),
					empleadoConverter.modelToEntity(solicitudStock.getVendedor()),
					clienteConverter.modelToEntity(solicitudStock.getCliente()), null, false,
					localConverter.modelToEntity(solicitudStock.getLocalDestinatario()));
		}

		return s;
	}

}
