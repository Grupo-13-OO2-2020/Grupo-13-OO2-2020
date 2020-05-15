package Grupo13OO2.Models;

import Grupo13OO2.Entities.Empleado;

public class LocalModel {
	
	private int id;
	private String direccion;
	private float latitud;
	private float longitud;
	private int codigo;
	private int numeroTelefono;
//	private Empleado gerente;
	
	public LocalModel() {}

	public LocalModel(int id, String direccion, float latitud, float longitud, int codigo, int numeroTelefono) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.codigo = codigo;
		this.numeroTelefono = numeroTelefono;
//		this.gerente = gerente;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
//
//	public Empleado getGerente() {
//		return gerente;
//	}
//
//	public void setGerente(Empleado gerente) {
//		this.gerente = gerente;
//	}
	

}
