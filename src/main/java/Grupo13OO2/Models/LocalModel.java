package Grupo13OO2.Models;

import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class LocalModel {
	
	private int id;
	private String direccion;
	private float latitud;
	private float longitud;
	private int numeroTelefono;
	@OneToMany
    private Set<EmpleadoModel> empleados;
	@OneToMany
	private Set<LoteModel> lotes;
	 
	public LocalModel() {}

	public LocalModel(int id, String direccion, float latitud, float longitud, int numeroTelefono
			, Set<EmpleadoModel> empleados, Set<LoteModel> lotes) {
		super();
		setId(id);
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.numeroTelefono = numeroTelefono;
		this.empleados = empleados;
		this.lotes = lotes;
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

	public Set<EmpleadoModel> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<EmpleadoModel> empleados) {
		this.empleados = empleados;
	}

	public Set<LoteModel> getLotes() {
		return lotes;
	}

	public void setLotes(Set<LoteModel> lotes) {
		this.lotes = lotes;
	}
	
	public double getDistanciaCoord(LocalModel local,LocalModel localDestino) {
		double lat1 = local.getLatitud();
		double lng1 = local.getLongitud();
		double lat2 = localDestino.getLatitud();
		double lng2 = localDestino.getLongitud();
		double radioTierra = 6371; //en kilómetros
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
		+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		return radioTierra * va2;
	}
	

}
