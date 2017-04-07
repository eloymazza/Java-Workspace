package Ejercicio2;


import java.util.*;

public class Vocabulario {

	public static void main(String[] args) {
		
		String texto = "casa casa auto auto perro auto auto arbol pan auto arbol casa casa perro pan auto perro perro casa casa pan pan pan java c++ javascript";
		
		String[] textoSplit = texto.split(" ");
		
		Map<String, Integer> mapaString = new HashMap<String,Integer>();
		
		
		for (String string : textoSplit){
			
			if(mapaString.containsKey(string)){
				
				mapaString.put(string, mapaString.get(string)+1);
				
			}
			else{
				
				mapaString.put(string, 1);
				
			}		
		}
		
		System.out.println("Palabras distintas y su frecuencia:\n" + mapaString.entrySet());
		
		List<String> palabrasUnicas = new ArrayList<String>(mapaString.keySet());
		Collections.sort(palabrasUnicas);
		
		System.out.println("1)Cantidasd de palabras diferentes que contiene el texto:\n" + palabrasUnicas.size());
		
		System.out.println("2)Palabras unicas recorridas alfabeticamente:\n" + palabrasUnicas);
			
		Comparator<String> comparador1 = new Comparator<String>(){

			public int compare(String o1, String o2) {
				
				if(mapaString.get(o1) < mapaString.get(o2))		
					return 1;	
				
				else
					if(mapaString.get(o1) > mapaString.get(o2))
						return -1;
				
					else return 0;
			}
				
		};
		
		palabrasUnicas.sort(comparador1);
		
		System.out.println("3)Palabras recorridas por frecuencia de ocurrencia\n" + palabrasUnicas);
		
		Iterator<String> iteradorMapaString = mapaString.keySet().iterator();
		
		List <String> palabrasMasFrecuentes = new ArrayList<String>();
		
		int mayorFrecuencia = 0;
		int frecuenciaKey = 0;
		String auxString = "";
		
		while(iteradorMapaString.hasNext()){
			
		 auxString = iteradorMapaString.next();
		 frecuenciaKey = mapaString.get(auxString); 
		 
		 if(frecuenciaKey > mayorFrecuencia){
			 
			 palabrasMasFrecuentes.clear();
			 palabrasMasFrecuentes.add(auxString);
			 mayorFrecuencia = mapaString.get(auxString);
			 
		 }
		 else if(frecuenciaKey == mayorFrecuencia){
		
			 palabrasMasFrecuentes.add(auxString);
			 
		 }
			
		}
		
		
		
	
	}

}
