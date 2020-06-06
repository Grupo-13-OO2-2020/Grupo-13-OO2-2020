package Grupo13OO2.services;

import java.util.List;

import Grupo13OO2.Entities.Remito;
import Grupo13OO2.Models.RemitoModel;

public interface IRemitoService {

	public List<Remito> getAll();

	public RemitoModel insertOrUpdate(RemitoModel remito);

	public RemitoModel ListarId(int id);

	public String delete(int id);

}
