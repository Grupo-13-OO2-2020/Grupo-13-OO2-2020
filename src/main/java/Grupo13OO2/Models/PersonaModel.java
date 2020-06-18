package Grupo13OO2.Models;

import java.time.LocalDate;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Valid
public class PersonaModel {

	private int id;
	@NotEmpty(message = "es obligatorio indicar nombre")
	private String nombre;
	@Min(value = 1, message = "el dni no puede ser 0")
	private int dni;
	@NotEmpty(message = "es obligatorio indicar apellido")
	private String apellido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	public PersonaModel() {
	}

	public PersonaModel(int id, String nombre, int dni, String apellido, LocalDate fechaNacimiento) {
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}