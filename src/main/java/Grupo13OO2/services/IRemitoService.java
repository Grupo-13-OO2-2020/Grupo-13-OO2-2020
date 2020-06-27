package Grupo13OO2.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Grupo13OO2.Models.RemitoModel;

public interface IRemitoService {

	public List<RemitoModel> getAll();

	public RemitoModel insertOrUpdate(RemitoModel remito);

	public RemitoModel ListarId(int id);

	public String delete(int id);
	
	Page<RemitoModel> getAllPages(Pageable pageable);
	
	public List<RemitoModel> listAll(String keyword);

	Page<RemitoModel> getAllPages(int id, Pageable pageable);

}
