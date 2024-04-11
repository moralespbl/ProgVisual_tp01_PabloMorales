package ar.edu.unju.fi.ejercicio9.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejercicio 9
		int i=3;
		while (i>=1) {
			
			System.out.print("Ingrese nombre del producto: ");
			String nombre = sc.nextLine();
			System.out.print("Ingrese codigo del producto: ");
			Integer codigo = sc.nextInt();
			sc.nextLine();
			System.out.print("Ingrese precio del producto: ");
			Integer precio = sc.nextInt();
			sc.nextLine();
			System.out.print("Ingrese descuento del producto: ");
			Integer descuento = sc.nextInt();
			sc.nextLine();
			Producto producto = new Producto(nombre, codigo, precio, descuento);
			producto.mostrarDatos();
			producto.calcularDescuento();
			System.out.println("");
			i--;
		}
	}
	
}
