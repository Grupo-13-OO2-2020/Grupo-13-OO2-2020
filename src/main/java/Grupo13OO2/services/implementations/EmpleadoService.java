package Grupo13OO2.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Entities.Local;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.RemitoModel;
import Grupo13OO2.Models.SolicitudStockModel;
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
	public List<EmpleadoModel> getAll() {
		List<Empleado> empleados=empleadoRepository.findAll();
		List<EmpleadoModel> empleadoModels= new ArrayList<EmpleadoModel>();
		for(Empleado e : empleados) {
			empleadoModels.add(empleadoConverter.entityToModel(e));
			}
		return empleadoModels;
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

	@Override
	public Page<EmpleadoModel> getAllPages(Pageable pageable) {
		Page<Empleado> empleados= empleadoRepository.findAll(pageable);
		Page<EmpleadoModel> pages= empleados.map(new Function<Empleado, EmpleadoModel>(){
			public EmpleadoModel apply(Empleado empleado) {
				EmpleadoModel empleadoModel = empleadoConverter.entityToModel(empleado);
				return empleadoModel;
			}
		});
		
		return pages;
	}
	
	@Override
	public double sueldoxEmpleado(EmpleadoModel empleado){//hay q hacer q lo cuente solo en tal mes 
		LocalModel local = ListarId(empleado.getId()).getLocal();
		List<RemitoModel> remitos = localService.getRemitos(local);
		List<SolicitudStockModel> solicitudes = localService.getSolicitudesStock(local);
		double contadorRemitos = 0;
		double contadorVendedor = 0;
		double contadorColaborador = 0;

		for(RemitoModel r : remitos){
			if (r.getVendedor().getId() ==  empleado.getId()){
				contadorRemitos += ((r.getProducto().getPrecioUnitario() * r.getCantidad()) * 5 / 100);
			}
		}

		for(SolicitudStockModel s : solicitudes){
			if (s.getVendedor().getId() == empleado.getId()) {
				contadorVendedor += ((s.getProducto().getPrecioUnitario() * s.getCantidad()) * 3 / 100);
			}
			if (s.getColaborador() != null) {
				if (s.getColaborador().getId() == empleado.getId()) {
					contadorColaborador += ((s.getProducto().getPrecioUnitario() * s.getCantidad()) * 2 / 100);
				}
			}
		}

		double sueldoTotal = empleado.getSueldo() + contadorColaborador + contadorVendedor + contadorRemitos;

		return sueldoTotal;
	}
}