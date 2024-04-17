package ar.edu.unju.fi.ejercicio17.main;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import ar.edu.unju.fi.ejercicio17.model.Jugador;
public class Main {
	public static Scanner sc = new Scanner(System.in);
	private static List<Jugador> jugadores;
	
	public static void main(String[] args) {
		// Ejercicio 17
		int opcion;
		jugadores = new ArrayList<>(); 
		do {
			System.out.println("===================================================================");
			System.out.println("1 - Alta de jugador");
			System.out.println("2 – Mostrar los datos del jugador (debe ingresar el nombre y el apellido)");
			System.out.println("3 – Mostrar todos los jugadores ordenados por apellido.");
			System.out.println("4 – Modificar los datos de un jugador (debe ingresar el nombre y el apellido del\r\n"
					+ "jugador)");
			System.out.println("5 – Eliminar un jugador (el usuario debe ingresar el nombre y apellido.");
			System.out.println("6 – Mostrar la cantidad total de jugadores.");
			System.out.println("7 – Mostrar la cantidad de jugadores que pertenecen a una nacionalidad (ingresa la\r\n"
					+ "nacionalidad).");
			System.out.println("8 – Salir.");
			System.out.println("===================================================================");
			System.out.println("Ingrese una opcion:");
			opcion= sc.nextInt();
		
		switch(opcion) {
		case 1:	
			System.out.println("===================================================================");
			agregarJugador();		
			System.out.println("Se agrego el objeto jugador");
			break;
		case 2:
			System.out.println("===================================================================");
			mostrarJugador();
			break;
		case 3:
			jugadores.sort(Comparator.comparing(Jugador::getApellido));
			jugadores.forEach(j->System.out.println(j));
			break;
		case 4:
			modificarJugador();
			System.out.println("Se ha modificado el jugador");
			break;
		case 5:
			eliminarJugador();
			System.out.println("Se ha eliminado el jugador");
			break;
		case 6:
			System.out.println("La cantidad total de jugadores es: "+jugadores.size());
			break;
		case 7:
			int suma=0;
			System.out.println("Ingrese nacionalidad:");
			String nacionalidad = sc.next();
			for(Jugador jugador: jugadores) {
				if(jugador.getNacionalidad().equals(nacionalidad)) {
					suma++;
				}
			}
			System.out.println("El total de jugadores por nacionalidad es: "+suma);
			break;
		case 8:
			break;
		default:
				 System.out.println("Opción incorrecta");
				 break;		 	
		}
		
		// probabilidad. muestreo descri`tiva 1.2300 lunes 29 mart30 
		
		
		}while(opcion!=8);
	}
	/**
	 * se agregan objetos al array de jugadores
	 */
	public static void agregarJugador() {
		boolean bandera;
		Jugador jugador = new Jugador();
		do {
			bandera=true;			
			System.out.println("\nIngrese el apellido:");
	        String apellido = sc.next();
	        System.out.println("Ingrese el nombre:");
		    String nombre = sc.next();
		    buscarJugador(nombre, apellido); 
		    if(buscarJugador(nombre, apellido) != null) {
		    	System.out.println("Jugador Existente");
		    	System.out.println("Ingrese otro jugador");
		    	bandera = false;
		    }
		    else {
		    	jugador.setApellido(apellido);
		    	jugador.setNombre(nombre);
		        LocalDate fechaNacimiento = null;
		        try {
			        System.out.println("Ingrese la fecha de nacimiento (AAAA-MM-DD):");
			        jugador.setFechaNacimiento(LocalDate.parse(sc.next()));
		        } catch (DateTimeParseException e) {
		        	System.out.println("La fecha no es valida");
		        	bandera = false;
		        }
		        try {
			        System.out.println("Ingrese la nacionalidad:");
			        jugador.setNacionalidad(sc.next());
		        } catch (InputMismatchException e) {
		        	System.out.println("La fecha no es valida");
		        	bandera = false;
				}
		        try {
			        System.out.println("Ingrese la estatura:");
			        jugador.setEstatura(sc.nextFloat());
			        sc.nextLine(); 
		        } catch (InputMismatchException e ) {
		        	System.out.println("La estatura no es valida");
		        	bandera = false;
				}
		        try {
			        System.out.println("Ingrese el peso:");
			       	jugador.setPeso(sc.nextFloat());
			        sc.nextLine(); 
		        } catch (InputMismatchException e ) {
		        	System.out.println("El peso no es valido");
		        	bandera = false;
				}
		        try {
			        System.out.println("Ingrese la posición:");
			        jugador.setPosicion(sc.nextLine());
			        sc.nextLine(); 
		        } catch (InputMismatchException e ) {
		        	System.out.println("La posicion no es valida");
		        	bandera = false;
				}	             		    
		    }
		} while (bandera == false);
		jugadores.add(jugador);
		
	    
	}
	
	public static void mostrarJugadores() {
		System.out.println("---- Lista de Jugadores ----");
		jugadores.forEach(j->System.out.println(j));
	}
	
	public static Jugador buscarJugador(String nombre, String apellido) {
		Jugador jugadorEncontrado = null;
		for(Jugador jugador: jugadores) {
			if(jugador.getApellido().equals(apellido) && jugador.getNombre().equals(nombre)) {
				jugadorEncontrado = jugador;
			}
		}
		return jugadorEncontrado;
		
	}

	public static void mostrarJugador() {
		System.out.println("\nIngrese el apellido:");
        String apellido = sc.next();
        System.out.println("Ingrese el nombre:");
	    String nombre = sc.next();
	    buscarJugador(nombre, apellido); 
	    if(buscarJugador(nombre, apellido) != null) {
	    	buscarJugador(nombre, apellido).toString();
	    }
	    else System.out.println("No existe Jugador para mostrar");
	}
	
	public static void modificarJugador() {
		int i;
		System.out.println("\nIngrese el apellido:");
        String apellido = sc.next();
        System.out.println("Ingrese el nombre:");
	    String nombre = sc.next();
	    buscarJugador(nombre, apellido); 
	    if(buscarJugador(nombre, apellido) != null) {
	    	i=jugadores.indexOf(buscarJugador(nombre, apellido));
	    	System.out.println("Jugador a modificar:");
	    	buscarJugador(nombre, apellido).toString();
	    	jugadores.remove(i);
	    	agregarJugador();
	    }
	    else System.out.println("No existe Jugador para modificar");
	}
	
	public static void eliminarJugador() {
		int i;
		System.out.println("\nIngrese el apellido:");
        String apellido = sc.next();
        System.out.println("Ingrese el nombre:");
	    String nombre = sc.next();
	    buscarJugador(nombre, apellido); 
	    if(buscarJugador(nombre, apellido) != null) {
	    	i=jugadores.indexOf(buscarJugador(nombre, apellido));
	    	System.out.println("Jugador a modificar:");
	    	buscarJugador(nombre, apellido).toString();
	    	jugadores.remove(i);
	    	agregarJugador();
	    }
	    else System.out.println("No existe Jugador para modificar");
	}
}
	