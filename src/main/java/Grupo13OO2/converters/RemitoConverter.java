package Grupo13OO2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import Grupo13OO2.Entities.Remito;
import Grupo13OO2.Models.RemitoModel;

@Component("remitoConverter")
public class RemitoConverter {
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;

	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;

	public RemitoModel entityToModel(Remito remito) {
		return new RemitoModel(remito.getId(), remito.getFecha(), productoConverter.entityToModel(remito.getProducto()),
				remito.getCantidad(), empleadoConverter.entityToModel(remito.getVendedor()),
				clienteConverter.entityToModel(remito.getCliente()),  remito.getFormaDePago());
	}

	public Remito modelToEntity(RemitoModel remito) {
		return new Remito(remito.getId(), remito.getFecha(), productoConverter.modelToEntity(remito.getProducto()),
				remito.getCantidad(), empleadoConverter.modelToEntity(remito.getVendedor()),
				clienteConverter.modelToEntity(remito.getCliente()), remito.getFormaDePago());
	}

}
