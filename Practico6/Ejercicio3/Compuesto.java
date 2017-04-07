package Ejercicio3;

import java.util.*;

public class Compuesto extends Tarea{

	List <Tarea> subtareas;
	
	public Compuesto(String nombre) {
		super(nombre);
		subtareas = new ArrayList<Tarea>();
	}
	
	public void addSubtarea(Tarea t){
		subtareas.add(t);
		this.setFechasEstimadas();
	}
	
	@Override
	public List<Tarea> tareasAtrasadas(int fechaActual) {
		
		List<Tarea> tareasAtrasadas = new ArrayList<Tarea>();
		
		for (Tarea subtarea : subtareas) {
			tareasAtrasadas.addAll(subtarea.tareasAtrasadas(fechaActual));
		}
		
		return tareasAtrasadas;
	}

	@Override
	public List<Recurso> recursosInvolucrados(List<Recurso> acumulados) {
				
		for (Tarea subtarea : subtareas) {
			acumulados.addAll(subtarea.recursosInvolucrados(acumulados));
		}	
		return acumulados;

	}
	
	public void setFechasEstimadas(){
		
		this.setInicioEstimado(getInicioEstimado());
		this.setFinEstimado(getFinEstimado());
		
	}
	

	public int getInicioEstimado(){
		
		int menorInicioEstimado = subtareas.get(0).getInicioEstimado();
		int aux;
		
		for (Tarea tarea : subtareas) {
			 aux = tarea.getInicioEstimado();
			if(aux < menorInicioEstimado){
				menorInicioEstimado = aux;
			}
		}
		return menorInicioEstimado;	
	}
	
	public int getFinEstimado(){
		
		int mayorInicioEstimado = 0;
		int aux;
		
		for (Tarea tarea : subtareas) {
			aux = tarea.getFinEstimado();
			if(aux > mayorInicioEstimado){
				mayorInicioEstimado = aux;
			}
		}
		return mayorInicioEstimado;
		
	}
		
}
