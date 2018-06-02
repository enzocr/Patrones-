
package gestores;

import java.util.ArrayList;

import objetos.Producto;

public class ProductoGestor {

	protected ArrayList<Producto> listaProductos;

	public ProductoGestor() {
		this.listaProductos = new ArrayList<>();
	}

	public ProductoGestor(ArrayList<Producto> listaProductos) {
		this.listaProductos = new ArrayList<>();
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public Producto addProduct(String codigo, String nombre, int decision) {
		String tipo = "";
		double precio = 0.0;
		Producto producto;
		if (decision == 1) {
			tipo = "Videojuego";
			precio = 5000.0;
		}
		if (decision == 2) {
			tipo = "DVD";
			precio = 2500.0;
		}
		if (decision == 3) {
			tipo = "CD";
			precio = 3000.0;
		}

		producto = new Producto(codigo, nombre, tipo, precio);
		listaProductos.add(producto);

		return producto;

	}

}
