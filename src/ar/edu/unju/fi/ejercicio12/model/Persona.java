package ar.edu.unju.fi.ejercicio12.model;

import java.util.Calendar;

public class Persona {
	private String nombre;
	private Calendar fechaNacimiento = Calendar.getInstance();
	
	
	public Persona() {
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public int calcularEdad() {
		Calendar hoy= Calendar.getInstance();
		int anios = hoy.get(Calendar.YEAR) - this.fechaNacimiento.get(Calendar.YEAR);
		if (hoy.get(Calendar.MONTH) > this.fechaNacimiento.get(Calendar.MONTH)) {
			return anios;
		}
		else {
			if (hoy.get(Calendar.DAY_OF_MONTH) > this.fechaNacimiento.get(Calendar.DAY_OF_MONTH)) {
				return anios;
			}
			else {
				return anios - 1;
			}
		}
	}
	
	public String calcularSigno() {
		int dia = this.fechaNacimiento.get(Calendar.DAY_OF_MONTH);
        int mes = this.fechaNacimiento.get(Calendar.MONTH);
      
        if ((mes == Calendar.JANUARY && dia >= 20) || (mes == Calendar.FEBRUARY && dia <= 18)) {
            return "Acuario";
        }
        else if ((mes == Calendar.FEBRUARY && dia >= 19) || (mes == Calendar.MARCH && dia <= 20)) {
                return "Piscis";
        	}
        else if ((mes == Calendar.MARCH && dia >= 21) || (mes == Calendar.APRIL && dia <= 19)) {
            return "Aries";
        } 
        else if ((mes == Calendar.APRIL && dia >= 20) || (mes == Calendar.MAY && dia <= 20)) {
            return "Tauro";
        }
        else if ((mes == Calendar.MAY && dia >= 21) || (mes == Calendar.JUNE && dia <= 20)) {
            return "Géminis";
        }
        else if ((mes == Calendar.JUNE && dia >= 21) || (mes == Calendar.JULY && dia <= 20)) {
            return "Cáncer";
        }
        else if ((mes == Calendar.JULY && dia >= 23) || (mes == Calendar.AUGUST && dia <= 22)) {
            return "Leo";
        }
        else if ((mes == Calendar.AUGUST && dia >= 23) || (mes == Calendar.SEPTEMBER && dia <= 22)) {
            return "Virgo";
        }
        else if ((mes == Calendar.SEPTEMBER && dia >= 23) || (mes == Calendar.OCTOBER && dia <= 22)) {
            return "Libra";
        }
        else if ((mes == Calendar.OCTOBER && dia >= 23) || (mes == Calendar.NOVEMBER && dia <= 21)) {
            return "Escorpio";
        }
        else if ((mes == Calendar.NOVEMBER && dia >= 22) || (mes == Calendar.DECEMBER && dia <= 21)) {
      
        	return "Sagitario";
        }
        else  {
            return "Capricornio";
        }		
            	
	}
	
	public String calcularEstacion() {
		int dia = this.fechaNacimiento.get(Calendar.DAY_OF_MONTH);
        int mes = this.fechaNacimiento.get(Calendar.MONTH);
        if ((mes == Calendar.JANUARY && dia >= 21) || (mes == Calendar.MARCH && dia <= 20)) {
            return "Verano";
        }
        else if ((mes == Calendar.MARCH && dia >= 21) || (mes == Calendar.JUNE && dia <= 20)) {
            return "Otoño";
        }
        else if ((mes == Calendar.JUNE && dia >= 21) || (mes == Calendar.SEPTEMBER && dia <= 20)) {
            return "Invierno";
        }
        else {
        	return "Primavera";
        }
	}


}

// aqui en vez de estas fechas se puede usar los metodos de calendar before
//   this.fechaNacimiento.before(fecha....)





