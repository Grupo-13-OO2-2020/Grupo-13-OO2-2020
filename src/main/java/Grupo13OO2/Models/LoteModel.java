package Grupo13OO2.Models;

import java.util.Date;

import javax.persistence.ManyToOne;

import Grupo13OO2.Entities.Producto;


public class LoteModel {
	
	private int id;
	private int numeroDeLote;
	private int cantidadRecibida;
	private Date fechaIngreso;
	private ProductoModel producto;
	private int cantidadExistente;
	
	
	
	
	public LoteModel() {
	}
	
	
	public LoteModel(int id,int numeroDeLote, int cantidadRecibida, ProductoModel producto) {
		super();
		this.id=id;
		this.numeroDeLote = numeroDeLote;
		this.cantidadRecibida = cantidadRecibida;
		this.producto = producto;
		this.cantidadExistente = cantidadRecibida;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidadRecibida() {
		return cantidadRecibida;
	}
	protected void setCantidadRecibida(int cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public ProductoModel getProducto() {
		return producto;
	}
	public void setProducto(ProductoModel producto) {
		this.producto = producto;
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
