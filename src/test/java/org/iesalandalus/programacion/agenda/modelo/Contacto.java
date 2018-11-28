package org.iesalandalus.programacion.agenda.modelo;

public class Contacto {

	private static final String ER_TELEFONO = ("[9]{1}[0-9]{8}");
	private static final String ER_CORREO = ("\\w+[.*\\w]+@+\\w+.\\w{2,5}");

	private String nombre;
	private String telefono;
	private String correo;

	/* Constructores */
	public Contacto(String nombre, String telefono, String correo) {
			setNombre(nombre);
			setTelefono(telefono);
			setCorreo(correo);
		}
	
	/* Metodos para nombre */
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (this.nombre != null) {
			throw new IllegalArgumentException("No se puede cambiar el nombre de un Contacto existente");
		} else {
			if (nombre == null | nombre == "") {
				throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");
			} else {
				this.nombre = nombre;
			}
		}
	}

	/* Metodos para telefono */
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null | telefono == "") {
			throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
		} else {
			if (telefono.matches(ER_TELEFONO)) {
				this.telefono = telefono;
			}
		}
	}

	/* Metodos para correo */
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		if (correo == null | correo == "") {
			throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
		} else {
			if (correo.matches(ER_CORREO)) {
				this.correo = correo;
			}
		}
	}
}
