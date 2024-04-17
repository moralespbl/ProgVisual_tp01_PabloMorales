package ar.edu.unju.fi.ejercicio13.main;

import java.util.Scanner;

public class Main {
public static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
		// Ejercicio 13
		int[] arreglo = new int[8];
		int i;
		for( i=0; i<8 ; i++) {
			System.out.println("Ingrese un numero entero: ");
			int x= sc.nextInt();
			arreglo[i]=x;
			System.out.println("Indice: "+i+", valor almacenado: "+x);
		}
	}

}
