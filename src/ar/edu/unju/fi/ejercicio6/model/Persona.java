package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	private Integer dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String provincia;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}	
	
	public Persona(Integer dni, String nombre, LocalDate fechaNacimiento, String provincia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = provincia;
	}
	
	public Persona(Integer dni, String nombre, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = "Jujuy";
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public void calcularEdad() {
		Period period=Period.between(getFechaNacimiento(), LocalDate.now());
		System.out.println(" tiene: "+period.getYears()+" años de edad.");
	}
	
	public boolean verificarEdad() {
		Period period=Period.between(getFechaNacimiento(), LocalDate.now());
		return (period.getYears()>=18);
	}
	
	public void mostrarDatos() {
		System.out.println("DNI: "+getDni());
		System.out.println("Nombre: "+getNombre());
		System.out.println("Fecha de nacimiento: "+getFechaNacimiento());
		System.out.println("Provincia: "+getProvincia());
		if(verificarEdad()==true)
			System.out.println("La persona es mayor de edad");
		else
			System.out.println("La persona no es mayor de edad");
		
		
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", provincia="
				+ provincia + "]";
	}
	
}
