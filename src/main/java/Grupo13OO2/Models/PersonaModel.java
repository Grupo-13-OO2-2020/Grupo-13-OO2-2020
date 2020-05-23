package Grupo13OO2.Models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PersonaModel {
    private int id;
	private String nombre;
	private int dni;
	private String apellido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	
    public PersonaModel() {}

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