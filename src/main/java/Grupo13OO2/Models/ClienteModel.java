package Grupo13OO2.Models;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.Valid;

@Valid
public class ClienteModel extends PersonaModel {

	//@NotEmpty(message = "El email es obligatorio")
	private String email;
	@Min(value = 1, message = "el numero no puede ser 0")
	private int numero;
	//@Size(min=1,max=11,message="El cuil es obligatorio")
	private long cuil;
	 //@Size(min=1,max=11,message="El cuit es obligatorio")
	private long cuit;

	public ClienteModel() {
	}

	public ClienteModel(int id, String nombre, int dni, String apellido, LocalDate fechaNacimiento, String email, int numero,
			long cuit, long cuil) {
		super(id, nombre, dni, apellido, fechaNacimiento);
		this.email = email;
		this.numero = numero;
		this.cuil = cuil;
		this.cuit = cuit;
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



}