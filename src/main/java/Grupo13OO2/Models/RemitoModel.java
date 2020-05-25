package Grupo13OO2.Models;
import java.util.Date;

import Grupo13OO2.Entities.Cliente;
import Grupo13OO2.Entities.Empleado;


import Grupo13OO2.Entities.Producto;
public class RemitoModel extends PedidoModel {
	
	public String formaDePago;
	
	public RemitoModel() {}

	public RemitoModel(int id,Date fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente, boolean facturado,String formaDePago) {
		super(id,fecha,producto,cantidad,vendedor, cliente,facturado);
		this.formaDePago = formaDePago;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	

}
