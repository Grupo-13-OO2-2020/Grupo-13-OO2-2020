package Grupo13OO2.services;

import java.util.List;

import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Models.LoteModel;

public interface ILoteService {

	public List <Lote> getAll();
	
	public LoteModel insertOrUpdate(LoteModel productoModel);
	
	public LoteModel ListarId(int id);
	
	public String delete(int id);

	
}
