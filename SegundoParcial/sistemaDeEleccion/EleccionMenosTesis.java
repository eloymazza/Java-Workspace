package sistemaDeEleccion;

import java.util.*;


public class EleccionMenosTesis extends Eleccion {

	@Override
	public Docente elegirDocente(List<Docente> docentes) {
		
		List<Docente> copia = new ArrayList<Docente>(docentes);
		
		Collections.sort(copia, new Comparator<Docente>(){

			@Override
			public int compare(Docente a, Docente b) {
				
				return a.getCantTesis() - b.getCantTesis();
			}

		});
		
		return copia.get(0);
	}

}
