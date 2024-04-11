package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// Ejercicio 4
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un valor entra 0 y 10");
		int num = sc.nextInt();
		Integer factorial=1;
		if (num>=0 && num<11) {
			while (num>0) {
				factorial = factorial*num;
				num--;
			}
			System.out.println("El factorial es: "+factorial);	
		}
		else
			System.out.println("Debe ingresar un valor entre 0 y 10");
		sc.close();
	}

}
