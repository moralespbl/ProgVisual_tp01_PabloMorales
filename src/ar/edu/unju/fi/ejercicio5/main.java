package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// Ejercicio 5
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un valor entra 1 y 9");
		int num = sc.nextInt();
		int i = 0;
		int multiplo;
		if (num>0 && num<10) {
			while (i<11) {
				multiplo=num*i;
				System.out.println(num+" x "+i+" = "+multiplo);
				i++;
			}
		}
		else
			System.out.println("Debe ingresar un valor entre 1 y 9");
		sc.close();
	}
}
