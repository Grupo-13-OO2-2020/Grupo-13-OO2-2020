package Grupo13OO2.services.implementations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Local;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.Models.ProductoModel;
import Grupo13OO2.Models.RemitoModel;
import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.converters.LocalConverter;
import Grupo13OO2.converters.LoteConverter;
import Grupo13OO2.converters.RemitoConverter;
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
	@Qualifier("productoService")
	private ProductoService productoService;

	@Autowired
	@Qualifier("empleadoService")
	private EmpleadoService empleadoService;

	@Autowired
	@Qualifier("remitoService")
	private RemitoService remitoService;

	@Autowired
	@Qualifier("remitoConverter")
	private RemitoConverter remitoConverter;

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
	public List<LocalModel> getAll() {
		List<Local> locales = localRepository.findAll();
		List<LocalModel> localModels = new ArrayList<LocalModel>();
		for (Local l : locales) {
			localModels.add(localConverter.entityToModel(l));
		}
		return localModels;
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

		for (SolicitudStockModel solicitudStock : solicitudStockService.getAll()) {
			if (solicitudStock.getLocalDestinatario().getId() == localModel.getId()) {
				solicitudesM.add(solicitudStock);
			}
		}

		return solicitudesM;
	}

	@Override
	public List<RemitoModel> getRemitos(LocalModel localModel) {
		List<RemitoModel> remitosM = new ArrayList<RemitoModel>();

		for (RemitoModel remito : remitoService.getAll()) {
			if (remito.getVendedor().getLocal().getId() == localModel.getId()) {
				remitosM.add(remito);
			}
		}

		return remitosM;
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

	@Override
	public boolean consumirLoteSolicitud(SolicitudStockModel solicitudStockModel) {
		LocalModel local = this.findById(solicitudStockModel.getLocalDestinatario().getId());
		boolean consumo = false;
		int aux = solicitudStockModel.getCantidad();
		Set<LoteModel> auxlotes = local.getLotes();
		List<LoteModel> auxList = new ArrayList<LoteModel>(auxlotes);
		auxList.sort(Comparator.comparing(LoteModel::getId));

		int i = 0;

		while (i < auxList.size()  && aux>0) {

			if (auxList.get(i).getProducto().getCodigoProducto() == solicitudStockModel.getProducto()
					.getCodigoProducto() && auxList.get(i).getCantidadExistente() > 0) {

				if (auxList.get(i).getCantidadExistente() - aux > 0) {
					auxList.get(i).setCantidadExistente(auxList.get(i).getCantidadExistente() - aux);
					aux = 0;
					auxList.get(i).setLocal(solicitudStockModel.getVendedor().getLocal());
					loteService.insertOrUpdate(auxList.get(i));

				} else if (auxList.get(i).getCantidadExistente() - aux <= 0) {
					aux = aux - auxList.get(i).getCantidadExistente();
					auxList.get(i).setCantidadExistente(0);
					auxList.get(i).setLocal(solicitudStockModel.getVendedor().getLocal());
					loteService.insertOrUpdate(auxList.get(i));
				}

			}
			i++;
		}
		consumo = true;
		return consumo;
	}

	@Override
	public boolean consumirLote(RemitoModel remito) {
		LocalModel local = this.findById(remito.getVendedor().getLocal().getId());
		boolean consumo = false;
		int aux = remito.getCantidad();
		Set<LoteModel> auxlotes = local.getLotes();
		List<LoteModel> auxList = new ArrayList<LoteModel>(auxlotes);

		auxList.sort(Comparator.comparing(LoteModel::getId));
		int i = 0;
		while (i < auxList.size()  && aux>0) {

			if (auxList.get(i).getProducto().getCodigoProducto() == remito.getProducto().getCodigoProducto()
					&& auxList.get(i).getCantidadExistente() > 0) {

				if (auxList.get(i).getCantidadExistente() - aux > 0) {
					auxList.get(i).setCantidadExistente(auxList.get(i).getCantidadExistente() - aux);
					aux = 0;
					auxList.get(i).setLocal(remito.getVendedor().getLocal());
					loteService.insertOrUpdate(auxList.get(i));

				} else if (auxList.get(i).getCantidadExistente() - aux <= 0) {
					aux = aux - auxList.get(i).getCantidadExistente();
					auxList.get(i).setCantidadExistente(0);
					auxList.get(i).setLocal(remito.getVendedor().getLocal());
					loteService.insertOrUpdate(auxList.get(i));
				}

			}
			i++;
		}
		consumo = true;
		return consumo;
	}

	

	@Override
	public Page<LocalModel> getAllPages(Pageable pageable) {
		Page<Local> locales = localRepository.findAll(pageable);
		Page<LocalModel> pages = locales.map(new Function<Local, LocalModel>() {
			public LocalModel apply(Local local) {
				LocalModel localModel = localConverter.entityToModel(local);
				return localModel;
			}

		});

		return pages;
	}

	@Override
	public List<EmpleadoModel> calculoSueldos(int id) {
		List<EmpleadoModel> empleados = new ArrayList<EmpleadoModel>();
		empleados.addAll(findById(id).getEmpleados());

		for (EmpleadoModel e : empleados) {
			e.setSueldoNuevo(empleadoService.sueldoxEmpleado(e));
		}
		return empleados;
	}

	@Override
	public Set<ProductoModel> productosVendidosEntreFechas(LocalModel local, Date comienzo, Date fin) {

		List<RemitoModel> remitos = getRemitos(local);
		List<SolicitudStockModel> solicitudes = getSolicitudesStock(local);

		Set<ProductoModel> productoList = new HashSet<ProductoModel>();

		for (RemitoModel r : remitos) {
			if (r.getFecha().before(fin) && r.getFecha().after(comienzo)) {
				productoList.add(r.getProducto());
			}
		}

		for (SolicitudStockModel s : solicitudes) {
			if (s.getFecha().before(fin) && s.getFecha().after(comienzo) && (s.isAceptado() == true)) {
				productoList.add(s.getProducto());

			}
		}

		return productoList;

	}
}
