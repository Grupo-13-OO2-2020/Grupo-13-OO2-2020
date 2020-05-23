package Grupo13OO2.converters;
import org.springframework.stereotype.Component;


import Grupo13OO2.Entities.SolicitudStock;
import Grupo13OO2.Models.SolicitudStockModel;

@Component("solicitudStockConverter")
public class SolicitudStockConverter {
	
	public SolicitudStockModel entityToModel(SolicitudStock solicitudStock) {
		return new SolicitudStockModel(solicitudStock.getId(), solicitudStock.getFecha(),solicitudStock.getProducto(),
				solicitudStock.getCantidad(),solicitudStock.getVendedor(),solicitudStock.getCliente(),
				solicitudStock.isFacturado(),solicitudStock.getColaborador(),solicitudStock.isAceptado(),
				solicitudStock.getLocalDetinatario());
		
	}
	
	public SolicitudStock modelToEntity(SolicitudStockModel solicitudStock) {
		return new SolicitudStock(solicitudStock.getId(), solicitudStock.getFecha(),solicitudStock.getProducto(),
				solicitudStock.getCantidad(),solicitudStock.getVendedor(),solicitudStock.getCliente(),
				solicitudStock.isFacturado(),solicitudStock.getColaborador(),solicitudStock.isAceptado(),
				solicitudStock.getLocalDetinatario());
	}
	

}
