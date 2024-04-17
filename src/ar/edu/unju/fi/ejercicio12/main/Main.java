package ar.edu.unju.fi.ejercicio12.main;

import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Ejercicio 12
		Persona persona = new Persona();
		System.out.println("Ingrese Nombre");
		String nombre = sc.nextLine();
		persona.setNombre(nombre);
		Calendar calendario = Calendar.getInstance();
		System.out.println("Ingrese Año de Nacimiento (yyyy)");
		Integer anioNac = sc.nextInt();
		System.out.println("Ingrese Mes de Nacimiento (mm)");
		Integer mesNac = sc.nextInt();
		System.out.println("Ingrese dia de Nacimiento (dd)");
		Integer diaNac = sc.nextInt();
		calendario.set(anioNac, mesNac-1, diaNac);
		persona.setFechaNacimiento(calendario);
		System.out.println("\nNombre: "+persona.getNombre());
		System.out.println("Fecha de Nacimiento: "+persona.getFechaNacimiento().getTime());
		System.out.println("Edad: "+persona.calcularEdad()+" años");
		System.out.println("Signo Zodiacal: "+persona.calcularSigno());
		System.out.println("Estacion: "+persona.calcularEstacion());
	}

}
