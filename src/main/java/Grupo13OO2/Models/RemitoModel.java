package Grupo13OO2.Models;

import java.util.Date;

public class RemitoModel extends PedidoModel {

	public String formaDePago;

	public RemitoModel() {
	}

	public RemitoModel(int id, Date fecha, ProductoModel producto, int cantidad, EmpleadoModel vendedor,
			ClienteModel cliente, boolean aprobado, String formaDePago) {
		super(id, fecha, producto, cantidad, vendedor, cliente, aprobado);
		this.formaDePago = formaDePago;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

}
