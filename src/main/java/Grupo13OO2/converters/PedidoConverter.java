package Grupo13OO2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Pedido;
import Grupo13OO2.Models.PedidoModel;

@Component("pedidoConverter")
public class PedidoConverter {
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;

	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;

	public PedidoModel entityToModel(Pedido pedido) {
		return new PedidoModel(pedido.getId(), pedido.getFecha(), productoConverter.entityToModel(pedido.getProducto()),
				pedido.getCantidad(), empleadoConverter.entityToModel(pedido.getVendedor()),
				clienteConverter.entityToModel(pedido.getCliente()), pedido.isAprobado());

	}

	public Pedido modelToEntity(PedidoModel pedido) {
		return new Pedido(pedido.getId(), pedido.getFecha(), productoConverter.modelToEntity(pedido.getProducto()),
				pedido.getCantidad(), empleadoConverter.modelToEntity(pedido.getVendedor()),
				clienteConverter.modelToEntity(pedido.getCliente()), pedido.isAprobado());
	}

}
