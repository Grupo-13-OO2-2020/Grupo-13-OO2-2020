package Grupo13OO2.Models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import Grupo13OO2.Entities.Cliente;
import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Entities.Producto;
import javax.validation.constraints.NotNull;


public class PedidoModel {
	@NotNull(message="es obligatorio indicar id")
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="es obligatorio indicar fecha")
	private Date fecha;
	
	protected Producto producto;
	@NotNull(message="es obligatorio indicar cantidad")
	protected int cantidad;
	
	protected Empleado vendedor;
	
	protected Cliente cliente;
	@NotNull(message="es obligatorio indicar si esta facturando")
	protected boolean facturado;
	
	public PedidoModel() {}

	public PedidoModel(int id,Date fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente, boolean facturado) {
		super();
		this.id=id;
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
