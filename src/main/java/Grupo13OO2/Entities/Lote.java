package Grupo13OO2.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "lote")
public class Lote {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private int numeroDeLote;
	private int cantidadRecibida;
	@Column(name="fechaIngreso")
	@CreationTimestamp
	private Date fechaIngreso;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="producto_id", nullable=false)
	private Producto producto;
	@ManyToOne
    @JoinColumn(name="local_id")
    private Local local;
	
	
	public Local getLocal() {
		return local;
	}


	public void setLocal(Local local) {
		this.local = local;
	}


	private int cantidadExistente;
	
	
	
	
	public Lote() {
	}
	
	
	public Lote(int id,int numeroDeLote, int cantidadRecibida, Producto producto,int cantidadExistente, Local local) {
		setId(id);
		this.numeroDeLote = numeroDeLote;
		this.cantidadRecibida = cantidadRecibida;
		this.producto = producto;
		this.cantidadExistente=cantidadExistente;
		this.local=local;
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
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
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
