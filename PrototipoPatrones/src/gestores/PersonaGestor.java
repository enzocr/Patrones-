package gestores;

import objetos.Persona;

import java.util.ArrayList;

public class PersonaGestor {

	protected ArrayList<Persona> listaUsuarios;

	public PersonaGestor() {
		this.listaUsuarios = new ArrayList<>();
	}

	public PersonaGestor(ArrayList<Persona> listaUsuarios) {
		this.listaUsuarios = new ArrayList<>();
	}

	public ArrayList<Persona> getListaUsuarios() {
		return listaUsuarios;
	}
	

	public Persona createAdmin(String nombre, String identificacion, String telefono, String correo, String clave) {
		Persona administrador = new Persona(nombre, identificacion, telefono, correo, clave, 1);
		listaUsuarios.add(administrador);
		return administrador;
	}

	public Persona createEmpleado(String nombre, String identificacion, String telefono, String correo, String clave) {
		Persona empleado = new Persona(nombre, identificacion, telefono, correo, clave, 2);
		listaUsuarios.add(empleado);
		return empleado;
	}
	
	public Persona createCliente(String nombre, String identificacion, String telefono, String correo, String clave) {
		Persona cliente = new Persona(nombre, identificacion, telefono, correo, clave, 3);
		listaUsuarios.add(cliente);
		return cliente;
		
	}

	public Persona searchUserByEmail(String correo) {
		Persona encontrada = null;
		for(Persona persona : listaUsuarios) {
			if(persona.getEmail().equals(correo)) {
				encontrada = persona;
			}
		}
		return encontrada;
		
	}
	
	
	
	
}
