package Grupo13OO2.Entities;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
public class Producto {
	
	private String descripcion;
	private double precioUnitario;
	private int codigoProducto;
	private String talle;

}
