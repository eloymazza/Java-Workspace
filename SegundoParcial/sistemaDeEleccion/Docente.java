package sistemaDeEleccion;
import java.util.*;

public class Docente {

	String nombre;
	int edad;
	int antiguedad;
	int cantTesis;
	List<Tesis>tesisDirigidas;
	
	public Docente(String nombre, int edad, int antiguedad, int cantTesis){
		
		this.nombre = nombre;
		this.edad = edad;
		this.antiguedad = antiguedad;
		this.cantTesis = cantTesis;
		tesisDirigidas = new ArrayList<Tesis>();
		
	}
	
	public void setTesis(Tesis t){	
		cantTesis++;
		tesisDirigidas.add(t);	
	}
	
	public String toString(){
		return this.getNombre() + " " + this.getCantTesis();
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public int getCantTesis() {
		return cantTesis;
	}
	
}
