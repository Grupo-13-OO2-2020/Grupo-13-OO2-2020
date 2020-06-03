package Grupo13OO2.services;

import java.util.List;

import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.Models.RemitoModel;
import Grupo13OO2.Models.ProductoModel;

public interface ILoteService {

	public List <Lote> getAll();
	
	public LoteModel insertOrUpdate(LoteModel loteModel);
	
	public LoteModel ListarId(int id);
	
	public String delete(int id);
	

	
}
