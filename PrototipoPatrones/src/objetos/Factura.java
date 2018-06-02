package objetos;

import java.time.LocalDate;

public class Factura {

	protected Orden orden;
	protected String codigo;
	LocalDate fecha;
	double precioFinal;

	public Factura(Orden orden, LocalDate fecha, double precioFinal) {

		this.orden = orden;
		this.fecha = fecha;
		this.precioFinal = precioFinal;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	@Override
	public String toString() {
		
		return 
			"*********************************************************************\n"
			+"****** FACTURA # " + codigo + "                               ******\n"
			+"****** ORDEN # "+ orden.getCodigo()+"                         ******\n"
			+"****** FECHA CREACION: "+ orden.getFechaOrdenacion()+"        ******\n"
			+"****** FECHA APROBACION: "+orden.getFechaModificacion()+"     ******\n"
			+"****** PRECIO FINAL: "+precioFinal+" COLONES"+"               ******\n"
			+"********************************************************************\n"

				;
	}

}
