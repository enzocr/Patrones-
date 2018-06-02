package objetos;

/**
 *
 * @author enzoq
 */
public class Persona {

	protected String nombre_completo;
	protected String identificacion;
	protected String telefono;
	protected String email;
	protected String clave;
	protected int rol;

	public Persona() {

	}

	public Persona(String nombre_completo, String identificacion, String telefono, String email, String clave,
			int rol) {

		this.nombre_completo = nombre_completo;
		this.identificacion = identificacion;
		this.telefono = telefono;
		this.email = email;
		this.clave = clave;
		this.rol = rol;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return nombre_completo + " || " + identificacion + " || " + telefono + " || " + email + " || " + rol +"\n";
	}

}
