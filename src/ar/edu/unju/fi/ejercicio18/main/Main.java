package ar.edu.unju.fi.ejercicio18.main;


import java.util.ArrayList;
import java.util.Comparator;
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
			boolean bandera;
			do {
				bandera = true;
				try {
					opcion= sc.nextInt();
				}
				catch(InputMismatchException e ) {
					System.out.println("Codigo mal ingresado:");
					bandera = false;
				}
			    sc.nextLine();
			}while(bandera == false);			
			switch(opcion) {
			case 1: altaDestinoTuristico();break;
			case 2: mostrarDestinos();break;
			case 3: modificarDestino(); break;
			case 4: limpiarDestinos(); break;
			case 5: eliminarDestino();break;
			case 6: ordenarDestinos(); break;
			case 7: mostrarPaises(); break;
			case 8: mostrarDestinosPorPais(); break;
			case 9: System.out.println("Fin del Programa");; break;
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
		boolean bandera;
		Pais pais = new Pais();		
		int codigo = validarCodigo();
		String destinoBuscado = validarDestino();
		DestinoTuristico destinoTuristico = new DestinoTuristico();
		destinoTuristico = buscarDestino(codigo,destinoBuscado);
		if(destinoTuristico == null) {
			DestinoTuristico destinoNuevo = new DestinoTuristico();
			destinoNuevo.setCodigo(codigo);
	        destinoNuevo.setNombre(destinoBuscado);
	        System.out.println("Ingrese Precio: ");
	        do {
	        	bandera = true;
	        	try {
	        		destinoNuevo.setPrecio(sc.nextDouble());
	        	}catch(InputMismatchException e ) {
					System.out.println("Ingrese solo numeros");
					bandera = false;
				}
	        	 sc.nextLine();
			}while(bandera == false );	              
	        
			if( buscarPais(codigo) == null) {
				System.out.println("Pais inexistente: ");
				agregarPais(codigo);				
			}
			pais=buscarPais(codigo);
			destinoNuevo.setPais(pais);			
			do {
				bandera = true;
				try {
					System.out.println("Ingrese Cantidad de dias: ");
					destinoNuevo.setCantidadDias(sc.nextInt());				   
				} catch(InputMismatchException e ) {
					System.out.println("Ingrese solo enteros");
					bandera = false;
				}
				 sc.nextLine();
			}while(bandera == false );
			destinos.add(destinoNuevo);
			System.out.println("Nuevo destino ingresado ");	     
		} else {
			System.out.println("El destino ya existe");
		}		
	}

	/**
	 * valida que el tipo de datos ingresado en el scanner sea
	 * de tipo intero, de lo contrario vuelve a solicitar el ingreso de dato
	 * @return un tipo de dato entero
	 */
	public static int validarCodigo() {
		boolean bandera;
		int codigo=0;
		do {
			bandera = true;
			try {
				System.out.println("Ingrese el codigo del pais:");
			    codigo = sc.nextInt();
			    
			} catch(InputMismatchException e ) {
				System.out.println("Codigo mal ingresado:");
				bandera = false;
			}
		    sc.nextLine();
		}while(bandera == false );			
		return codigo;		
	}
	
	/**
	 * valida que el tipo de datos ingresado en el scanner sea
	 * de tipo String, de lo contrario vuelve a solicitar el ingreso de dato
	 * @return un tipo de dato String
	 */
	public static String validarDestino() {
		boolean bandera;
		String destinoBuscado=null;
		do {
			bandera = true;
			try {
				System.out.println("Ingrese destino turistico:");
			    destinoBuscado = sc.nextLine();
			} catch(InputMismatchException e ) {
				System.out.println("Ingrese solo cadena de caracteres:");
				bandera = false;
			}
			sc.nextLine();
		}while(bandera == false );	
		return destinoBuscado;
	}
	
	/**
	 * busca en el ArrayList de destino turisticos si existe el destino
	 * @param codigo
	 * @param destinoBuscado
	 * @return devuelve el destino encontrado o null si no lo encuentra
	 */
	public static DestinoTuristico buscarDestino(int codigo, String destinoBuscado) {	
	    DestinoTuristico destinoEncontrado = null;
	    for( DestinoTuristico destino: destinos) {
	    	if(destino.getCodigo() == codigo && destino.getNombre().equals(destinoBuscado) ) {
	    		destinoEncontrado = destino;
	    	}
	    }		
		return destinoEncontrado;
	}
	
	/**
	 * agrega al Array paises el objeto pais ingresado
	 * @param codigoPais
	 */
	public static void agregarPais(int codigoPais) {
		Pais pais = new Pais();
		pais.setCodigo(codigoPais);
		System.out.println("Ingrese el nombre del pais: ");
		pais.setNombre(sc.next());
		sc.nextLine();
		paises.add(pais);	
		System.out.println("Pais agregado");
	}
	
	/**
	 * busca en el ArrayList paises el codigo ingresa
	 * @param codigo
	 * @return el objeto pais si lo encuentra de lo contrario null
	 */
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
	
	/**
	 * solicita ingresar el codigo y destino, si lo encuentra
	 * permite modificar el pais del mismo
	 * si no existe el pais permite su creacion y añadirlo al 
	 * arraylist paises
	 */
	public static void modificarDestino() {
		Pais paisNuevo = null;
		int indice=0;
		int codigo = validarCodigo();
		String destinoBuscado = validarDestino();				
		DestinoTuristico destinoTuristico = new DestinoTuristico();		
		destinoTuristico = buscarDestino(codigo,destinoBuscado);		
		if(destinoTuristico != null) {			
			System.out.println("Ingrese codigo del nuevo pais: ");
			codigo = validarCodigo();
			if(buscarPais(codigo) == null) {
				agregarPais(codigo);
			}
			paisNuevo = buscarPais(codigo);
			indice = destinos.indexOf(destinoTuristico);
			destinos.get(indice).setPais(paisNuevo);
		} else {
			System.out.println("El destino no existe");
		}		
	}
	
	public static void limpiarDestinos() {
		destinos.clear();	
	}
	
	public static void eliminarDestino() {
		int indice=0;
		int codigo = validarCodigo();
		String destinoBuscado = validarDestino();	
		DestinoTuristico destinoTuristico = new DestinoTuristico();
		destinoTuristico = buscarDestino(codigo,destinoBuscado);		
		if(destinoTuristico != null) {
			indice = destinos.indexOf(destinoTuristico);
			destinos.remove(indice);				
		} else {
			System.out.println("El destino no existe");
		}		
	}
	
	public static void ordenarDestinos() {
		destinos.sort(Comparator.comparing(DestinoTuristico::getNombre));
		destinos.forEach(d->System.out.println(d));
	}
	
	public static void mostrarPaises() {
		paises.forEach(p->System.out.println(p));
	}
	
	public static void mostrarDestinosPorPais() {
		int codigo = validarCodigo();
		for(DestinoTuristico destino: destinos) {
			if(destino.getCodigo() == codigo) {
				System.out.println(destino.toString());
			}
		}
		
	}	
	
}


