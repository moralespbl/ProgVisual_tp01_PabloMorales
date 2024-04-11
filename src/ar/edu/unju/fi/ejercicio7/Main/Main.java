package ar.edu.unju.fi.ejercicio7.Main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.model.Empleado;

public class Main {
	
	public static void main(String[] args) {
		// Ejercicio 7
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese Nombre del Empleado: ");
		String nombre = sc.nextLine();
		sc.nextLine();
		System.out.println("Ingrese Legajo: ");
		Integer legajo = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese Salario: ");
		Integer salario = sc.nextInt();
		sc.nextLine();
		Empleado empleado = new Empleado(nombre, legajo, salario);
		empleado.mostrarDatos();
		empleado.aumentarSalario();
		empleado.mostrarDatos();
		sc.close();
	}

}
