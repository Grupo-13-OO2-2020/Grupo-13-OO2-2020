package Grupo13OO2.converters;


import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Local;
import Grupo13OO2.Models.LocalModel;

@Component("localConverter")
public class LocalConverter {
	
	public LocalModel entityToModel(Local local) {
		return new LocalModel(local.getId(),local.getDireccion(),local.getLatitud(),local.getLongitud(),local.getCodigo(),
				local.getNumeroTelefono());
		
	}
	
	public Local modelToEntity(LocalModel local) {
		return new Local(local.getId(),local.getDireccion(),local.getLatitud(),local.getLongitud(),local.getCodigo(),
				local.getNumeroTelefono());
	}
	
	

}
