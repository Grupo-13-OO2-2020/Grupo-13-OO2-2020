package Grupo13OO2.services;
import java.util.List;


import Grupo13OO2.Entities.SolicitudStock;
import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LocalModel;
public interface ISolicitudStockService {
	
	public List<SolicitudStock> getAll();
	
	public SolicitudStockModel insertOrUpdate(SolicitudStockModel solicitudStock);
	
	public SolicitudStockModel ListarId(int id);
	
	public String delete(int id);

	public List<LocalModel> getLocalesCercanos(int idProducto, int idVendedor, int cantidad);


	// public void aceptarSolcitudStock(SolicitudStockModel solicitudStockModel,EmpleadoModel empleado,LocalModel local);
}
