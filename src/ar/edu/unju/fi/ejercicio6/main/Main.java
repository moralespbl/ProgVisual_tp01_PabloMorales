package ar.edu.unju.fi.ejercicio6.main;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;

public class Main {
	
	
	public static void main(String[] args) {
		
		Persona persona = new Persona();
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese DNI:");
		int dni = sc.nextInt();
		System.out.println("Ingrese Nombre:");
		String nombre = sc.next();
		System.out.println("Ingrese Año de nacimiento");
		int anio =sc.nextInt();
		System.out.println("Ingrese mes de nacimiento");
		int mes =sc.nextInt();
		System.out.println("Ingrese dia de nacimiento");
		int dia =sc.nextInt();
		System.out.println("Ingrese Provincia:");
		String provincia = sc.next();
		persona.setDni(dni);
		persona.setNombre(nombre);
		persona.setFechaNacimiento(LocalDate.of(anio, mes, dia));
		persona.setProvincia(provincia);
		System.out.println(persona);
		
		System.out.println("Ingrese DNI:");
		int dni2 = sc.nextInt();
		System.out.println("Ingrese Nombre:");
		String nombre2 = sc.next();
		System.out.println("Ingrese Año de nacimiento");
		int anio2 =sc.nextInt();
		System.out.println("Ingrese mes de nacimiento");
		int mes2 =sc.nextInt();
		System.out.println("Ingrese dia de nacimiento");
		int dia2 =sc.nextInt();
		System.out.println("Ingrese Provincia:");
		String provincia2 = sc.next();
		Persona persona2= new Persona(dni2, nombre2, LocalDate.of(anio2,mes2,dia2), provincia2);
		persona2.mostrarDatos();
		
		System.out.println("Ingrese DNI:");
		int dni3 = sc.nextInt();
		System.out.println("Ingrese Nombre:");
		String nombre3 = sc.next();
		System.out.println("Ingrese Año de nacimiento");
		int anio3 =sc.nextInt();
		System.out.println("Ingrese mes de nacimiento");
		int mes3 =sc.nextInt();
		System.out.println("Ingrese dia de nacimiento");
		int dia3 =sc.nextInt();
		Persona persona3 = new Persona(dni3,nombre3,LocalDate.of(anio3,mes3,dia3) );
		persona3.mostrarDatos();

		sc.close();
		
	}

}
