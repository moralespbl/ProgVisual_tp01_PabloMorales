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
		
		
		
		}while(opcion!=8);
		sc.close();
	}
	/**
	 * se agregan objetos al array de jugadores
	 */
	public static void agregarJugador() {
		sc.nextLine();
		boolean bandera;
		Jugador jugador = new Jugador();
		do {
			bandera=true;	
			
			System.out.println("\nIngrese el apellido:");
	        String apellido = sc.nextLine();
	        System.out.println("Ingrese el nombre:");
		    String nombre = sc.nextLine();
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
		sc.nextLine();
		System.out.println("\nIngrese el apellido:");
        String apellido = sc.nextLine();
        System.out.println("Ingrese el nombre:");
	    String nombre = sc.nextLine();
	    if(buscarJugador(nombre, apellido) != null) {
	    	System.out.println(buscarJugador(nombre, apellido).toString());
	    }
	    else System.out.println("No existe Jugador para mostrar");
	}
	
	public static void modificarJugador() {
		sc.nextLine();
		int i;
		int opcion=0;
		boolean bandera = true;
		System.out.println("\nIngrese el apellido:");
		String apellido = sc.nextLine();
        System.out.println("Ingrese el nombre:");
	    String nombre = sc.nextLine();
	    if(buscarJugador(nombre, apellido) != null) {
	    	i=jugadores.indexOf(buscarJugador(nombre, apellido));
	    	System.out.println("Jugador a modificar:");
	    	System.out.println("Que dato desea modificar?:");
	    	System.out.println("1 - Nombre "+ jugadores.get(i).getNombre());
	    	System.out.println("2 - Apellido "+ jugadores.get(i).getApellido());
	    	System.out.println("3 - fechaNacimiento "+ jugadores.get(i).getFechaNacimiento());
	    	System.out.println("4 - Nacionalidad "+ jugadores.get(i).getNacionalidad());
	    	System.out.println("5 - Estatura "+ jugadores.get(i).getEstatura());
	    	System.out.println("6 - Peso "+ jugadores.get(i).getPeso());
	    	System.out.println("7 - Poscion: "+ jugadores.get(i).getPosicion());
	    	System.out.println("Ingrese opcion");
	    	do {
	    		bandera = true;
		    	try {
		    		opcion = sc.nextInt();
		    	} catch(InputMismatchException e) {
		    		System.out.println("La estatura no es valida");
		        	bandera = false;
		    	}
	
		    	sc.nextLine();	
	    	}while(bandera == false && opcion<1 && opcion>7);
	    	switch(opcion){
	    	case 1: 
		    	do {
		    		bandera = true;
		    		try {
			    		System.out.println("\nIngrese el apellido:");
			    		jugadores.get(i).setApellido(sc.nextLine());
		    		} catch(InputMismatchException e) {
		    			System.out.println("Erro ingrese de nuevo:");
		    		}
		    		sc.nextLine();
		    	} while(bandera == false);
	    		break;	    		
	    	case 2:
	    		do {
	    			bandera = true;
		    		try {
			    		System.out.println("\nIngrese el nombre:");
			    		jugadores.get(i).setApellido(sc.nextLine());
		    		} catch(InputMismatchException e) {
		    			System.out.println("Erro ingrese de nuevo:");
		    		}
		    		sc.nextLine();
	    		} while(bandera == false);
	    		break;
	    	case 3:
	    		do {
	    			bandera = true;
	    		try {
			        System.out.println("Ingrese la fecha de nacimiento (AAAA-MM-DD):");
			        jugadores.get(i).setFechaNacimiento(LocalDate.parse(sc.next()));
		        } catch (DateTimeParseException e) {
		        	System.out.println("La fecha no es valida");
		        	bandera = false;
		        }
	    		sc.nextLine(); 
	    		} while(bandera == false);
	    	case 4:
	    		do {
	    			bandera = true;
	    		try {
			        System.out.println("Ingrese la nacionalidad:");
			        jugadores.get(i).setNacionalidad(sc.next());
		        } catch (InputMismatchException e) {
		        	System.out.println("La fecha no es valida");
		        	bandera = false;
		        }
	    		sc.nextLine(); 
	    	} while(bandera == false);
	    		break;
	    	case 5:
	    		do {
	    			bandera = true;
	    		 try {
				        System.out.println("Ingrese la estatura:");
				        jugadores.get(i).setEstatura(sc.nextFloat());
				        
			        } catch (InputMismatchException e ) {
			        	System.out.println("La estatura no es valida");
			        	bandera = false;
					}
	    		 sc.nextLine(); 
	    		} while(bandera == false);
	    		 break;
	    	case 6:
	    		do {
	    			bandera = true;
	    		try {
			        System.out.println("Ingrese el peso:");
			        jugadores.get(i).setPeso(sc.nextFloat());
			        
		        } catch (InputMismatchException e ) {
		        	System.out.println("El peso no es valido");
		        	bandera = false;
				}
	    		sc.nextLine(); 
	    	} while(bandera == false);
	    		break;
	    	case 7:
	    		do {
	    			bandera = true;
	    		try {
			        System.out.println("Ingrese la posición:");
			        jugadores.get(i).setPosicion(sc.nextLine());
			     
		        } catch (InputMismatchException e ) {
		        	System.out.println("La posicion no es valida");
		        	bandera = false;
				}	
	    		sc.nextLine(); 
	    		} while(bandera == false);
	    		break;
	    	default: 
	    		System.out.println("Opcion incorrecta, ingrese nuevamente");
	    		break;
	    	}
	    }
	    else System.out.println("No existe Jugador para modificar");
	}
	
	public static void eliminarJugador() {
		sc.nextLine();
		int i;
		System.out.println("\nIngrese el apellido:");
        String apellido = sc.next();
        System.out.println("Ingrese el nombre:");
	    String nombre = sc.next();
	    buscarJugador(nombre, apellido); 
	    if(buscarJugador(nombre, apellido) != null) {
	    	i=jugadores.indexOf(buscarJugador(nombre, apellido));
	    	jugadores.remove(i);
	    	System.out.println("Jugador a eliminado:");
	    }
	    else System.out.println("No existe Jugador para modificar");
	}
}
	