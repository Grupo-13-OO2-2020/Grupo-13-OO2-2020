package Grupo13OO2.Models;


import java.util.Date;


public class LoteModel {
	
	private int cantidadRecibida;
	private Date fechaIngreso;
	private ProductoModel productoModel;
	private int cantidadExistente;
	private int numeroDeLote;
	
	public LoteModel() {
		
	}

	public LoteModel(int cantidadRecibida, Date fechaIngreso, ProductoModel productoModel, int cantidadExistente,
			int numeroDeLote) {
		super();
		this.cantidadRecibida = cantidadRecibida;
		this.fechaIngreso = fechaIngreso;
		this.productoModel = productoModel;
		this.cantidadExistente = cantidadExistente;
		this.numeroDeLote = numeroDeLote;
	}

	public int getCantidadRecibida() {
		return cantidadRecibida;
	}

	public void setCantidadRecibida(int cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public ProductoModel getProductoModel() {
		return productoModel;
	}

	public void setProductoModel(ProductoModel productoModel) {
		this.productoModel = productoModel;
	}

	public int getCantidadExistente() {
		return cantidadExistente;
	}

	public void setCantidadExistente(int cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}

	public int getNumeroDeLote() {
		return numeroDeLote;
	}

	public void setNumeroDeLote(int numeroDeLote) {
		this.numeroDeLote = numeroDeLote;
	}
	

}
