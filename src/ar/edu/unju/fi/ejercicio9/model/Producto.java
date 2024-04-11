package ar.edu.unju.fi.ejercicio9.model;

public class Producto {
	private String nombre;
	private Integer codigo;
	private Integer precio;
	private Integer descuento;
	
	public Producto() {
		
	}
	
	public Producto(String nombre, Integer codigo, Integer precio, Integer descuento) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getDescuento() {
		return descuento;
	}
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	
	public Integer calcularDescuento() {
		this.precio = this.precio - getDescuento();
	return precio;
	}
	public void mostrarDatos() {
		System.out.println("Producto: "+getNombre());
		System.out.println("Codigo: "+getCodigo());
		System.out.println("Precio: "+getPrecio());
		System.out.println("Descuento: "+getDescuento());
	}
}
