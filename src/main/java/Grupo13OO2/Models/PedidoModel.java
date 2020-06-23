package Grupo13OO2.Models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotNull;



public class PedidoModel {
	@NotNull(message="es obligatorio indicar id")
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="es obligatorio indicar fecha")
	private Date fecha;
	@NotNull(message="es obligatorio indicar cantidad")
	protected int cantidad;
	@NotNull(message="es obligatorio indicar si esta facturando")
	protected ProductoModel producto;
	protected EmpleadoModel vendedor;
	protected ClienteModel cliente;
	
	public PedidoModel() {}

	public PedidoModel(int id, Date fecha, ProductoModel producto, int cantidad, EmpleadoModel vendedor,
			ClienteModel cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.vendedor = vendedor;
		this.cliente = cliente;
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

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public EmpleadoModel getVendedor() {
		return vendedor;
	}

	public void setVendedor(EmpleadoModel vendedor) {
		this.vendedor = vendedor;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	

	
	

}
