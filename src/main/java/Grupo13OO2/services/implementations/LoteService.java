package Grupo13OO2.services.implementations;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import Grupo13OO2.Entities.Local;
import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Entities.Remito;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.Models.ProductoModel;
import Grupo13OO2.Models.RemitoModel;
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
		if(loteModel.getId()<1) {
			loteModel.setCantidadExistente(loteModel.getCantidadRecibida());
		}
		
		
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

	@Override
	public Page<LoteModel> getAllPages(Pageable pageable) {
	
		
		Page<Lote> lotes= loteRepository.findAll(pageable);
		Page<LoteModel> pages= lotes.map(new Function <Lote, LoteModel>(){
			public LoteModel apply(Lote lote) {
				LoteModel remitoModel= loteConverter.entityToModel(lote);
				return remitoModel;
			}
		});
		
		return pages;
	}
	
	public boolean findDependency(int id){
		LoteModel l = ListarId(id);
		if((l.getCantidadExistente() == l.getCantidadRecibida()) || (l.getCantidadExistente() == 0)){
			return true;
		} 

		return false;
	}
}
