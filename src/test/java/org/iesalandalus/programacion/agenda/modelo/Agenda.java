package org.iesalandalus.programacion.agenda.modelo;

import java.util.Arrays;

import javax.naming.OperationNotSupportedException;

public class Agenda {

	private static final int MAX_CONTACTOS = 99;
	private int numContactos;
	private Contacto[] contactos; // Array creado por la flecha del diagrama de clases

	/* Constructores */
	public Agenda() {
		contactos = new Contacto[MAX_CONTACTOS];
	}

	/* Metodos get */
	public Contacto[] getContactos() {
		Contacto[] copiaContactos = Arrays.copyOf(contactos, contactos.length);
		return copiaContactos;
	}

	public int getNumContactos() {
		for (int i = 0; i < contactos.length - 1; i++) {
			if (contactos[i] != null) {
				numContactos += 1;
			}
		}
		return numContactos;
	}

	/* Otros metodos */
	public void anadir(Contacto contacto) throws OperationNotSupportedException {
		try {
			if (indiceNoSuperaTamaño(buscarPrimerIndiceComprobandoExistencia(contacto))) {
				contactos[buscarPrimerIndiceComprobandoExistencia(contacto)] = contacto;
			}
		} catch (OperationNotSupportedException e) {
			//Se que esta linea esta repetida pero por algun motivo no me detectaba la Excepcion.
			throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
		}
	}

	private int buscarPrimerIndiceComprobandoExistencia(Contacto existencia) throws OperationNotSupportedException {
		int indiceVacio = 0;
		if (contactos[contactos.length - 1] != null) {
			throw new OperationNotSupportedException("La agenda esta llena.");
		}
		for (int i = 0; i < contactos.length - 1; i++) {
			if (contactos[i] != null) {
				if (contactos[i].equals(existencia)) {
					throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
				}
			} else {
				indiceVacio = i;
			}
		}
		return indiceVacio;
	}

	private boolean indiceNoSuperaTamaño(int indice) {
		if (indice < contactos.length - 1) {
			return true;
		} else {
			return false;
		}
	}

}
