package Grupo13OO2.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Entities.Local;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.converters.EmpleadoConverter;
import Grupo13OO2.converters.LocalConverter;
import Grupo13OO2.repositories.IEmpleadoRepository;
import Grupo13OO2.repositories.ILocalRepository;
import Grupo13OO2.services.IEmpleadoService;

@Service("empleadoService")
public class EmpleadoService implements IEmpleadoService {
	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;

	@Autowired
	@Qualifier("localService")
	private LocalService localService;

	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;

	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	@Override
	public List<Empleado> getAll() {
		return empleadoRepository.findAll();
	}

	@Override
	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel) {
		Local local = localRepository.findById(empleadoModel.getLocal().getId());
		LocalModel localModel = localConverter.entityToModel(local);
		empleadoModel.setLocal(localModel);

		Empleado empleado = empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));

		empleado.getLocal().getEmpleados().add(empleado);
		localService.insertOrUpdate(localConverter.entityToModel(empleado.getLocal()));

		return empleadoConverter.entityToModel(empleado);
	}

	@Override
	public String delete(int id) {
		empleadoRepository.deleteById(id);
		return "Cliente borrada" + id;
	}

	@Override
	public EmpleadoModel ListarId(int id) {

		return empleadoConverter.entityToModel(empleadoRepository.findById(id));
	}
}