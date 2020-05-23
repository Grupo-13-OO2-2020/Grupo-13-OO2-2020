package Grupo13OO2.converters;
import org.springframework.stereotype.Component;


import Grupo13OO2.Entities.Pedido;
import Grupo13OO2.Models.PedidoModel;

@Component("pedidoConverter")
public class PedidoConverter {
	
	public PedidoModel entityToModel(Pedido pedido) {
		return new PedidoModel(pedido.getId(),pedido.getFecha(),pedido.getProducto(),pedido.getCantidad(),
				pedido.getVendedor(),pedido.getCliente(),pedido.isFacturado());
		
	}
	
	public Pedido modelToEntity(PedidoModel pedido) {
		return new Pedido(pedido.getId(),pedido.getFecha(),pedido.getProducto(),pedido.getCantidad(),
				pedido.getVendedor(),pedido.getCliente(),pedido.isFacturado());
	}
	
	

}
