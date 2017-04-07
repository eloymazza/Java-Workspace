package Ejercicio3;

import java.util.*;

public class TareaTerminal extends Tarea{

	List <Recurso> recursos;
	
	public TareaTerminal(String nombre, int inicioEstimado, int finestimado) {
		super(nombre);
		this.inicioEstimado = inicioEstimado;
		this.finEstimado = finestimado;
		recursos = new ArrayList<Recurso>();
	}
	
	public void addRecurso(Recurso rec){
		
		if (rec.chequearDisponibilidad(this)) {
			recursos.add(rec);
		}
		else{
			System.out.println("El recurso no se ha podido agregar porque estará posiblemente en uso.");
		}
	}
	
	@Override
	public List<Tarea> tareasAtrasadas(int fechaActual) {
		
		List <Tarea> tareasAtrasadas = new ArrayList<Tarea>();
		
		if(this.getFinEstimado() < fechaActual){
			tareasAtrasadas.add(this);
		}
		
		return tareasAtrasadas;
	}

	@Override
	public List<Recurso> recursosInvolucrados(List<Recurso> acumulados) {
		
		for (Recurso r : recursos) {
			if(!acumulados.contains(r)){
				acumulados.add(r);
			}
		}
		return acumulados;
	}
	
	public int duracionEstimada(){
		return this.getFinEstimado() - this.getInicioEstimado();
	}

}
