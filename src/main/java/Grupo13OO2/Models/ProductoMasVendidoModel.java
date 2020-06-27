package Grupo13OO2.Models;

public class ProductoMasVendidoModel {
	private int idProductoVendido;
	private String nombreProductoVendido;
	private int cantidadProductosVendidos;

	public ProductoMasVendidoModel(String nombreProductoVendido, int cantidadProductosVendidos) {
		super();
		this.nombreProductoVendido = nombreProductoVendido;
		this.cantidadProductosVendidos = cantidadProductosVendidos;
	}

	public ProductoMasVendidoModel() {

	}

	public int getIdProductoVendido() {
		return idProductoVendido;
	}

	public void setIdProductoVendido(int idProductoVendido) {
		this.idProductoVendido = idProductoVendido;
	}

	public String getNombreProductoVendido() {
		return nombreProductoVendido;
	}

	public void setNombreProductoVendido(String nombreProductoVendido) {
		this.nombreProductoVendido = nombreProductoVendido;
	}

	public int getCantidadProductosVendidos() {
		return cantidadProductosVendidos;
	}

	public void setCantidadProductosVendidos(int cantidadProductosVendidos) {
		this.cantidadProductosVendidos = cantidadProductosVendidos;
	}

}
