package Grupo13OO2.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Local;
import Grupo13OO2.Models.LocalModel;

@Component("localConverter")
public class LocalConverter {
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;
	
	public LocalModel entityToModel(Local local) {
		return new LocalModel(local.getId(),local.getDireccion(),local.getLatitud(),local.getLongitud(),local.getCodigo(),
				local.getNumeroTelefono(), local.getEmpleado(), local.getEmpleados(),loteConverter.listEntityToModel(local.getLotes()));
		
	}
	
	public Local modelToEntity(LocalModel local) {
		return new Local(local.getId(),local.getDireccion(),local.getLatitud(),local.getLongitud(),local.getCodigo(),
				local.getNumeroTelefono(), local.getEmpleado(), local.getEmpleados(),loteConverter.listModelToListEntity(local.getLotesModels()));
	}
	
	

}
