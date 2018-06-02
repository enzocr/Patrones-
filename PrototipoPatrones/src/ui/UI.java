package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import gestores.PersonaGestor;
import gestores.ProductoGestor;
import gestores.TiendaGestor;
import objetos.Factura;
import objetos.Orden;
import objetos.Persona;
import objetos.Producto;
import objetos.Tienda;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class UI {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static ProductoGestor gestorProducto = new ProductoGestor();
	static PersonaGestor gestorPersona = new PersonaGestor();
	static TiendaGestor gestorTienda = new TiendaGestor();

	/**
	 * @param args
	 *            the command line arguments
	 * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {
		try {
			int opc;
			registrarAdmin();
			init();
			do {

				mostrarMenu();
				opc = leerOpcion();
				ejecutarAccion(opc);

			} while (opc != 4);
		} catch (Exception e) {
			out.println(e.getMessage());

		}
	}

	public static void mostrarMenu() throws IOException {

		out.println();
		out.println("-----------|          BIENVENIDO         |-----------");
		out.println("-----------| 1.      INICIAR SESION      |-----------");
		out.println("-----------| 2. REGISTRARSE COMO CLIENTE |-----------");
		out.println("-----------| 3.      VER PRODUCTOS       |-----------");
		out.println("-----------| 4.          SALIR           |-----------");

		out.println();
	}

	public static int leerOpcion() throws Exception {

		int opcion;

		opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

		if (opcion < 0 || opcion > 4) {

			throw new Exception("OPCION INVALIDA");

		}

		return opcion;
	}

	public static void ejecutarAccion(int pOpcion) throws Exception {

		switch (pOpcion) {

		case 1:
			iniciarSesion();
			break;

		case 2:
			registrarCliente();
			break;

		case 3:
			buscarListarProducto();
			break;

		case 4:
			out.println("Gracias por usar el sistema");
			break;

		default:
			out.println("Opcion invalida");
			throw new Exception("OPCION INVALIDA");
		}
	}

	public static void iniciarSesion() throws Exception {
		String correo, password;
		out.println("Correo electrónico: ");
		correo = in.readLine();

		Persona usuario = gestorPersona.searchUserByEmail(correo);

		if (usuario == null) {
			out.println("Correo no se encuentra registrado en el sistema");
		} else {
			out.println("Contraseña: ");
			password = in.readLine();
			if (usuario.getClave().equals(password)) {

				Tienda tiendaUsuario = gestorTienda.searchTiendaByEmail(correo);

				if (usuario.getRol() == 1) {
					try {
						int opc;

						do {

							menuAdministrador();
							opc = leerOpcionAdmin();
							ejecutarAccionAdmin(opc, usuario);

						} while (opc != 16);
					} catch (Exception e) {
						out.println(e.getMessage());

					}
				}

				if (usuario.getRol() == 2) {
					try {
						int opc;

						do {

							menuEmpleado();
							opc = leerOpcionEmpleado();
							ejecutarAccionEmpleado(opc, tiendaUsuario, usuario);

						} while (opc != 10);
					} catch (Exception e) {
						out.println(e.getMessage());

					}
				}

				if (usuario.getRol() == 3) {
					try {
						int opc;

						do {

							menuCliente();
							opc = leerOpcionCliente();
							ejecutarAccionCliente(opc, tiendaUsuario, usuario);

						} while (opc != 4);
					} catch (Exception e) {
						out.println(e.getMessage());

					}
				}

			} else {
				out.println("Contraseña incorrecta");
			}

		}

	}

	public static void menuAdministrador() {
	
		out.println();
		out.println("-------------------------BIENVENIDO A VIDEOCENTRO-------------------------");
		out.println();
		out.println("1. Registrar tienda    || 2. Búsqueda tienda    || 3. Eliminación tienda  ");
		out.println("4. Registrar producto  || 5. Búsqueda producto  || 6. Eliminación producto");
		out.println("7. Registrar cliente   || 8. Búsqueda cliente   || 9. Eliminación cliente ");
		out.println("10.Registrar empleado  || 11.Búsqueda empleado  || 12.Eliminación empleado");
		out.println("13.Ver facturas        || 14.Ordenes de tienda  || 15.Compra producto     ");
		out.println();
		out.println("-----------------------------16.CERRAR SESIÓN-----------------------------");
		out.println();
		
	}

	public static int leerOpcionAdmin() throws Exception {

		int opcion;

		opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

		if (opcion < 0 || opcion > 16) {

			throw new Exception("OPCION INVALIDA");

		}

		return opcion;
	}

	public static void ejecutarAccionAdmin(int pOpcion, Persona admin) throws Exception {

		switch (pOpcion) {

		case 1:
			registrarTienda();
			break;
		case 2:
			buscarListarTienda();
			break;
		case 3:
			// eliminar tienda
			break;
		case 4:
			registrarProducto();
			break;
		case 5:
			buscarListarProducto();
			;
			break;
		case 6:
			// eliminar Producto
			break;
		case 7:
			registrarCliente();
			break;
		case 8:
			buscarListarClientesTienda();
			break;
		case 9:
			// eliminar cliente
			break;
		case 10:
			registrarEmpleado();
			break;
		case 11:
			buscarListarEmpleadosTienda();
			break;
		case 12:
			// eliminar empleado
			break;
		case 13:
			verFacturas();
			break;
		case 14:
			consultarOrdenes(admin);
			break;
		case 15:
			comprarProducto();
			break;

		case 16:
			out.println("Gracias por usar el sistema");
			break;

		default:
			out.println("Opcion invalida");
			throw new Exception("OPCION INVALIDA");
		}
	}

	public static void menuEmpleado() {
		out.println();
		out.println("----------------------------- BIENVENIDO -------------------------------");
		out.println("1. Registrar producto  || 2. Búsqueda producto  || 3. Eliminación producto");
		out.println("4. Registrar cliente   || 5. Búsqueda cliente   || 6. Eliminación cliente ");
		out.println("7. Ver facturas        || 8. Ordenes de tienda  || 9. Comprar producto     ");
		out.println("----------------------------- 10.SALIR -----------------------------------");
		out.println();

	}

	public static int leerOpcionEmpleado() throws Exception {

		int opcion;

		opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

		if (opcion < 0 || opcion > 10) {

			throw new Exception("OPCION INVALIDA");

		}

		return opcion;
	}

	public static void ejecutarAccionEmpleado(int pOpcion, Tienda tiendaUsuario, Persona usuario) throws Exception {

		switch (pOpcion) {

		case 1:
			registrarProducto(tiendaUsuario);
			break;
		case 2:
			buscarListarProducto(tiendaUsuario);
			break;
		case 3:
			// eliminar producto

			break;
		case 4:
			registrarCliente(tiendaUsuario);
			break;
		case 5:
			buscarListarClientesTienda(tiendaUsuario);
			break;
		case 6:
			// eliminacion cliente
			break;
		case 7:
			verFacturasTienda(tiendaUsuario);
			break;
		case 8:
			listarOrdenes(tiendaUsuario, usuario);
			break;

		case 9:
			comprarProducto(tiendaUsuario, usuario);
			break;
		case 10:
			out.println("Gracias por usar el sistema");
			break;

		default:
			out.println("Opcion invalida");
			throw new Exception("OPCION INVALIDA");
		}
	}

	public static void menuCliente() {
		out.println();
		out.println("----------------------------- BIENVENIDO -------------------------------");
		out.println();
		out.println("              1. Compra producto  ||  2. Ver productos                  ");
		out.println("                         3. Ver facturas                   ");
		out.println();
		out.println("-----------------------------  4.SALIR ---------------------------------");

		out.println();
	}

	public static int leerOpcionCliente() throws Exception {

		int opcion;

		opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

		if (opcion < 0 || opcion > 4) {

			throw new Exception("OPCION INVALIDA");

		}

		return opcion;
	}

	public static void ejecutarAccionCliente(int pOpcion, Tienda tiendaUsuario, Persona usuario) throws Exception {

		switch (pOpcion) {

		case 1:
			comprarProducto(tiendaUsuario, usuario);
			break;
		case 2:
			buscarListarProducto(tiendaUsuario);
			break;
		case 3:
			verFacturasUsuario(usuario);
			break;
		case 4:
			out.println("Gracias por usar el sistema");
			break;

		default:
			out.println("Opcion invalida");
			throw new Exception("OPCION INVALIDA");
		}
	}

	public static Persona registrarAdmin() throws IOException {

		String id, nombre, correo, password, telefono;

		nombre = "Enzo Quartino";
		id = "9-0108-0939";
		telefono = "22221111";
		correo = "admin@hotmail.com";
		password = "123";

		Persona administrador = gestorPersona.createAdmin(nombre, id, telefono, correo, password);

		return administrador;

	}

	// ****************** P R O D U C T O S *****************************

	public static void registrarProducto() throws IOException {

		String codigo;
		buscarListarTienda();
		out.println("Escoga tienda a registrar producto");
		codigo = in.readLine();
		Tienda tienda = gestorTienda.searchTiendaByCode(codigo);
		if (tienda == null) {
			out.println("Codigo erroneo");
		} else {

			registrarProducto(tienda);
		}

	}

	public static Producto registrarProducto(Tienda tienda) throws IOException {
		int tipo;
		String nombre, codigo;
		String prod = "";
		out.println("Código del producto ");
		codigo = in.readLine();

		out.println("Tipo del producto: VIDEOJUEGO (1) | DVD (2) | CD (3)");
		tipo = Integer.parseInt(in.readLine());

		if (tipo == 1) {
			prod = "Videojuego";

		}
		if (tipo == 2) {
			prod = "DVD";

		}
		if (tipo == 3) {
			prod = "CD";

		}

		out.println("Nombre del " + prod);
		nombre = in.readLine();

		Producto producto = gestorProducto.addProduct(codigo, nombre, tipo);
		tienda.addProduct(producto);

		return producto;
	}

	public static void buscarListarProducto() throws Exception {
		String codigo;
		buscarListarTienda();
		out.println("Escoger tienda");
		codigo = in.readLine();
		Tienda tienda = gestorTienda.searchTiendaByCode(codigo);
		if (tienda == null) {
			out.println("Codigo erroneo");
		} else {

			buscarListarProducto(tienda);
		}

	}

	public static void buscarListarProducto(Tienda tienda) throws Exception {

		ArrayList<Producto> productos = tienda.getListaProductos();
		if (productos.size() == 0) {
			out.print("No hay productos registrados por el momento");
		} else {

			for (Producto producto : tienda.getListaProductos()) {
				if (producto.getTipo() == "Videojuego") {
					out.println(producto.toString());
				}
				if (producto.getTipo() == "DVD") {
					out.println(producto.toString());
				}
				if (producto.getTipo() == "CD") {
					out.println(producto.toString());
				}

			}

		}

	}

	public static void eliminarProducto(Tienda tienda) throws Exception {
		ArrayList<Producto> productos = tienda.getListaProductos();

		for (Producto elProducto : productos) {
			out.println("Código: " + elProducto.getCodigo() + " Nombre: " + elProducto.getNombre());
		}

		String codigo;
		out.println("Digite el código del producto a eliminar");
		codigo = in.readLine();

		Producto productoBuscado = gestorTienda.searchProductByCode(tienda, codigo);
		if (productoBuscado == null) {
			out.println("Código mal digitado");
		} else {
			out.println(productoBuscado.toString());
		}

		int decision;
		out.println("Seguro que desea eliminar el producto? SI(1) || NO(2)");
		decision = Integer.parseInt(in.readLine());

		if (decision == 1) {
			gestorTienda.deleteProduct(tienda, codigo);
			out.println("Producto eliminado");
		} else {
			out.println("Producto no eliminado");
		}
	}

	// ****************** P R O D U C T O S *****************************

	// ****************** C L I E N T E S *****************************

	public static void registrarCliente() throws IOException {
		String codigo;
		buscarListarTienda();
		out.println("Digite codigo de tienda a registrar cliente");
		codigo = in.readLine();
		Tienda tienda = gestorTienda.searchTiendaByCode(codigo);
		if (tienda == null) {
			out.println("Codigo erroneo");
		} else {
			registrarCliente(tienda);
		}

	}

	public static Persona registrarCliente(Tienda tienda) throws IOException {
		String id, nombre, correo, password, telefono;

		out.println("Identificación del cliente");
		id = in.readLine();

		out.println("Nombre completo del cliente");
		nombre = in.readLine();

		out.println("Teléfono del cliente");
		telefono = in.readLine();

		out.println("Correo electrónico del cliente");
		correo = in.readLine();

		out.println("Contraseña del cliente");
		password = in.readLine();

		Persona cliente = gestorPersona.createCliente(nombre, id, telefono, correo, password);
		gestorTienda.addClienteToTienda(tienda, cliente);

		return cliente;

	}

	// ****************** C L I E N T E S *****************************

	// ****************** E M P L E A D O S *****************************

	public static Persona registrarEmpleado(Tienda tienda) throws IOException {
		String id, nombre, correo, password, telefono;

		out.println("Identificación del empleado");
		id = in.readLine();

		out.println("Nombre del empleado");
		nombre = in.readLine();

		out.println("Teléfono del empleado");
		telefono = in.readLine();

		out.println("Correo electrónico del empleado");
		correo = in.readLine();

		out.println("Contraseña del empleado");
		password = in.readLine();

		Persona empleado = gestorPersona.createEmpleado(nombre, id, telefono, correo, password);
		gestorTienda.addEmpleadoToTienda(tienda, empleado);

		return empleado;
	}

	public static void registrarEmpleado() throws IOException {

		String codigo;
		buscarListarTienda();
		out.println("Escoga tienda a registrar empleado");
		codigo = in.readLine();
		Tienda tienda = gestorTienda.searchTiendaByCode(codigo);
		if (tienda == null) {
			out.println("Codigo erroneo");
		} else {
			registrarEmpleado(tienda);
		}

	}

	// ****************** E M P L E A D O S *****************************

	// ****************** T I E N D A S *****************************

	public static void registrarTienda() throws IOException {

		String codigo, nombre, direccion, telefono;

		out.println("Cóigo de tienda");
		codigo = in.readLine();
		out.println("Nombre de tienda");
		nombre = in.readLine();
		out.println("Dirección de tienda");
		direccion = in.readLine();
		out.println("Teléfono de tienda");
		telefono = in.readLine();

		Tienda tienda = gestorTienda.addTienda(codigo, nombre, direccion, telefono);

		int decision1, decision2, decision3;

		do {
			out.println("Desea agregar un producto? SI(1) NO(2)");
			decision1 = Integer.parseInt(in.readLine());
			if (decision1 == 1) {
				Producto producto = registrarProducto(tienda);
				gestorTienda.addProductToTienda(tienda, producto);
			}

		} while (decision1 != 2);

		do {
			out.println("Desea agregar un empleado? SI(1) NO(2)");
			decision2 = Integer.parseInt(in.readLine());
			if (decision2 == 1) {
				Persona empleado = registrarEmpleado(tienda);
				gestorTienda.addClienteToTienda(tienda, empleado);
			}

		} while (decision2 != 2);

		do {
			out.println("Desea agregar un cliente? SI(1) NO(2)");
			decision3 = Integer.parseInt(in.readLine());
			if (decision3 == 1) {
				Persona cliente = registrarCliente(tienda);
				gestorTienda.addClienteToTienda(tienda, cliente);
			}

		} while (decision3 != 2);

	}

	public static void buscarListarTienda() throws IOException {
		out.println("hola");
		ArrayList<Tienda> tiendas = gestorTienda.getListaTiendas();
		if (tiendas.size() == 0) {
			out.print("No hay tiendas registradas por el momento");

		} else {
			for (Tienda laTienda : tiendas) {
				out.println(laTienda.toString());
			}
		}
	}

	public static void buscarListarClientesTienda() throws IOException {
		String codigo;
		buscarListarTienda();
		out.println("**Digite el código de la tienda a consultar clientes ***");
		codigo = in.readLine();

		Tienda tienda = gestorTienda.searchTiendaByCode(codigo);
		if (tienda == null) {
			out.println("Codigo mal digitado");
		} else {

			buscarListarClientesTienda(tienda);

		}
	}

	public static void buscarListarClientesTienda(Tienda tienda) throws IOException {

		out.println("***CLIENTES DE TIENDA " + tienda.getNombre() + "***");

		for (Persona cliente : tienda.getListaClientes()) {
			if (cliente.getRol() == 3) {
				out.println(cliente.toString());
			}
		}

	}

	public static void buscarListarEmpleadosTienda() throws IOException {

		String codigo;
		buscarListarTienda();
		out.println("**Digite el código de la tienda a consultar empleados***");
		codigo = in.readLine();

		Tienda tienda = gestorTienda.searchTiendaByCode(codigo);
		if (tienda == null) {
			out.println("Codigo mal digitado");
		} else {
			buscarListarEmpleadosTienda(tienda);
		}
	}

	public static void buscarListarEmpleadosTienda(Tienda tienda) throws IOException {

		out.println("***EMPLEADOS DE TIENDA " + tienda.getNombre() + "***");

		for (Persona empleado : tienda.getListaClientes()) {
			if (empleado.getRol() == 2) {
				out.println(empleado.toString());
			}
		}

	}

	public static void comprarProducto() throws IOException {
		String codigo;
		int decision;
		buscarListarTienda();

		out.println("Escoga tienda a ver productos");
		codigo = in.readLine();
		Tienda tienda = gestorTienda.searchTiendaByCode(codigo);
		if (tienda == null) {
			out.println("Codigo erroneo");
		} else {
			do {
				out.println("");
				out.println("Desea comprar un producto? SI(1) NO(2)");
				decision = Integer.parseInt(in.readLine());
				if (decision == 1) {
					out.println("Digite el codigo del producto a comprar");
					// enviar codigo
				}

			} while (decision != 2);
		}

	}

	public static void comprarProducto(Tienda tienda, Persona usuario) throws Exception {
		String codigo1, codigo2;
		int decision;
		ArrayList<Producto> productosComprar = new ArrayList<>();

		buscarListarProducto(tienda);

		out.println("**Digite el codigo del producto a comprar**");
		codigo1 = in.readLine();
		Producto producto1 = gestorTienda.searchProductByCode(tienda, codigo1);
		String metodoPago;

		if (producto1 == null) {
			out.println("Codigo erroneo");
		} else {
			productosComprar.add(producto1);
			do {
				out.println("Desea comprar otro producto? SI(1) NO(2)");
				decision = Integer.parseInt(in.readLine());
				if (decision == 1) {
					buscarListarProducto(tienda);
					out.println("**Digite el codigo del producto a comprar**");
					codigo2 = in.readLine();
					Producto producto2 = gestorTienda.searchProductByCode(tienda, codigo2);
					if (producto2 == null) {
						out.println("Codigo erroneo");
					} else {
						productosComprar.add(producto2);

					}
				}

			} while (decision != 2);

			metodoPago = consultarMetodoPago();

			Orden orden = gestorTienda.createOrden(tienda, usuario, productosComprar, metodoPago);
			out.println(orden.getCodigo());
		}

	}

	public static void consultarOrdenes(Persona admin) throws IOException {
		String codigo;
		buscarListarTienda();
		out.println("Digite codigo de tienda a consultar ordenes");
		codigo = in.readLine();
		Tienda tienda = gestorTienda.searchTiendaByCode(codigo);
		if (tienda == null) {
			out.println("Codigo erroneo");
		} else {
			listarOrdenes(tienda, admin);
		}
	}

	public static void listarOrdenes(Tienda tienda, Persona usuario) throws IOException {

		int decision, codigo;
		out.println("APROBADAS (1) || RECHAZADAS(2) || EN PROCESO(3)");
		decision = Integer.parseInt(in.readLine());

		if (decision == 1) {
			for (Orden orden : tienda.getListaOrdenes()) {

				if (orden.getEstado().equals("APROBADA")) {
					out.println("Orden # " + orden.getCodigo() + " Metodo de pago: " + orden.getMetodoPago());
				}
			}
		}
		if (decision == 2) {
			for (Orden orden : tienda.getListaOrdenes()) {

				if (orden.getEstado().equals("RECHAZADA")) {
					out.println("Orden # " + orden.getCodigo() + " Metodo de pago: " + orden.getMetodoPago());
				}
			}
		}
		if (decision == 3) {
			for (Orden orden : tienda.getListaOrdenes()) {

				if (orden.getEstado().equals("EN PROCESO")) {
					out.println("Orden # " + orden.getCodigo() + " Metodo de pago: " + orden.getMetodoPago());
				}
			}

			out.println("Digite el codigo de la orden a modificar");
			codigo = Integer.parseInt(in.readLine());

			Orden orden = gestorTienda.searchOrden(tienda, codigo);
			if (orden == null) {
				out.println("Codigo erroneo");
			} else {
				out.println("APROBAR(1) ó RECHAZAR(2) ORDEN # " + codigo);
				decision = Integer.parseInt(in.readLine());
				if (decision == 1) {
					gestorTienda.acceptOrden(tienda, orden, usuario);
				} else {
					gestorTienda.denyOrden(tienda, orden, usuario);
				}
			}
		}

	}
	// ****************** T I E N D A S *****************************

	public static String consultarMetodoPago() throws NumberFormatException, IOException {
		int decisionPago;
		out.println("DESEA PAGAR EN EFECTIVO(1) ó CON TARJETA(2)");
		decisionPago = Integer.parseInt(in.readLine());
		if (decisionPago == 1) {
			return "EFECTIVO";
		} else {
			return "TARJETA";
		}
	}

	public static void verFacturas() throws IOException {
		String codigo;
		buscarListarTienda();

		out.println("Escoga tienda a ver facturas");
		codigo = in.readLine();
		Tienda tienda = gestorTienda.searchTiendaByCode(codigo);
		if (tienda == null) {
			out.println("Codigo erroneo");
		} else {
			verFacturasTienda(tienda);
		}
	}

	public static void verFacturasTienda(Tienda tienda) {
		for (Factura factura : tienda.getListaFacturas()) {
			out.println(factura.toString() + "\n");
		}
	}

	public static void verFacturasUsuario(Persona pCliente) {
		Tienda tienda = gestorTienda.searchTiendaByClient(pCliente);
		for (Factura factura : tienda.getListaFacturas()) {
			out.println(factura.toString() + "\n");
		}

	}

	public static void init() throws IOException {
		String codigo, nombre, direccion, telefono;

		codigo = "T-101";

		nombre = "ESCAZU";

		direccion = "CENTRO";

		telefono = "25522221";

		Tienda tienda = gestorTienda.addTienda(codigo, nombre, direccion, telefono);

		Producto producto = gestorProducto.addProduct("P-789", "FIFA17", 1);
		Producto producto2 = gestorProducto.addProduct("P-790", "FIFA18", 1);
		Producto producto3 = gestorProducto.addProduct("P-791", "FIFA19", 1);

		gestorTienda.addProductToTienda(tienda, producto);
		gestorTienda.addProductToTienda(tienda, producto2);
		gestorTienda.addProductToTienda(tienda, producto3);

		Persona empleado = gestorPersona.createEmpleado("Enzo", "789456", "78987", "enzoqz@mail.com", "123");
		Persona empleado2 = gestorPersona.createEmpleado("Adrian", "789457", "78988", "adrianqz@mail.com", "123");

		gestorTienda.addClienteToTienda(tienda, empleado);
		gestorTienda.addClienteToTienda(tienda, empleado2);

		Persona cliente = gestorPersona.createCliente("Victor", "215468", "22225555", "victoy@mail.com", "123");
		Persona cliente2 = gestorPersona.createCliente("Alonso", "7454451", "55552222", "alonso@mail.com", "123");
		gestorTienda.addClienteToTienda(tienda, cliente);
		gestorTienda.addClienteToTienda(tienda, cliente2);

		ArrayList<Producto> p = new ArrayList<>();
		p.add(producto3);
		p.add(producto2);

		gestorTienda.createOrden(tienda, cliente, p, "EFECTIVO");

	}

}
