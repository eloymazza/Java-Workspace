package Ejercicio3;

import java.util.*;

public abstract class Tarea {

	String nombre;
	int inicioEstimado, finEstimado, inicioReal, finReal;
	String estado;
	
	public Tarea(String nombre){
		
		this.nombre = nombre;
		estado = "En espera";	
	}
	
	public abstract List<Tarea> tareasAtrasadas(int fechaActual);
	public abstract List<Recurso> recursosInvolucrados(List<Recurso>repetidos);
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public int getInicioEstimado() {
		return inicioEstimado;
	}

	public int getFinEstimado() {
		return finEstimado;
	}

	public void setInicioReal(int inicioReal) {
		this.inicioReal = inicioReal;
	}

	public void setFinReal(int finReal) {
		this.finReal = finReal;
	}
	
	public void setInicioEstimado(int fecha){
		this.inicioEstimado = fecha;
	}
	public void setFinEstimado(int fecha){
		this.finEstimado = fecha;
	}
	
}
