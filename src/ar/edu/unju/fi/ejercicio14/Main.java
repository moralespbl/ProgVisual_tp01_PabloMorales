package ar.edu.unju.fi.ejercicio14;

import java.util.Scanner;

public class Main {
public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int i;
		// Ejercicio 14
		do {
			System.out.println("Ingrese un numero entero comprendido entre 3 y 10: ");
			i= sc.nextInt();
		} while(i<3 || i>10);
		int[] arreglo = new int[i];
		int j=0;
		int sum=0;
		while (j<i) {
			System.out.println("\nIngrese un numero entero: ");
			int x= sc.nextInt();
			arreglo[j]=x;
			System.out.println("Indice: "+j+", valor almacenado: "+x);
			sum = sum + x;
			j++;
		}
		System.out.println("La suma de todos los valores es: "+sum);
	}

}
/*
 * import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Ingrese un String:");
            String entrada = scanner.nextLine();
            System.out.println("El String ingresado es: " + entrada);
        } catch (InputMismatchException e) {
            System.out.println("Error: Se esperaba un String pero se ingresó otro tipo de dato.");
            // Aquí puedes agregar el código para manejar la excepción según tus necesidades
        } finally {
            scanner.close(); // Es importante cerrar el Scanner al finalizar su uso
        }
    }
}

 * */
