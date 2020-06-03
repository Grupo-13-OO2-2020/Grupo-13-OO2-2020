package Grupo13OO2.Models;

import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Valid
public class PersonaModel {

	private int id;
	@NotEmpty(message = "es obligatorio indicar nombre")
	private String nombre;
<<<<<<< HEAD
	@Min(value = 1, message = "el dni no puede ser 0")
=======
	@Size(min = 2, max = 9)
>>>>>>> 25e12ba... pequeños cambios de vistas distancias y otros
	private int dni;
	@NotEmpty(message = "es obligatorio indicar apellido")
	private String apellido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "es obligatorio indicar fecha")
	private Date fechaNacimiento;

	public PersonaModel() {
	}

	public PersonaModel(int id, String nombre, int dni, String apellido, Date fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}