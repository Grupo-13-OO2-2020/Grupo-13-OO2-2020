package Grupo13OO2.Entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Table(name = "cliente")
public class Cliente extends Persona {

	private String email;
	private int numero;
	private long cuil;
	private long cuit;

	public Cliente() {
	}

	public Cliente(int id, String nombre, int dni, String apellido, LocalDate fechaNacimiento, String email, int numero,
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