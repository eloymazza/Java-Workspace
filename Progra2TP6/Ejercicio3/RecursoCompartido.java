package Ejercicio3;

public class RecursoCompartido extends Recurso{

	public RecursoCompartido(String nombre) {
		super(nombre);

	}

	
	public boolean chequearDisponibilidad(Tarea t) {
		
		tareasAsignadas.add(t);
		return true;
	}

}
