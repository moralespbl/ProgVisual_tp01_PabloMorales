package ar.edu.unju.fi.ejercicio10.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio10.model.Pizza;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejercicio 10
		int i=1;
		while (i<=3) {
			System.out.print("\nIngrese datos de Piza");
			System.out.print("\nPizza: ");
			String nombre = sc.next();
			/*System.out.print("Precio : ");
			Integer precio = sc.nextInt();
			sc.nextLine();*/
			int diametro;
			do{
				System.out.print("Diametro (20, 30 o 40): ");
				diametro = sc.nextInt();
				sc.nextLine();
			}while (diametro != 20 && diametro !=30 && diametro !=40);
			
			System.out.print("Tiene ingredientes especiales? si (true), no (false): ");
			boolean ingredientesEspeciales = sc.nextBoolean();
			Pizza pizza = new Pizza();
			pizza.setNombre(nombre);
			/*pizza.setPrecio(precio);*/
			pizza.setDiametro(diametro);
			pizza.setIngredientesEspeciales(ingredientesEspeciales);
			pizza.calcularPrecio();
			pizza.calcularArea();
			System.out.print("\n** Pizza "+i+" **");
			pizza.mostrarDatos();
			i++;			
		}
	}
}

