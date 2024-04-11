package ar.edu.unju.fi.ejercicio8.main;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;
public class Main {

	public static void main(String[] args) {
		// Ejercicio 8
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese n: ");
		int n = sc.nextInt();
		sc.nextLine();
		CalculadoraEspecial calculadoraEspecial = new CalculadoraEspecial();
		System.out.println("La sumatoria de "+ n +" es :"+calculadoraEspecial.calcularSumatoria(n));
		System.out.println("La productora de "+ n +" es :"+calculadoraEspecial.calcularProductoria(n));
	}

}
