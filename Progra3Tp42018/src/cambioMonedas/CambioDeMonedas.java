package cambioMonedas;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class CambioDeMonedas {
	
	
	
	public HashMap<Integer,Integer> darCambio(Integer objetivo, LinkedList<Integer> denominaciones){
		
		HashMap<Integer,Integer> solucion = new HashMap<Integer, Integer>();
		
		denominaciones.sort(new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b) * -1;
			}
		});
		
		System.out.println(denominaciones);
		
		Integer sumaActual = 0;
		Integer billeteActual = 0;
		Integer seleccion;
		
		while(!sumaActual.equals(objetivo)){
			seleccion = denominaciones.get(billeteActual);
			if(factible(seleccion,sumaActual,objetivo)){
				if(solucion.containsKey(seleccion)){
					solucion.put(seleccion, solucion.get(seleccion) +1);					
				}
				else{
					solucion.put(seleccion, 1);
				}
				sumaActual += seleccion;
			}
			else{
				billeteActual++;
			}
			
		}
		
		return solucion;
		
	}

	private boolean factible(Integer denominacion, Integer sumaActual, Integer objetivo) {
		
		return sumaActual + denominacion <= objetivo;
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> denominaciones = new LinkedList<Integer>();
		
		denominaciones.add(500);
		denominaciones.add(200);
		denominaciones.add(100);
		denominaciones.add(50);
		denominaciones.add(10);
		denominaciones.add(1);
		
		CambioDeMonedas c = new CambioDeMonedas();
		System.out.println(c.darCambio(1544, denominaciones));
	}
	
	
}
