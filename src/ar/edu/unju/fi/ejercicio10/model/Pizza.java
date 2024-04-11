package ar.edu.unju.fi.ejercicio10.model;

public class Pizza {
	private String nombre;
	private double diametro;
	private Integer precio;
	private float area;
	private boolean ingredientesEspeciales;
	private Integer adicional20=500;
	private Integer adicional30=750;
	private Integer adicional40=1000;
	
	public Pizza() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDiametro() {
		return diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public boolean getIngredientesEspeciales() {
		return ingredientesEspeciales;
	}
	public void setIngredientesEspeciales(boolean ingredientesEspeciales) {
		this.ingredientesEspeciales = ingredientesEspeciales;
	}
	public Integer getAdicional20() {
		return adicional20;
	}
	public void setAdicional20(Integer adicional20) {
		this.adicional20 = adicional20;
	}
	public Integer getAdicional30() {
		return adicional30;
	}
	public void setAdicional30(Integer adicional30) {
		this.adicional30 = adicional30;
	}
	public Integer getAdicional40() {
		return adicional40;
	}
	public void setAdicional40(Integer adicional40) {
		this.adicional40 = adicional40;
	}
	
	public void calcularPrecio() {
		if (diametro==20) {
			if (ingredientesEspeciales==false)
				precio=4500;
			else
				precio=4500+adicional20;
		}
		else{
			if (diametro==30) {
				if (ingredientesEspeciales==false)
					precio=4800;
				else
					precio=4800+adicional30;
			}
			else {
				if (ingredientesEspeciales==false)
					precio=5500;
				else
					precio=5500+adicional40;
			}
		}
	}
	
	public void calcularArea() {
		this.area=(float) Math.pow((diametro/2),2)*3.1416f;
	}
	
	public void mostrarDatos() {
		System.out.print("\nDiametro = "+getDiametro());
		System.out.print("\nIngredientes especiales = "+getIngredientesEspeciales());
		System.out.print("\nPrecio Pizza = "+getPrecio());
		System.out.print("\nÁrea de la pizza = "+getArea());
	}
	
	
}
