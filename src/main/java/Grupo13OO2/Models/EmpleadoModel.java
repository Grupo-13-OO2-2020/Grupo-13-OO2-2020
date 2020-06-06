package Grupo13OO2.Models;

import java.util.Date;
import javax.validation.Valid;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.springframework.format.annotation.DateTimeFormat;


import Grupo13OO2.Entities.Local;
@Valid

public class EmpleadoModel extends PersonaModel{
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horarioEntrada;
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date  horarioSalida;
	@NotEmpty(message="Es obligatorio el tipo de empleado")
	private String tipoEmpleado;
	@Valid
    @DecimalMin("1") 
	private double sueldo;
	private boolean gerente;
	@ManyToOne
	private LocalModel local;

	public EmpleadoModel() {}

	public EmpleadoModel(int id, String nombre, int dni, String apellido, Date fechaNacimiento,
			Date  horarioEntrada,Date  horarioSalida, String tipoEmpleado, double sueldo, boolean gerente) {
		super(id, nombre, dni, apellido, fechaNacimiento);
		this.horarioEntrada = horarioEntrada;
		this.horarioSalida = horarioSalida;
		this.tipoEmpleado = tipoEmpleado;
		this.sueldo = sueldo;
		this.gerente = gerente;
	}

	public EmpleadoModel(int id, String nombre, int dni, String apellido, Date fechaNacimiento,
			Date  horarioEntrada,Date  horarioSalida, String tipoEmpleado, double sueldo, boolean gerente, LocalModel local) {
		super(id, nombre, dni, apellido, fechaNacimiento);
		this.horarioEntrada = horarioEntrada;
		this.horarioSalida = horarioSalida;
		this.tipoEmpleado = tipoEmpleado;
		this.sueldo = sueldo;
		this.gerente = gerente;
		this.local = local;
		
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

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}
	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}
	

}