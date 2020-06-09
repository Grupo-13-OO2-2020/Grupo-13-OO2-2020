package Grupo13OO2.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import Grupo13OO2.Entities.Local;
import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.Models.ProductoModel;
import Grupo13OO2.converters.LocalConverter;
import Grupo13OO2.converters.LoteConverter;
import Grupo13OO2.converters.ProductoConverter;
import Grupo13OO2.repositories.ILocalRepository;
import Grupo13OO2.repositories.ILoteRepository;
import Grupo13OO2.repositories.IProductoRepository;
import Grupo13OO2.services.ILoteService;

@Service("loteService")
public class LoteService implements ILoteService {

	@Autowired
	@Qualifier("loteRepository")
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

	@Autowired
	@Qualifier("localService")
	private LocalService localService;

	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;

	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	@Override
	public List<Lote> getAll() {
		return loteRepository.findAll();
	}

	@Override
	public LoteModel insertOrUpdate(LoteModel loteModel) {

		Local local = localRepository.findById(loteModel.getLocal().getId());
		ProductoModel producto= productoConverter.entityToModel(productoRepository.findById(loteModel.getProducto().getId()));
		LocalModel localModel = localConverter.entityToModel(local);
		loteModel.setLocal(localModel);
		loteModel.setProducto(producto);
		Lote lote = loteRepository.save(loteConverter.modelToEntity(loteModel));

		lote.getLocal().getLotes().add(lote);

		

		localService.insertOrUpdate(localConverter.entityToModel(lote.getLocal()));

		return loteConverter.entityToModel(lote);

	}

	@Override
	public LoteModel ListarId(int id) {
		return loteConverter.entityToModel(loteRepository.findById(id));
	}

	@Override
	public String delete(int id) {
		loteRepository.deleteById(id);
		return "el lote ha sido eliminado";
	}

}
