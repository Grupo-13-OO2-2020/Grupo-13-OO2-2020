package Grupo13OO2.Entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import  Grupo13OO2.Entities.Empleado;
import  Grupo13OO2.Entities.Local;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Inheritance( strategy = InheritanceType.JOINED)
@Table(name="solicitudStock")
public class SolicitudStock extends Pedido{
	
	private Empleado colaborador;
	private boolean aceptado;
	private Local localDetinatario;
	
	public SolicitudStock() {}

	

	public SolicitudStock(int id,Date fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente, boolean facturado,Empleado colaborador, boolean aceptado, Local localDetinatario) {
		super(id,fecha,producto,cantidad,vendedor, cliente,facturado);
		this.colaborador = colaborador;
		this.aceptado = aceptado;
		this.localDetinatario = localDetinatario;
	}



	public Empleado getColaborador() {
		return colaborador;
	}

	public void setColaborador(Empleado colaborador) {
		this.colaborador = colaborador;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public Local getLocalDetinatario() {
		return localDetinatario;
	}

	public void setLocalDetinatario(Local localDetinatario) {
		this.localDetinatario = localDetinatario;
	}
	
	
	
	

}
