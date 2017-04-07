package Ejercicio2;

import java.util.*;

public class IteradorPorFrecuencia implements Iterator <String>{

	int pos = 0;
	Map<String, Integer>copiaMapaString;
	List <String> elementos;
	
	public IteradorPorFrecuencia(Map<String,Integer> mapa){
		
		copiaMapaString = new HashMap<String, Integer> (mapa);
		elementos = new ArrayList<String>(copiaMapaString.keySet());
		
		Collections.sort(elementos, new Comparator<String>(){

			public int compare(String a, String b) {
			
				if(copiaMapaString.get(a) > copiaMapaString.get(b)){
					
					return -1;
					
				}
				else if(copiaMapaString.get(a) < copiaMapaString.get(b)){
					
					return 1;
					
				}
				else {
					
					return copiaMapaString.get(a) - copiaMapaString.get(b);
					
				}
				
			}
		
		});
			
	}
	
	
	public boolean hasNext() {
		
		return(pos<elementos.size());
		
	}

	public String next(){
		
	String s = elementos.get(pos);
	pos++;
	return s;
	
	}
	
}
