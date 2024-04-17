package ar.edu.unju.fi.ejercicio15;

import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// ejercicio 15
		int i;
		do {
			System.out.println("Ingrese un numero entero comprendido entre 3 y 10: ");
			i= sc.nextInt();
		} while(i<5 || i>10);
		String[] arreglo = new String[i];
		int j=0;
		while (j<i) {
			System.out.println("\nIngrese un nombre: ");
			String nombre= sc.next();
			arreglo[j]=nombre;
			System.out.println("Posicion: "+j+", nombre almacenado: "+nombre);
			j++;
		}
		j--;
		while (j>=0) {
			System.out.println("Arreglo["+j+"]: "+arreglo[j]);
			j--;
		}
	}

}
