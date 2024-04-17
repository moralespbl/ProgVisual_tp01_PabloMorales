package ar.edu.unju.fi.ejercicio17.model;

import java.time.LocalDate;
import java.time.Period;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private Float estatura;
	private Float peso;
	private String posicion;
	
	
	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, Float estatura,
			Float peso, String posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}



	public Jugador() {
	}
	
	
	
	public Jugador(String nombre2, String apellido2, LocalDate fechaNacimiento2, String nacionalidad2, Double estatura2,
			Double peso2, String posicion2) {
		// TODO Auto-generated constructor stub
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public Float getEstatura() {
		return estatura;
	}



	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}



	public Float getPeso() {
		return peso;
	}



	public void setPeso(Float peso) {
		this.peso = peso;
	}



	public String getPosicion() {
		return posicion;
	}



	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}



	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", nacionalidad=" + nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posicion="
				+ posicion + "]";
	}



	public Period calcularEdad() {
		return Period.between(LocalDate.now(), this.fechaNacimiento);		
	}
}
