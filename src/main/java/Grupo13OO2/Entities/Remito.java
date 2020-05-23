package Grupo13OO2.Entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Inheritance( strategy = InheritanceType.JOINED)
@Table(name="remito")
public class Remito extends Pedido {
	
	public String formaDePago;

	public Remito() {}

	public Remito(int id,Date fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente, boolean facturado,String formaDePago) {
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
