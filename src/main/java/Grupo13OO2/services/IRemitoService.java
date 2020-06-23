package Grupo13OO2.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Grupo13OO2.Entities.Pedido;
import Grupo13OO2.Entities.Remito;
import Grupo13OO2.Models.RemitoModel;

public interface IRemitoService {

	public List<RemitoModel> getAll();

	public RemitoModel insertOrUpdate(RemitoModel remito);

	public RemitoModel ListarId(int id);

	public String delete(int id);
	
	public Page<RemitoModel> getAllPages(Pageable pageable);

	public List<Remito> listAll(String keyword);

}
