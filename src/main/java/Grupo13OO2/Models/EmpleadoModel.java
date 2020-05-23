package Grupo13OO2.Models;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import Grupo13OO2.Entities.Local;

public class EmpleadoModel extends PersonaModel{
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horarioEntrada;
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date  horarioSalida;
	private String tipoEmpleado;
	private double sueldo;
	@ManyToOne
	private Local local;
	@OneToOne(mappedBy = "empleado")
	private Local localGerente;

	public EmpleadoModel() {}

	public EmpleadoModel(int id, String nombre, int dni, String apellido, Date fechaNacimiento,
			Date  horarioEntrada,Date  horarioSalida, String tipoEmpleado, double sueldo, Local local, Local localGerente) {
		super(id, nombre, dni, apellido, fechaNacimiento);
		this.horarioEntrada = horarioEntrada;
		this.horarioSalida = horarioSalida;
		this.tipoEmpleado = tipoEmpleado;
		this.sueldo = sueldo;
		this.local = local;
		this.localGerente = localGerente;
	}

	public Date getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(Date horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

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

	public Local getlocalGerente() {
		return localGerente;
	}

	public void setlocalGerente(Local local) {
		this.localGerente = local;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Local getLocalGerente() {
		return localGerente;
	}

	public void setLocalGerente(Local localGerente) {
		this.localGerente = localGerente;
	}

	

}