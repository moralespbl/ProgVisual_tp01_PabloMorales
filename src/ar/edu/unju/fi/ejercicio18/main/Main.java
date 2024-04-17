package ar.edu.unju.fi.ejercicio18.main;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	private static List<Pais> paises;
	private static List<DestinoTuristico> destinos;	//declaro la variable llamada destinos
	
	public static void main(String[] args) {
		// Ejercicio 18
		preCargaPaises();
		destinos = new ArrayList<>();
		int opcion=0;
		do {
			System.out.println("===================================================================");
			System.out.println("1 – Alta de destino turístico.");
			System.out.println("2 – Mostrar todos los destinos turísticos.");
			System.out.println("3 – Modificar el país de un destino turístico.");
			System.out.println("4 – Limpiar el ArrayList de destino turísticos.");
			System.out.println("5 – Eliminar un destino turístico (ingresar el código del destino turístico.");
			System.out.println("6 – Mostrar los destinos turísticos ordenados por nombre.");
			System.out.println("7 – Mostrar todos los países.");
			System.out.println("8 – Mostrar los destinos turísticos que pertenecen a un país (ingresa el código de país).");
			System.out.println("9 – Salir.");
			System.out.println("===================================================================");
			System.out.println("Ingrese una opcion:");
			opcion= sc.nextInt();
			switch(opcion) {
			case 1: altaDestinoTuristico();break;
			case 2: mostrarDestinos();break;
			case 3: modificarDestino(); break;
			case 4: limpiarDestinos(); break;
			case 5: break;
			case 6: break;
			case 7: break;
			case 8: break;
			case 9: break;
				default: break;
					
				
			}
		}while(opcion != 9);
		
		
	}
	
	public static void preCargaPaises() {
		if (paises == null ) {
			paises = new ArrayList<>();
		}
		paises.add(new Pais(1,"Argentina"));
		paises.add(new Pais(2,"Bolivia"));
		paises.add(new Pais(3,"Brasil"));
		paises.add(new Pais(4,"Chile"));
		paises.add(new Pais(5,"Colombia"));
		paises.add(new Pais(6,"Ecuador"));
		paises.add(new Pais(7,"Paraguay"));
		paises.add(new Pais(8,"Peru"));
		paises.add(new Pais(9,"Uruguay"));
		paises.add(new Pais(10,"Venezuela"));
	}
	
	public static void altaDestinoTuristico() {
		Pais pais = new Pais();
		
		int codigo = 0;
		String destinoBuscado=null;
		validarIngresoDestino(codigo, destinoBuscado);
		DestinoTuristico destinoTuristico = new DestinoTuristico();
		destinoTuristico = buscarDestino(codigo,destinoBuscado);
		if(destinoTuristico == null) {
			DestinoTuristico destinoNuevo = new DestinoTuristico();
			destinoNuevo.setCodigo(codigo);
	        destinoNuevo.setNombre(destinoBuscado);
	        System.out.println("Ingrese Precio: ");
	        destinoNuevo.setPrecio(sc.nextDouble());
	        System.out.println("Nuevo destino ingresado ");	     
			if( buscarPais(codigo) == null) {
				System.out.println("Pais inexistente: ");
				agregarPais(codigo);				
			}
			pais=buscarPais(codigo);
			destinoNuevo.setPais(pais);
			System.out.println("Ingrese Cantidad de dias: ");
	        destinoNuevo.setCantidadDias(sc.nextInt());
	        sc.nextLine();
			destinos.add(destinoNuevo);
		} else {
			System.out.println("El destino ya existe");
		}
		
	}
	
	public static void validarIngresoDestino(int codigo, String destinoBuscado) {
		boolean bandera;	
		do {
			bandera = true;
			try {
				System.out.println("Ingrese el codigo del pais:");
			    codigo = sc.nextInt();
			    sc.nextLine();
			} catch(InputMismatchException e ) {
				System.out.println("Codigo mal ingresado:");
				bandera = false;
			}
		}while(bandera == false );	
		do {
			bandera = true;
			try {
				System.out.println("Ingrese destino turistico:");
			    destinoBuscado = sc.next();
			    sc.nextLine();
			} catch(InputMismatchException e ) {
				System.out.println("Ingrese solo cadena de caracteres:");
				bandera = false;
			}
		}while(bandera == false );	
	}
	
	public static DestinoTuristico buscarDestino(int codigo, String destinoBuscado) {	
	    DestinoTuristico destinoEncontrado = null;
	    for( DestinoTuristico destino: destinos) {
	    	if(destino.getCodigo() == codigo && destino.getNombre().equals(destinoBuscado) ) {
	    		destinoEncontrado = destino;
	    	}
	    }		
		return destinoEncontrado;
	}
	
	public static void agregarPais(int codigoPais) {
		Pais pais = new Pais();
			pais.setCodigo(codigoPais);
			System.out.println("Ingrese el nombre del pais: ");
			pais.setNombre(sc.next());
			sc.nextLine();
			paises.add(pais);	
			System.out.println("Pais agregado");
	}
	
	public static Pais buscarPais(int codigo) {
		
		Pais paisEncontrado = null;
		for (Pais pais: paises) {
			if(pais.getCodigo() == codigo) {
				paisEncontrado = pais;
			}
		}
		return paisEncontrado;
	}
	
	public static void mostrarDestinos() {
		System.out.println("---Lista de destinos ----");
		destinos.forEach(d->System.out.println(d));
	}
	
	public static void modificarDestino() {
		int codigo = 0;
		int indice=0;
		boolean bandera=true;
		String destinoBuscado=null;
		validarIngresoDestino(codigo, destinoBuscado);
		DestinoTuristico destinoTuristico = new DestinoTuristico();
		destinoTuristico = buscarDestino(codigo,destinoBuscado);		
		if(destinoTuristico != null) {
			indice = destinos.indexOf(destinoTuristico);
			do {
				try {
					destinos.get(indice).setNombre(sc.next());
				}
				catch(InputMismatchException e ){
					System.out.println("Ingrese solo cadena de caracteres");
				}
			}while (bandera == false);		
			
		} else {
			System.out.println("El destino no existe");
		}		
	}
	
	public static void limpiarDestinos() {
		destinos.forEach(d->destinos.remove(d));	
	}
	
	public static void eliminarDestino() {
		
	}
	
	public static void ordenarDestinos() {
		
	}
	
	public static void mostrarPaises() {
		
	}
	
	public static void mostrarDestinosPorPais() {
		
	}	
	
}


