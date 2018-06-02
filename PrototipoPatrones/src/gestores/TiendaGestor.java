package gestores;

import java.time.LocalDate;
import java.util.ArrayList;

import objetos.*;

public class TiendaGestor {

	protected ArrayList<Tienda> listaTiendas;

	public TiendaGestor() {
		this.listaTiendas = new ArrayList<>();
	}

	public TiendaGestor(ArrayList<Tienda> listaTiendas) {
		this.listaTiendas = new ArrayList<>();
	}

	public ArrayList<Tienda> getListaTiendas() {
		return listaTiendas;
	}

	public Tienda addTienda(String codigo, String nombre, String direccion, String telefono) {

		Tienda tienda;
		tienda = new Tienda(codigo, nombre, direccion, telefono);
		listaTiendas.add(tienda);
		return tienda;
	}

	public void addEmpleadoToTienda(Tienda tienda, Persona empleado) {
		tienda.addEmpleado(empleado);
	}

	public void addClienteToTienda(Tienda tienda, Persona cliente) {
		tienda.addCliente(cliente);
	}

	public void addProductToTienda(Tienda tienda, Producto producto) {
		tienda.addProduct(producto);
	}

	public Tienda searchTiendaByEmail(String correo) {
		Tienda encontrada = null;
		for (Tienda miTienda : listaTiendas) {
			for (Persona miPersona : miTienda.getListaClientes()) {
				if (miPersona.getEmail().equals(correo)) {
					encontrada = miTienda;
				}
			}
		}

		return encontrada;
	}

	public Tienda searchTiendaByCode(String codigo) {
		Tienda encontrada = null;
		for (Tienda miTienda : listaTiendas) {
			if (miTienda.getCodigo().equals(codigo)) {
				encontrada = miTienda;
			}
		}
		return encontrada;
	}

	public Tienda searchTiendaByClient(Persona pCliente) {
		Tienda encontrada = null;
		for (Tienda tienda : getListaTiendas()) {
			for (Persona cliente : tienda.getListaClientes()) {
				if (cliente.getIdentificacion().equals(pCliente.getIdentificacion())) {
					encontrada = tienda;
				}
			}
		}
		return encontrada;
	}

	public Producto searchProductByCode(Tienda tienda, String codigo) throws Exception {
		Producto encontrado = null;
		ArrayList<Producto> productosTienda = tienda.getListaProductos();
		for (Producto elProducto : productosTienda) {
			if (elProducto.getCodigo().equals(codigo)) {
				encontrado = elProducto;
			}
		}
		return encontrado;

	}

	public ArrayList<Producto> productTypes(Tienda tienda, String tipo) {

		ArrayList<Producto> productosTienda = tienda.getListaProductos();
		ArrayList<Producto> productosAenviar = new ArrayList<>();

		for (Producto elProducto : productosTienda) {
			if (elProducto.getTipo().equals(tipo)) {
				productosAenviar.add(elProducto);
			}
		}
		return productosAenviar;

	}

	public Orden createOrden(Tienda tienda, Persona cliente, ArrayList<Producto> listaProductos, String metodoPago) {

		int codigo = (int) (Math.random() * 9999) + 1;
		Orden orden = new Orden(cliente, metodoPago, "EN PROCESO", LocalDate.now(), codigo);
		for (Producto p : listaProductos) {
			orden.addProduct(p);
		}
		tienda.addOrden(orden);
		return orden;
	}

	public ArrayList<Orden> searchOrdenesProceso(Tienda tienda) {

		ArrayList<Orden> ordenesProceso = new ArrayList<>();

		ArrayList<Orden> ordenes = tienda.getListaOrdenes();

		for (Orden orden : ordenes) {
			if (orden.getEstado().equals("EN PROCESO")) {
				ordenesProceso.add(orden);
			}
		}

		return ordenes;
	}

	public Orden searchOrden(Tienda tienda, int codigo) {
		Orden encontrada = null;

		ArrayList<Orden> listaOrdenes = tienda.getListaOrdenes();
		for (Orden orden : listaOrdenes) {
			if (orden.getCodigo() == codigo) {
				encontrada = orden;
			}
		}
		return encontrada;

	}

	public void acceptOrden(Tienda tienda, Orden orden, Persona usuario) {
		orden.setEstado("APROBADA");
		orden.setEmpleado(usuario);
		orden.setFechaModificacion(LocalDate.now());

		Factura factura = createFactura(orden);
		tienda.addFactura(factura);
	}

	public Factura createFactura(Orden orden) {
		double precio = calcularPrecioFactura(orden);
		Factura factura = new Factura(orden, LocalDate.now(), precio);
		return factura;

	}

	public double calcularPrecioFactura(Orden orden) {
		double precioFinal = 0.0;
		for (Producto producto : orden.getListaProductos()) {
			precioFinal += producto.getPrecio();
		}
		return precioFinal;
	}

	public void denyOrden(Tienda tienda, Orden orden, Persona usuario) {
		orden.setEstado("RECHAZADA");
		orden.setEmpleado(usuario);
		orden.setFechaModificacion(LocalDate.now());
	}

	public void deleteTienda(String codigo) {

		for (Tienda miTienda : listaTiendas) {
			if (miTienda.getCodigo().equals(codigo)) {
				listaTiendas.remove(miTienda);
			}
		}
	}

	public void deleteProduct(Tienda tienda, String codigo) {

		for (Producto elProducto : tienda.getListaProductos()) {
			if (elProducto.getCodigo().equals(codigo)) {
				tienda.getListaProductos().remove(elProducto);
			}
		}
	}

}
