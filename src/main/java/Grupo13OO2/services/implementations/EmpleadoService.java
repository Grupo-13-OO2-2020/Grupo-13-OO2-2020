package Grupo13OO2.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.converters.EmpleadoConverter;
import Grupo13OO2.repositories.IEmpleadoRepository;
import Grupo13OO2.services.IEmpleadoService;


@Service("empleadoService")
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Autowired
    @Qualifier("empleadoConverter")
    private EmpleadoConverter empleadoConverter;

    @Override
    public List<Empleado> getAll(){
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel){
        Empleado empleado = empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));
        return empleadoConverter.entityToModel(empleado);
    }
    
    @Override
    public String delete(int id){
        empleadoRepository.deleteById(id);
        return "Cliente borrada" + id;
    }

    @Override
	public EmpleadoModel ListarId(int id) {
        
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        

		return empleadoConverter.entityToModel(empleado.get());
	}
}