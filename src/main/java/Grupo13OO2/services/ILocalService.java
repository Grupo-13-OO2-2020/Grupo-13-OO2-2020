package Grupo13OO2.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import Grupo13OO2.Entities.Local;
import Grupo13OO2.Models.*;

public interface ILocalService {

	public List<LocalModel> getAll();

	public LocalModel insertOrUpdate(LocalModel localModel);

	public LocalModel findById(int id);

	public String delete(int id);

	public List<SolicitudStockModel> getSolicitudesStock(LocalModel localModel);

	public List<RemitoModel> getRemitos(LocalModel localModel);

	public boolean validarStockLocal(int codigoProducto, int cantidad, int idLocal);

	public boolean consumirLoteSolicitud(SolicitudStockModel solicitudStockModelo);

	public boolean consumirLote(RemitoModel remito);
	
	//public List<EmpleadoModel> calcularSueldos(int id);

	public List<EmpleadoModel> calculoSueldos(int id);

	public Set<ProductoModel> productosVendidosEntreFechas(LocalModel local, Date comienzo, Date fin);
	
	Page<LocalModel> getAllPages(Pageable pageable);

	public List<Local> listAll(String keyword);
}
