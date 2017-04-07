package sistemaDeEleccion;
import java.util.*;

public class EleccionAleatoria extends Eleccion {
	
	public Docente elegirDocente(List<Docente> docentes){
		
		return docentes.get((int) Math.floor(Math.random()*docentes.size()));
		
	}

}
