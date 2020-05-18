package Grupo13OO2.Models;

import java.time.LocalDate;
import java.util.Date;

import Grupo13OO2.Entities.Local;

public class ClienteModel extends PersonaModel{

	private String email;
	private int numero;	
	private long cuil;
	private long cuit;
  //private Local local;
    
    public ClienteModel() {}


	public ClienteModel(int id, String nombre, int dni, String apellido, Date fechaNacimiento,String email, int numero,long cuit,long cuil) {
	super(id,nombre,dni,apellido,fechaNacimiento);
	this.email = email;
	this.numero = numero;
	this.cuil=cuil;
	this.cuit=cuit;
}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}


	public long getCuil() {
		return cuil;
	}


	public void setCuil(long cuil) {
		this.cuil = cuil;
	}


	public long getCuit() {
		return cuit;
	}


	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	
//	public Local getLocal() {
//		return local;
//	}
//
//	public void setLocal(Local local) {
//		this.local = local;
//	}
//	
	
	
}