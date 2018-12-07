package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.agenda.modelo.*;

public class MainApp {

	private static final String ERROR = "Operacion fallida, regresando al menu.";
	private static final String EXITO = "Operacion realizada satisfactoriamente.";
	private static Agenda agenda = new Agenda();

	public static void main(String[] args) {
		System.out.println("Programa para gestionar una agenda de contactos por Juan Fernandez Quero");
		mostrarMenu();
	}

	/* MENU INICIAL Y EJECUCION */
	private static void mostrarMenu() {
		System.out.println("- - - - - - - - - - MENU - - - - - - - - - -");
		System.out.println("1 - Añadir un contacto.");
		System.out.println("2 - Buscar un contacto.");
		System.out.println("3 - Borrar un contacto.");
		System.out.println("4 - Ver todos los contactos.");
		System.out.println("5 - Salir.");
		ejecutarOpcion(elegirOpcion());
	}

	private static int elegirOpcion() {
		int opcion;
		System.out.println("¿Que quieres hacer?");
		do {
			System.out.println("[Introduce una opcion valida]");
			opcion = Entrada.entero();
		} while (opcion < 1 | opcion > 5);
		return opcion;
	}

	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			anadirContacto();
			mostrarMenu();
			break;
		case 2:
			buscarContacto();
			mostrarMenu();
			break;
		case 3:
			borrarContacto();
			mostrarMenu();
			break;
		case 4:
			listarAgenda();
			mostrarMenu();
			break;
		case 5:
			System.out.println("¡Adios!");
			System.exit(0);
			break;
		}
	}

	/* GESTION DE CONTACTOS */
	private static void anadirContacto() {
		String nombre;
		String numero;
		String correo;
		System.out.println("Nombre y Apellido del nuevo contacto:");
		nombre = Entrada.cadena();
		System.out.println("Numero de telefono del nuevo contacto:");
		numero = Entrada.cadena();
		System.out.println("Correo electronico del nuevo contacto:");
		correo = Entrada.cadena();
		try {
			Contacto contacto = new Contacto(nombre, numero, correo);
			agenda.anadir(contacto);
			System.out.println(EXITO);
		} catch (Exception e) {
			System.out.println(ERROR);
			System.out.println(e.getMessage());
		}
	}

	private static void buscarContacto() {
		String busqueda;
		System.out.println("Nombre y Apellido del contacto que desea buscar:");
		busqueda = Entrada.cadena();
		agenda.buscar(busqueda);
	}

	private static void borrarContacto() {
		String borrado;
		System.out.println("Nombre y Apellido del contacto que desea borrar:");
		borrado = Entrada.cadena();
		try {
			agenda.borrar(borrado);
			System.out.println(EXITO);
		} catch (Exception e) {
			System.out.println(ERROR);
			System.out.println(e.getMessage());
		}

	}

	/* VISUALIZACION DE LA AGENDA */
	private static void listarAgenda() {
		Contacto[] lista = agenda.getContactos();
		System.out.println("Mostrando contactos almacenados en la Agenda:");
		for (int i = 0; i < lista.length -1; i++) {
			if (lista[i] != null) {
				System.out.println("Contacto numero "+(i+1)+": "+lista[i]);
			}
		}
		

	}
}
