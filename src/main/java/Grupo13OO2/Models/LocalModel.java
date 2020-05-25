package Grupo13OO2.Models;

import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import Grupo13OO2.Entities.Empleado;

public class LocalModel {
	
	private int id;
	private String direccion;
	private float latitud;
	private float longitud;
	private int numeroTelefono;
	@OneToOne
	private Empleado empleado;
	@OneToMany
    private Set<Empleado> empleados;
	
	 private Set<LoteModel> lotesM;
	 
	public LocalModel() {}

	public LocalModel(int id, String direccion, float latitud, float longitud, int numeroTelefono, Empleado empleado
			, Set<Empleado> empleados, Set<LoteModel> lotesM) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.numeroTelefono = numeroTelefono;
		this.empleado = empleado;
		this.empleados = empleados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Set<LoteModel> getLotesModels() {
		return lotesM;
	}

	public void setLotesModels(Set<LoteModel> lotesM) {
		this.lotesM = lotesM;
	}
	
	

}
