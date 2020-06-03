package Grupo13OO2.services;

import java.util.List;

import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Models.LoteModel;

public interface ILoteService {

	public List<Lote> getAll();

	public LoteModel insertOrUpdate(LoteModel loteModel);

	public LoteModel ListarId(int id);

	public String delete(int id);
<<<<<<< HEAD
=======
	
	
	public boolean validarStockInterno(int codigoProducto, int cantidad);
	
	//public boolean consumirLote(RemitoModel remito);
>>>>>>> 25e12ba... pequeños cambios de vistas distancias y otros

}
