package Grupo13OO2.converters;
import org.springframework.stereotype.Component;
import Grupo13OO2.Entities.Remito;
import Grupo13OO2.Models.RemitoModel;

@Component("remitoConverter")
public class RemitoConverter {
	
	public RemitoModel entityToModel(Remito remito) {
		return new RemitoModel(remito.getId(), remito.getFecha(),remito.getProducto(),
				remito.getCantidad(),remito.getVendedor(),remito.getCliente(),
				remito.isFacturado(),remito.getFormaDePago());
	}
	
	public Remito modelToEntity(RemitoModel remito) {
		return new Remito(remito.getId(), remito.getFecha(),remito.getProducto(),
				remito.getCantidad(),remito.getVendedor(),remito.getCliente(),
				remito.isFacturado(),remito.getFormaDePago());
	}
	
	

}
