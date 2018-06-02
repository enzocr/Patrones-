package objetos;

import java.util.ArrayList;

public class Tienda {

	protected String codigo;
	protected String nombre;
	protected String direccion;
	protected String telefono;
	protected ArrayList<Persona> listaEmpleados;
	protected ArrayList<Persona> listaClientes;
	protected ArrayList<Producto> listaProductos;
	protected ArrayList<Orden> listaOrdenes;
	protected ArrayList<Factura> listaFacturas;
	protected ArrayList<Historial> listaHistorial;

	public Tienda(String codigo, String nombre, String direccion, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Persona> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Persona> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<Persona> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Persona> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public ArrayList<Historial> getListaHistorial() {
		return listaHistorial;
	}

	public void setListaHistorial(ArrayList<Historial> listaHistorial) {
		this.listaHistorial = listaHistorial;
	}

	public ArrayList<Orden> getListaOrdenes() {
		return listaOrdenes;
	}

	public void setListaOrdenes(ArrayList<Orden> listaOrdenes) {
		this.listaOrdenes = listaOrdenes;
	}

	public void addEmpleado(Persona empleado) {
		if (isNullListaEmpleados() == false) {
			listaEmpleados.add(empleado);
		}
	}

	public void addProduct(Producto producto) {
		if (isNullListaProducts() == false) {
			listaProductos.add(producto);
		}

	}

	public void addCliente(Persona cliente) {
		if (isNullListaClientes() == false) {
			listaClientes.add(cliente);
		}

	}

	public void addFactura(Factura factura) {
		if (isNullListaFacturas() == false) {
			listaFacturas.add(factura);
		}

	}

	public void addHistorial(Historial historial) {
		if (isNullHistorial() == false) {
			listaHistorial.add(historial);
		}

	}

	public void addOrden(Orden orden) {
		if (isNullListaOrdenes() == false) {
			listaOrdenes.add(orden);
		}

	}

	public boolean isNullListaOrdenes() {
		if (this.listaOrdenes == null) {
			this.listaOrdenes = new ArrayList<>();
			return false;
		} else {
			return false;
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

	public boolean isNullListaEmpleados() {
		if (this.listaEmpleados == null) {
			this.listaEmpleados = new ArrayList<>();
			return false;
		} else {
			return false;
		}
	}

	public boolean isNullListaClientes() {
		if (this.listaClientes == null) {
			this.listaClientes = new ArrayList<>();
			return false;
		} else {
			return false;
		}
	}

	public boolean isNullListaFacturas() {
		if (this.listaFacturas == null) {
			this.listaFacturas = new ArrayList<>();
			return false;
		} else {
			return false;
		}
	}

	public boolean isNullHistorial() {
		if (this.listaFacturas == null) {
			this.listaFacturas = new ArrayList<>();
			return false;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return codigo + " || " + nombre + " || " + direccion + " || " + telefono + "\n";
	}

}
