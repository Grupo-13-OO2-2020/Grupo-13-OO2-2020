package Grupo13OO2.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import Grupo13OO2.Entities.*;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance( strategy = InheritanceType.JOINED)
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	@OneToOne
	@JoinColumn(name = "producto_id")
	protected Producto producto;
	protected int cantidad;
	@OneToOne
	@JoinColumn(name = "vendedor_id")
	protected Empleado vendedor;
	@OneToOne
	@JoinColumn(name = "cliente_id")
	protected Cliente cliente;
	protected boolean facturado;
	
	public Pedido() {}

	public Pedido(int id, Date fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente,
			boolean facturado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.facturado = facturado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Empleado getVendedor() {
		return vendedor;
	}

	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isFacturado() {
		return facturado;
	}

	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}
}