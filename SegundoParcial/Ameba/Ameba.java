package Ameba;

import java.util.*;

public class Ameba {
	
	String nombre;
	Ameba patriarca;
	int orden;
	List<Ameba> hijos;
	
	public Ameba(String nombre, int orden){
		
		this.nombre = nombre;
		this.orden = orden;
		patriarca = null;
		hijos = new ArrayList<Ameba>();
		
	}
	
	public int cantAmebas(String nombre){
		
		int cant = 0;
		if(this.getNombre().equals(nombre)){
			cant++;
		}
		for (Ameba ameba : hijos) {
			cant+= ameba.cantAmebas(nombre);
		}
		
		return cant;
	}
	
	public void addAmeba(String nombrePropio, String nombrePadre, int ordenPadre){
		
		if(this.getNombre().equals(nombrePadre) && this.getOrden() == ordenPadre){
			
			int ordenHijo = this.getPatriarca().cantAmebas(nombrePropio)+1;
			Ameba nuevoHijo = new Ameba(nombrePropio, ordenHijo);
			nuevoHijo.setPatriarca(this.getPatriarca());
			hijos.add(nuevoHijo);
		}
		else{
			
			for (Ameba hijo : hijos) {		
				hijo.addAmeba(nombrePropio, nombrePadre, ordenPadre);
			}
			
		}
		
	}
	
	public static int getDescendencia(Ameba a){
		
		int descendencia = a.getHijos().size();
		
		for (Ameba hijo : a.getHijos()) {
			descendencia += getDescendencia(hijo);
		}
		return descendencia;
	}
	
	public boolean equals(Object o){
		
		Ameba otra = (Ameba) o;
		return this.getNombre().equals(otra.getNombre()) && this.getOrden() == otra.getOrden();
		
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public Ameba getPatriarca() {
		return patriarca;
	}

	public int getOrden() {
		return orden;
	}

	public List<Ameba> getHijos() {
		return hijos;
	}
	
	public void setPatriarca(Ameba patriarca){
		this.patriarca = patriarca;
	}

	public String toString(){
		return nombre + " " + orden;
	}
	
	public static void main(String[] args) {
		
		Ameba patriarca = new Ameba("Jhonny", 1);
		patriarca.setPatriarca(patriarca);
		patriarca.addAmeba("Mark", "Jhonny", 1);
		patriarca.addAmeba("Maggie", "Mark", 1);
		patriarca.addAmeba("Jhonny", "Maggie", 1);
		patriarca.addAmeba("Harry", "Maggie", 1);
		patriarca.addAmeba("Hermione", "Maggie", 1);
		patriarca.addAmeba("Ron", "Maggie", 1);
		patriarca.addAmeba("Jhonny", "Mark", 1);
		patriarca.addAmeba("Bart", "Mark", 1);
	
		
		Iterator<Ameba> it = new IteradorAmeba(patriarca);
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
