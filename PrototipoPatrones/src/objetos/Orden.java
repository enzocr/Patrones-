package objetos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Orden {

	protected int codigo;
	protected Persona empleado;
	protected Persona cliente;
	protected ArrayList<Producto> listaProductos;
	protected String metodoPago;
	protected String estado;
	protected LocalDate fechaOrdenacion;
	protected LocalDate fechaModificacion;

	public Orden(Persona cliente, String metodoPago, String estado,
			LocalDate fechaOrden, int codigo) {
		this.cliente = cliente;
		this.metodoPago = metodoPago;
		this.estado = estado;
		this.fechaOrdenacion = fechaOrden;
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Persona getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Persona empleado) {
		this.empleado = empleado;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFechaOrdenacion() {
		return fechaOrdenacion;
	}

	public void setFechaOrdenacion(LocalDate fechaOrdenacion) {
		this.fechaOrdenacion = fechaOrdenacion;
	}

	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDate fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public void addProduct(Producto producto) {
		if (isNullListaProducts() == false) {
			listaProductos.add(producto);
		}

	}

	public boolean isNullListaProducts() {
		if (this.listaProductos == null) {
			this.listaProductos = new ArrayList<>();
			return false;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return codigo + " || " + empleado.getNombre_completo() + " || " + cliente.getNombre_completo() + " || " + " || "
				+ metodoPago + " || " + estado;
	}

}
