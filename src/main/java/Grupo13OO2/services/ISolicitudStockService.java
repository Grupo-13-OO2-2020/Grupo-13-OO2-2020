package Grupo13OO2.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.Models.LocalModel;

public interface ISolicitudStockService {

	public List<SolicitudStockModel> getAll();

	public SolicitudStockModel insertOrUpdate(SolicitudStockModel solicitudStock);

	public SolicitudStockModel ListarId(int id);

	public String delete(int id);

	public List<LocalModel> getLocalesCercanos(int idProducto, int idVendedor, int cantidad);

	public Page<SolicitudStockModel> getAllPages(Pageable pageable);

	public Page<SolicitudStockModel> getAllPagesLocal(Pageable pageable, int id);
}
