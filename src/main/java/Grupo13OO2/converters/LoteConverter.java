package Grupo13OO2.converters;

import java.util.HashSet;
import java.util.Set;

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

	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	public LoteModel entityToModel(Lote objeto) {
		return new LoteModel(objeto.getId(), objeto.getNumeroDeLote(), objeto.getCantidadRecibida(),
				productoConverter.entityToModel(objeto.getProducto()), objeto.getCantidadExistente(),
				localConverter.entityToModel(objeto.getLocal()));
	}

	public Lote modelToEntity(LoteModel model) {
		return new Lote(model.getId(), model.getNumeroDeLote(), model.getCantidadRecibida(),
				productoConverter.modelToEntity(model.getProducto()), model.getCantidadExistente(),
				localConverter.modelToEntity(model.getLocalModel()));

	}

	public Set<Lote> listModelToListEntity(Set<LoteModel> lotes) {
		Set<Lote> lotelist = new HashSet<Lote>();
		while (!lotes.isEmpty()) {
			for (LoteModel loteModel : lotes) {
				lotelist.add(modelToEntity(loteModel));
			}
		}
		return lotelist;
	}

	public Set<LoteModel> listEntityToModel(Set<Lote> lotes) {
		Set<LoteModel> lotelist = new HashSet<LoteModel>();
		while (!lotes.isEmpty()) {
			for (Lote lote : lotes) {
				lotelist.add(entityToModel(lote));
			}
		}
		return lotelist;
	}

}
