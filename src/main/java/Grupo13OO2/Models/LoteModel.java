package Grupo13OO2.Models;

import java.util.Date;

public class LoteModel {
	
	private int id;
	private int numeroDeLote;
	private int cantidadRecibida;
	private Date fechaIngreso;
	private ProductoModel producto;
	private int cantidadExistente;
	private LocalModel local;
	
	
	
	public LoteModel() {
	}
	
	
	public LoteModel(int id,int numeroDeLote, int cantidadRecibida, ProductoModel producto,int cantidadExistente, LocalModel local) {
		
		this.id = id;
		this.numeroDeLote = numeroDeLote;
		this.cantidadRecibida = cantidadRecibida;
		this.producto = producto;		
		this.cantidadExistente=cantidadExistente;
		this.local=local;
	}

	public LoteModel(int id,int numeroDeLote, int cantidadRecibida, ProductoModel producto,int cantidadExistente) {
		
		this.id = id;
		this.numeroDeLote = numeroDeLote;
		this.cantidadRecibida = cantidadRecibida;
		this.producto = producto;		
		this.cantidadExistente=cantidadExistente;
	}

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
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
	public void setCantidadRecibida(int cantidadRecibida) {
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