package org.iesalandalus.programacion.agenda.modelo;

public class Contacto {

	private static final String ER_TELEFONO = ("^[9,6]{1}[0-9]{8}$");
	private static final String ER_CORREO = ("\\w+[.*\\w]+@+[a-zA-Z]+\\.\\w{1,5}");

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
			} else {
				throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
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
			} else {
				throw new IllegalArgumentException("El correo no tiene un formato válido.");
			}
		}
	}

	/* Otros Metodos */
	private String getIniciales(String nombre) {
		String unEspacio = nombre.replaceAll("\\s+", " ");
		String iniciales = "";
		String separacion[] = unEspacio.split(" ");
		for (int i = 0; i < separacion.length ; i++) {
			iniciales += separacion[i].charAt(0);
		}
		return iniciales.toUpperCase();
	}

	@Override
	public String toString() {
		return getIniciales(nombre)+" ["+telefono+", "+correo+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}

}
