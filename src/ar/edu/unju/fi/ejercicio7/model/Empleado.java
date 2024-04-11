package ar.edu.unju.fi.ejercicio7.model;

import java.util.Scanner;

public class Empleado {
	private String nombre;
	private Integer legajo;
	private Integer salario;
	
	
	Integer salarioMinimo=210000;
	Integer aumento=20000;
	
	public Empleado(String nombre, Integer legajo, Integer salario) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		if (salario>=salarioMinimo)
			this.salario = salario;
		else
			this.salario = salarioMinimo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	public Integer getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(Integer salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public Integer getAumento() {
		return aumento;
	}

	public void setAumento(Integer aumento) {
		this.aumento = aumento;
	}
	
	
	public void mostrarDatos() {
		System.out.println("Nombre del Empleado: "+getNombre());
		System.out.println("Legajo: "+getLegajo());
		System.out.println("Salario $: "+getSalario());
	}
	
	public void aumentarSalario() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de meritos: ");
		int meritos = sc.nextInt();
		sc.nextLine();
		this.salario=salario+meritos*getAumento();
		System.out.println("El nuevo salario de "+getNombre()+" es: "+getSalario());
		sc.close();
	}
	

	
	
	
	
	
}
