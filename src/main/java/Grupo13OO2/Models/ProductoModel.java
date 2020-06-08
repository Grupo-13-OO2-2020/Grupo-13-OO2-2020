package Grupo13OO2.Models;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Valid
public class ProductoModel {
	private int id;
	@NotEmpty
	private String descripcion;
	@Valid
	@DecimalMin("1")
	private double precioUnitario;
	@Min(value = 1, message = "el codigo no puede ser 0")
	private int codigoProducto;
    @NotEmpty
    @Pattern(regexp = "[0-9]+", message="El talle solo puede tener números")

	private String talle;

	public ProductoModel() {
	}

	public ProductoModel(int id, String descripcion, double precioUnitario, int codigoProducto, String talle) {

		this.setId(id);
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.codigoProducto = codigoProducto;
		this.talle = talle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

}
