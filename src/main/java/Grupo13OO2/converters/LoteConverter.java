package Grupo13OO2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.converters.ProductoConverter;

@Component("loteConverter")
public class LoteConverter {
	@Autowired 
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	public LoteModel entityToModel(Lote objeto){
	return new LoteModel (objeto.getId(),objeto.getNumeroDeLote(),objeto.getCantidadRecibida(),productoConverter.entityToModel(objeto.getProducto()),objeto.getCantidadExistente());
	}
	
	public Lote modelToEntity(LoteModel model) {
		return new Lote(model.getId(),model.getNumeroDeLote(),model.getCantidadRecibida(), productoConverter.modelToEntity(model.getProducto()),model.getCantidadExistente());
	
	}
	

}
