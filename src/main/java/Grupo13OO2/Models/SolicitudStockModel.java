package Grupo13OO2.Models;
import java.util.Date;

import Grupo13OO2.Entities.Cliente;
import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Entities.Local;

import Grupo13OO2.Entities.Producto;

public class SolicitudStockModel extends PedidoModel{
	
	private Empleado colaborador;
	private boolean aceptado;
	private Local localDetinatario;
	
	public SolicitudStockModel() {}

	

	public SolicitudStockModel(int id,Date fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente, boolean facturado,Empleado colaborador, boolean aceptado, Local localDetinatario) {
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
