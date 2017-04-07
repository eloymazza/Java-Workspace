package sistemaDeEleccion;
import java.util.*;

public class SistemaDeEleccion {
	
	List<Docente> docentes;
	
	public SistemaDeEleccion(){
		
		docentes = new ArrayList<Docente>();
	}
	
	public void addDocente(Docente d){	
		docentes.add(d);	
	}
	
	public void elegirDocente(Eleccion e, Tesis t){	
			
		 Docente docenteElegido = e.elegirDocente(this.docentes);
		 t.setDirector(docenteElegido);
		 docenteElegido.setTesis(t);
		 
	}
	
	public String toString(){
		
		String aux = "";
		
		for (Docente docente : docentes) {
			aux +=docente.toString() + " ";
		}
		return aux;
	}

	public static void main(String[] args) {
		
		Docente d1 = new Docente("Juan", 25, 5, 3);
		Docente d2 = new Docente("Pedro", 30, 10, 6);
		Docente d3 = new Docente("Altair", 40, 15,10);
		
		SistemaDeEleccion s = new SistemaDeEleccion();
		s.addDocente(d1);
		s.addDocente(d2);
		s.addDocente(d3);
		
		Tesis t1 = new Tesis("Calentamiento Global");
		Tesis t2 = new Tesis("Cambio cultural");
		Tesis t3 = new Tesis("Drogadiccion");
		Tesis t4 = new Tesis("POO");
		Tesis t5 = new Tesis("BBDD");
		
		Eleccion e1 = new EleccionAleatoria();
		Eleccion e2 = new EleccionMenosTesis();
		
		s.elegirDocente(e2, t1);
		s.elegirDocente(e2, t2);
		s.elegirDocente(e2, t3);
		s.elegirDocente(e2, t4);
		s.elegirDocente(e2, t5);

		
		System.out.println(s.toString());
	}
	
}
