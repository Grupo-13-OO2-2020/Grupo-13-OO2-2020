package Grupo13OO2.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="local")
public class Local {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String direccion;
	private float latitud;
	private float longitud;
	private int numeroTelefono;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gerente_id", referencedColumnName = "id")
	private Empleado empleado;
	
	@OneToMany(mappedBy="local", cascade = CascadeType.ALL)
    private Set<Empleado> empleados;
	
	public Local() {}

	public Local(int id, String direccion, float latitud, float longitud, int numeroTelefono, Empleado empleado
			, Set<Empleado> empleados) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.numeroTelefono = numeroTelefono;
		this.empleado = empleado;
		this.empleados = empleados;
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

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

}
