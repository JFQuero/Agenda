package org.iesalandalus.programacion.agenda.modelo;

import java.util.Arrays;

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
		for (int i = 0; 0 < contactos.length; i++) {
			if (contactos[i] != null) {
				numContactos++;
			}
		}
		return numContactos;
	}

}
