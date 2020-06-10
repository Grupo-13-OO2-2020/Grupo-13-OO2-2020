package Grupo13OO2.Models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

public class LoteModel {

	private int id;
//		@Min(value = 1, message = "numero lote no puede ser 0")
	private int numeroDeLote;
//@Min(value = 1, message = "cantidad no puede ser 0")
	private int cantidadRecibida;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@NotNull(message = "es obligatorio indicar fecha")
	private Date fechaIngreso;
//	@NotNull(message = "es obligatorio indicar producto")
	private ProductoModel producto;
//	@Min(value = 1, message = "cantidad no puede ser 0")
	private int cantidadExistente;
	//@NotNull(message = "es obligatorio indicar local")
	private LocalModel local;

	public LoteModel() {
	}

	public LoteModel(int id, int numeroDeLote, int cantidadRecibida, ProductoModel producto, int cantidadExistente,
			LocalModel local) {

		this.id = id;
		this.numeroDeLote = numeroDeLote;
		this.cantidadRecibida = cantidadRecibida;
		this.producto = producto;
		this.cantidadExistente = cantidadExistente;
		this.local = local;
	}

	public LoteModel(int id, int numeroDeLote, int cantidadRecibida, ProductoModel producto, int cantidadExistente) {

		this.id = id;
		this.numeroDeLote = numeroDeLote;
		this.cantidadRecibida = cantidadRecibida;
		this.producto = producto;
		this.cantidadExistente = cantidadExistente;
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
