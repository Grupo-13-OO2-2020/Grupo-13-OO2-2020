package Grupo13OO2.converters;

import java.util.Optional;

import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Producto;
import Grupo13OO2.Models.ProductoModel;

@Component("productoConverter")
public class ProductoConverter {

	public ProductoModel entityToModel(Producto producto) {
		return new ProductoModel(producto.getId(),producto.getDescripcion(),producto.getPrecioUnitario(),producto.getCodigoProducto(),producto.getTalle());
	}
	
	public Producto modelToEntity(ProductoModel modelo) {
		return new Producto(modelo.getId(),modelo.getDescripcion(),modelo.getPrecioUnitario(),modelo.getCodigoProducto(),modelo.getTalle());
	}
}
