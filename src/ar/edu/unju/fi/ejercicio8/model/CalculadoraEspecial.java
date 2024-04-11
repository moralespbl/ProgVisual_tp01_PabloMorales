package ar.edu.unju.fi.ejercicio8.model;

public class CalculadoraEspecial {
	private Integer n;
	

	
	public CalculadoraEspecial() {
		
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}
	
	public int calcularSumatoria(int n) {
		int k;
		int i=0;
		for (k=1;k<=n;k++)
			i=(int) (i+Math.pow((k*(k+1) / 2),2));
		return i;
	}
	
	public int calcularProductoria (int n) {
		int k;
		int i=1;
		for (k=1;k<=n;k++)
			i=i*k*(k+4);
		return i;
		
	}
}
