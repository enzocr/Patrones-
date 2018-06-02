package objetos;

public class Producto {

	protected String codigo;
	protected String nombre;
	protected String tipo;
	protected double precio;

	public Producto() {

	}

	public Producto(String codigo, String nombre, String tipo, double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return codigo + " || " + nombre + " || " + tipo + " || " + precio + " colones \n";
	}

}
