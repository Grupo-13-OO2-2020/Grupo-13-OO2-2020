package Grupo13OO2.converters;

import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Producto;
import Grupo13OO2.Models.ProductoModel;

@Component("productoConverter")
public class ProductoConverter {

	public ProductoModel entityToModel(Producto objeto) {
		return new ProductoModel(objeto.getId(),objeto.getDescripcion(),objeto.getPrecioUnitario(),objeto.getCodigoProducto(),objeto.getTalle());
	}
	
	public Producto modelToEntity(ProductoModel modelo) {
		return new Producto(modelo.getId(),modelo.getDescripcion(),modelo.getPrecioUnitario(),modelo.getCodigoProducto(),modelo.getTalle());
	}
}
