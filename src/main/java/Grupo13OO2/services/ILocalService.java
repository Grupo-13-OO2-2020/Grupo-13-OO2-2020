package Grupo13OO2.services;

import java.util.List;

import Grupo13OO2.Entities.Local;
import Grupo13OO2.Models.*;

public interface ILocalService {
	
	public List<Local> getAll();
	
	public LocalModel insertOrUpdate(LocalModel localModel);
	
	public LocalModel findById(int id);
	
	public String delete(int id);

}
