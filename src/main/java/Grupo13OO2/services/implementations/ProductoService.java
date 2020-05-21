package Grupo13OO2.services.implementations;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Producto;
import Grupo13OO2.Models.ProductoModel;
import Grupo13OO2.converters.ProductoConverter;
import Grupo13OO2.repositories.IProductoRepository;
import Grupo13OO2.services.IProductoService;

@Service("productoService")
public class ProductoService implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired 
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public ProductoModel insertOrUpdate(ProductoModel productoModel) {
		Producto producto= productoRepository.save(productoConverter.modelToEntity(productoModel));
		return productoConverter.entityToModel(producto);
	}


	@Override
	public String delete(int id) {
		productoRepository.deleteById(id);
		return "producto eliminado";
	}

	@Override
	public ProductoModel ListarId(int id) {
		
		Optional<Producto> producto= productoRepository.findById(id);
		
		return productoConverter.entityToModel(producto.get());
	}

	
	
	
}
