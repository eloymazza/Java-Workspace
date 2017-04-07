package Ejercicio3;

import java.util.*;

public abstract class Recurso {

	String nombre;
	List<Tarea> tareasAsignadas;
	
	public Recurso(String nombre){
		
		this.nombre = nombre;
		tareasAsignadas = new ArrayList<Tarea>();
		
	}
	
	public abstract boolean chequearDisponibilidad(Tarea t);
	
	public List<Tarea> getTareasAsignadas(){
		
		List <Tarea> retorno = new ArrayList<Tarea>();
			
		for (Tarea tarea : tareasAsignadas) {
			if(!tarea.getEstado().equals("Completada")){
				retorno.add(tarea);
			}
		}
		return retorno;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public boolean equals(Object o){
		return this.getNombre().equals(((Recurso) o).getNombre());
	}
}
