package Grupo13OO2.services;
import java.util.List;


import Grupo13OO2.Entities.SolicitudStock;
import Grupo13OO2.Models.SolicitudStockModel;
public interface ISolicitudStockService {
	
	public List<SolicitudStock> getAll();
	
	public SolicitudStockModel insertOrUpdate(SolicitudStockModel solicitudStock);
	
	public SolicitudStockModel ListarId(int id);
	
	public String delete(int id);

	public void aceptarSolcitudStock(SolicitudStockModel solicitudStockModel,EmpleadoModel empleado,LocalModel local);
}
