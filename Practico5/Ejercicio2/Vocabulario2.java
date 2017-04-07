package Ejercicio2;

import java.util.*;
import java.util.Map.Entry;

public class Vocabulario2 {
	
	String [] texto;
	Map <String, Integer> mapaString;
	List<String> listaPalabras;
	
	public Vocabulario2(String text){
		
		texto = text.split(" ");	
		mapaString = new HashMap <String, Integer>();
			
		for (String string : texto) {
			
			if(mapaString.containsKey(string)){
				
				mapaString.put(string, mapaString.get(string)+ 1);
				
			}
			else{
				
				mapaString.put(string, 1);
				
			}	
		}
		
		listaPalabras = new ArrayList <String>(mapaString.keySet()); 
		
		
	}
	
	public int getCantidadPalabrasUnicas(){
		
		return mapaString.size();
		
	}
	
	public Set<Entry<String, Integer>> getPalabrasUnicasYFrecuencia(){
		
		
		return mapaString.entrySet();
		
	}
	
	public List<String> getPalabrasUnicasAlfabeticamente(){
		
		List<String> listaOrdenada = new ArrayList<String>(listaPalabras); 
		
		Collections.sort(listaOrdenada);
		
		return listaOrdenada;

	}
	
	public List<String> getPalabrasUnicasAlfabeticamenteConIterator(){
		
		List <String> palabrasOrdenadas = new ArrayList<String>();
		
		IteradorAlfabetico it = new IteradorAlfabetico(listaPalabras);
		
		while(it.hasNext()){
			
			palabrasOrdenadas.add(it.next());
			
		}
		
		return palabrasOrdenadas;
		
	}
	
	public List<String> getPalabrasPorFrecuencia(){
		
		List <String> palabrasPorFrecuencia = new ArrayList<String>();
		
		IteradorPorFrecuencia it = new IteradorPorFrecuencia(mapaString);
		
		while(it.hasNext()){
			
			palabrasPorFrecuencia.add(it.next());
			
		}
		
		return palabrasPorFrecuencia;
		
	}

	public List<String> getPalabrasMasFrecuentes() {
		
		List <String> palabrasMasFrecuentes = new ArrayList<String>();
		Iterator<String> it = mapaString.keySet().iterator();
		
		String next;
		int max = 0;
		int currentValue = 0;
		
		while(it.hasNext()){
			
			next = it.next();
			currentValue = mapaString.get(next);
			if(currentValue > max){
				
				palabrasMasFrecuentes.clear();
				palabrasMasFrecuentes.add(next);
				max = currentValue;
				
			}
			else if(currentValue == max){
				
				palabrasMasFrecuentes.add(next);
				
			}
			
		}
		
		return palabrasMasFrecuentes;
	}
	
	public List<String> getPalabrasMenosFrecuentes(){
		
		List <String> palabrasMenosFrecuentes = new ArrayList<String>();
		Iterator<String> it = mapaString.keySet().iterator();
		
		String next;
		int min = (int) ((Math.random()*100) + 2);
		int currentValue;
		
		while(it.hasNext()){
			
			next = it.next();
			currentValue = mapaString.get(next);

			if(currentValue < min){
				
				palabrasMenosFrecuentes.clear();
				palabrasMenosFrecuentes.add(next);
				min = currentValue;
				
			}
			else if(currentValue == min){
				
				palabrasMenosFrecuentes.add(next);
				
			}
			
		}
			
		return palabrasMenosFrecuentes;
		
	}
	
	public int getFrecuencia(String s){
		
		return mapaString.get(s);
		
	}
	
}
