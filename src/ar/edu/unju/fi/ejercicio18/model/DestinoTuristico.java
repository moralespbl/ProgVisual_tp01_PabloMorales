package ar.edu.unju.fi.ejercicio18.model;

public class DestinoTuristico {
// En el archivo DestinoTuristico.java en el paquete model
    private int codigo;
    private String nombre;
    private double precio;
    private Pais pais;
    private int cantidadDias;
	
	public DestinoTuristico() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	@Override
	public String toString() {
		return "DestinoTuristico [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", pais=" + pais.toString()
				+ ", cantidadDias=" + cantidadDias + "]";
	}
	
	

}
