package Grupo13OO2.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Entities.Local;
import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.LoteModel;

@Component("localConverter")
public class LocalConverter {
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;

	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	public LocalModel entityToModel(Local local) {
		return new LocalModel(local.getId(),local.getDireccion(),local.getLatitud(),local.getLongitud(),
				local.getNumeroTelefono(), entityToModelEmpleados(local.getEmpleados()),entityToModelLotes(local.getLotes()));
		
	}
	
	public Local modelToEntity(LocalModel local) {
		return new Local(local.getId(),
		local.getDireccion(),
		local.getLatitud(),
		local.getLongitud(),
				local.getNumeroTelefono(),modelToEntityEmpleados(local.getEmpleados()),modelToEntityLotes(local.getLotes()));
	}
	
	public Set<LoteModel> entityToModelLotes(Set<Lote> lotes){
		Set<LoteModel> lotesModel = new HashSet<LoteModel>();
		
		for(Lote lote : lotes) {
			LoteModel loteM = loteConverter.entityToModelSetLote(lote);
			lotesModel.add(loteM);
		}
		return lotesModel;
	}
	
	public Set<Lote> modelToEntityLotes(Set<LoteModel> lotesModel){
		Set<Lote> lotes = new HashSet<Lote>();
		if (lotesModel == null) {
			return lotes; 
		}
		else {
			for(LoteModel lote : lotesModel) {
				Lote loteM = loteConverter.modelToEntitySetLote(lote);
				lotes.add(loteM);
			}
		}
		return lotes;
	}

	public Set<EmpleadoModel> entityToModelEmpleados(Set<Empleado> empleados){
		Set<EmpleadoModel> empleadosModel = new HashSet<EmpleadoModel>();
		
		for(Empleado empleado : empleados) {
			EmpleadoModel empleadoM = empleadoConverter.entityToModelSetEmpleados(empleado);
			empleadosModel.add(empleadoM);
		}
		return empleadosModel;
	}
	
	public Set<Empleado> modelToEntityEmpleados(Set<EmpleadoModel> empleadosModel){
		Set<Empleado> empleados = new HashSet<Empleado>();
		if (empleadosModel == null) {
			return empleados; 
		}
		else {
			for(EmpleadoModel empleado : empleadosModel) {
				Empleado empleadoM = empleadoConverter.modelToEntitySetEmpleados(empleado);
				empleados.add(empleadoM);
			}
		}
		return empleados;
	}

}
