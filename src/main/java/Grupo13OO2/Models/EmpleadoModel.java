package Grupo13OO2.Models;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class EmpleadoModel extends PersonaModel{
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horarioEntrada;
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date  horarioSalida;
	private String tipoEmpleado;
	private double sueldo;
	private int idLocal;

	public EmpleadoModel() {}

	public EmpleadoModel(int id, String nombre, int dni, String apellido, Date fechaNacimiento,
			Date  horarioEntrada,	 Date  horarioSalida, String tipoEmpleado, double sueldo, int idLocal) {
		super(id, nombre, dni, apellido, fechaNacimiento);
		this.horarioEntrada = horarioEntrada;
		this.horarioSalida = horarioSalida;
		this.tipoEmpleado = tipoEmpleado;
		this.sueldo = sueldo;
		this.idLocal = idLocal;
	}

	
  public Date getHorarioEntrada() { return horarioEntrada; }
	  
	  public void setHorarioEntrada(Date horarioEntrada) { 
		  this.horarioEntrada = horarioEntrada; }
	 
	public Date  getHorarioSalida() {
		return horarioSalida;
	}

	public void setHorarioSalida(Date  horarioSalida) {
		this.horarioSalida = horarioSalida;
	}

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

}