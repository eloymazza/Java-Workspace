package sistemaDeEleccion;

public class Tesis {
	
	String nombre;
	Docente director;
	
	public Tesis(String nombre){
		this.nombre = nombre;
		director = null;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setDirector(Docente d){	
		director = d;
	}
	
	public String imprimirDirector(){	
		return director.toString();
	}

}
