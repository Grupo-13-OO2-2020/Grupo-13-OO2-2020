package Grupo13OO2.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Entities.Producto;
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.Models.ProductoModel;
import Grupo13OO2.converters.LoteConverter;
import Grupo13OO2.converters.ProductoConverter;
import Grupo13OO2.repositories.ILoteRepository;
import Grupo13OO2.repositories.IProductoRepository;
import Grupo13OO2.services.ILoteService;

@Service("loteService")
public class LoteService implements ILoteService {

	@Autowired
	private ILoteRepository loteRepository;
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;
	
	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Override
	public List<Lote> getAll() {
		// TODO Auto-generated method stub
		return loteRepository.findAll();
	}

	@Override
	public LoteModel insertOrUpdate(LoteModel loteModel) {
		Producto producto = productoRepository.findById(loteModel.getProducto().getId());

		ProductoModel productoModel = productoConverter.entityToModel(producto);

		loteModel.setProducto(productoModel);
		
		Lote lote = loteRepository.save(loteConverter.modelToEntity(loteModel));

		return loteConverter.entityToModel(lote);

	}

	@Override
	public LoteModel ListarId(int id) {
		Optional<Lote> lote= loteRepository.findById(id);
		
		return loteConverter.entityToModel(lote.get());
	}

	@Override
	public String delete(int id) {
		loteRepository.deleteById(id);
		return "el lote ha sido eliminado";
	}

}
