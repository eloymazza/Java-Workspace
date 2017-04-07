package Ejercicio3;

public class RecursoExclusivo extends Recurso{

	public RecursoExclusivo(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean chequearDisponibilidad(Tarea t) {
		
		if(tareasAsignadas.isEmpty()){
			tareasAsignadas.add(t);
			return true;
		}
		else{
			for (Tarea tareaEncomendada : tareasAsignadas) {
				
				if(!(tareaEncomendada.getEstado().equals("Completada")) && 
						tareaEncomendada.getFinEstimado() > t.getInicioEstimado()){
					return false;
				}	
			}
			return true;
		}
	}

}
