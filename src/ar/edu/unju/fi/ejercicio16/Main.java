package ar.edu.unju.fi.ejercicio16;
import java.util.Scanner;
public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Ejercicio 16
		String[] arreglo = new String[5];
		byte i;
		for(i=0; i<5; i++) {
			System.out.println("\nIngrese un nombre: ");
			String nombre= sc.next();
			arreglo[i]=nombre;
		}
		byte j=0;
		while (j<5) {
			System.out.println("Arreglo["+j+"]: "+arreglo[j]);
			j++;
		}
		System.out.println("\nTamaño del arreglo: "+arreglo.length);
		boolean esbyte;
		Byte k;
		do {
			System.out.println("\nIndique el indice del elemento a eliminar: ");
			esbyte=sc.hasNextByte();
			k =sc.nextByte();
		}while( esbyte==false || k<0 || k>4);
		while( k<arreglo.length-1 ) {
			arreglo[k]=arreglo[k+1];
			k++;
		}
		arreglo[arreglo.length-1]="";
		j=0;
		while ( j<5 ) {
			System.out.println("Arreglo["+j+"]: "+arreglo[j]);
			j++;
		}
		
	}

}
