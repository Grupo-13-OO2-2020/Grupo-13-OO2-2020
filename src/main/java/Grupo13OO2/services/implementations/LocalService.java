package Grupo13OO2.services.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Local;
import Grupo13OO2.Entities.SolicitudStock;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.Models.RemitoModel;
import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.converters.LocalConverter;
import Grupo13OO2.converters.LoteConverter;
import Grupo13OO2.converters.SolicitudStockConverter;
import Grupo13OO2.repositories.ILocalRepository;
import Grupo13OO2.services.ILocalService;
import Grupo13OO2.services.ILoteService;

@Service("localService")
public class LocalService implements ILocalService {

	@Autowired
	private ILocalRepository localRepository;

	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;

	@Autowired
	@Qualifier("solicitudStockService")
	private SolicitudStockService solicitudStockService;

	@Autowired
	@Qualifier("solicitudStockConverter")
	private SolicitudStockConverter solicitudStockConverter;

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;

	@Override
	public List<Local> getAll() {
		return localRepository.findAll();
	}

	@Override
	public LocalModel insertOrUpdate(LocalModel localModel) {

		Local local = localRepository.save(localConverter.modelToEntity(localModel));
		return localConverter.entityToModel(local);
	}

	@Override
	public LocalModel findById(int id) {

		return localConverter.entityToModel(localRepository.findById(id));
	}

	@Override
	public String delete(int id) {
		localRepository.deleteById(id);
		return "Local borrada" + id;
	}

	@Override
	public List<SolicitudStockModel> getSolicitudesStock(LocalModel localModel) {
		List<SolicitudStockModel> solicitudesM = new ArrayList<SolicitudStockModel>();

		for (SolicitudStock solicitudStock : solicitudStockService.getAll()) {
			if (solicitudStock.getLocalDestinatario().getId() == localModel.getId()) {
				solicitudesM.add(solicitudStockConverter.entityToModel(solicitudStock));
			}
		}

		return solicitudesM;
	}

	@Override
	public boolean validarStockLocal(int codigoProducto, int cantidad, int idLocal) {
		LocalModel local = this.findById(idLocal);
		boolean valido = false;
		Set<LoteModel> lotes = local.getLotes();
		Iterator<LoteModel> it = lotes.iterator();
		int aux = cantidad;
		while (it.hasNext() == true && aux > 0) {
			LoteModel l = it.next();
			if (l.getProducto().getCodigoProducto() == codigoProducto) {
				aux = aux - l.getCantidadExistente();
			}
		}


		if (aux <= 0) {
			valido = true;
		}

		return valido;
	}

	public boolean consumirLote(RemitoModel remito) {
		LocalModel local = this.findById(remito.getVendedor().getLocal().getId());
		boolean consumo = false;
		int aux = remito.getCantidad();
		Set<LoteModel> lotes = local.getLotes();
		Iterator<LoteModel> it = lotes.iterator();
		while (aux > 0) {
			LoteModel l = it.next();

			if (l.getProducto().getCodigoProducto() == remito.getProducto().getCodigoProducto()) {

				if (l.getCantidadExistente() - aux >= 0) {
					l.setCantidadExistente(l.getCantidadExistente() - aux);
					aux = 0;
					l.setLocal(remito.getVendedor().getLocal());
					loteService.insertOrUpdate(l);

				} else {
					aux = aux - l.getCantidadExistente();
					l.setCantidadExistente(0);
					l.setLocal(remito.getVendedor().getLocal());
					loteService.insertOrUpdate(l);
				}

			}
		}
		consumo = true;
		return consumo;
	}

}
