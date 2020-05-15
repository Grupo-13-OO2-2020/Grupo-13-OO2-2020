package Grupo13OO2.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import Grupo13OO2.Entities.Empleado;


@Entity
@Table(name="local")
public class Local {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String direccion;
	private float latitud;
	private float longitud;
	private int codigo;
	private int numeroTelefono;
//	@OneToOne
//    @JoinColumn(name = "fk_gerente", updatable = false, nullable = false)
//	private Empleado gerente;
	
	public Local() {}

	public Local(int id, String direccion, float latitud, float longitud, int codigo, int numeroTelefono) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.codigo = codigo;
		this.numeroTelefono = numeroTelefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	
	
	
	
	
	

}
