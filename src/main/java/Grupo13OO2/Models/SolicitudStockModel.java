package Grupo13OO2.Models;

import java.util.Date;

public class SolicitudStockModel extends PedidoModel {

	private EmpleadoModel colaborador;
	private boolean aceptado;
	private LocalModel localDestinatario;

	public SolicitudStockModel() {
	}

	public SolicitudStockModel(int id, Date fecha, ProductoModel producto, int cantidad, EmpleadoModel vendedor,
			ClienteModel cliente, boolean facturado, EmpleadoModel colaborador, boolean aceptado,
			LocalModel localDestinatario) {
		super(id, fecha, producto, cantidad, vendedor, cliente, facturado);
		this.colaborador = colaborador;
		this.aceptado = aceptado;
		this.localDestinatario = localDestinatario;
	}

	public EmpleadoModel getColaborador() {
		return colaborador;
	}

	public void setColaborador(EmpleadoModel colaborador) {
		this.colaborador = colaborador;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public LocalModel getLocalDestinatario() {
		return localDestinatario;
	}

	public void setLocalDestinatario(LocalModel localDestinatario) {
		this.localDestinatario = localDestinatario;
	}

}
