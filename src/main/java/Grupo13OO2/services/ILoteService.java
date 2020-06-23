package Grupo13OO2.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Models.LoteModel;

public interface ILoteService {

	public List<Lote> getAll();

	public LoteModel insertOrUpdate(LoteModel loteModel);

	public LoteModel ListarId(int id);

	public String delete(int id);
	
	Page<LoteModel> getAllPages(Pageable pageable);


}
