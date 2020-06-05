package Grupo13OO2.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Table(name = "empleado")
public class Empleado extends Persona {
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm") 
	private Date horarioEntrada;
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date  horarioSalida;
	
	private String tipoEmpleado;
	private double sueldo;
	private boolean gerente;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Local local;

	public Empleado() {

	}

	public Empleado(int id, String nombre, int dni, String apellido, Date fechaNacimiento,
			Date  horarioEntrada,Date  horarioSalida, String tipoEmpleado, double sueldo, boolean gerente) {
		super(id, nombre, dni, apellido, fechaNacimiento);
		this.horarioEntrada = horarioEntrada;
		this.horarioSalida = horarioSalida;
		this.tipoEmpleado = tipoEmpleado;
		this.sueldo = sueldo;
		this.gerente = gerente;
	}

	public Empleado(int id, String nombre, int dni, String apellido, Date fechaNacimiento,
			Date  horarioEntrada,Date  horarioSalida, String tipoEmpleado, double sueldo, boolean gerente, Local local) {
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	
	
	
}