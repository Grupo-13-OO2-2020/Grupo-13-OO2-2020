package Grupo13OO2.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Table(name = "remito")
public class Remito extends Pedido {

	public String formaDePago;

	public Remito() {
	}

	public Remito(int id, Date fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente,
			String formaDePago) {
		super(id, fecha, producto, cantidad, vendedor, cliente);
		this.formaDePago = formaDePago;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

}
