package recorrerSalas;
import java.util.*;

import grafo.*;

public class RecorrerSalas {

	GrafoDirigido g;
	Integer maxSuma;
	Integer salida;
	LinkedList<Integer> mejorCamino;
	boolean usados[];
	
	public RecorrerSalas(GrafoDirigido g){
		this.g = g;
		mejorCamino = new LinkedList<Integer>();
		usados = new boolean[g.getCantV()];
	}
	
	public LinkedList<Integer> recorrerSalas(Integer entrada, Integer salida){
		
		maxSuma = 0;
		this.salida = salida;
		LinkedList<Integer> caminoActual = new LinkedList<Integer>();
		Integer sumaActual = 0;
		
		getMejorCamino(entrada, caminoActual, sumaActual);
		
		return mejorCamino;
	}

	private void getMejorCamino(Integer actual, LinkedList<Integer> caminoActual, Integer sumaActual) {
		
		caminoActual.add(actual);
		sumaActual++;
		usados[actual] = true;
		if(actual == salida){
			if(sumaActual > maxSuma){
				mejorCamino.clear();
				maxSuma = sumaActual;
				mejorCamino.addAll(caminoActual);
			}
		}
		else{
			LinkedList<Arista> adyacentes = g.obtenerAdyacentes(actual);
			for (Arista ady : adyacentes) {
				if(!usados[ady.getDestino()]){
					getMejorCamino(ady.getDestino(), caminoActual, sumaActual);					
				}
			}
		}
		caminoActual.remove(actual);
		sumaActual--;
		usados[actual] = false;
	}
	
	public static void main(String[] args) {
		
		GrafoDirigido g = new GrafoDirigido();
		
		Vertice v1 = new Vertice(0);
		Vertice v2 = new Vertice(1);
		Vertice v3 = new Vertice(2);
		Vertice v4 = new Vertice(3);
		Vertice v5 = new Vertice(4);
		Vertice v6 = new Vertice(5);
		Vertice v7 = new Vertice(6);
		
		g.agregarVertice(v1);
		g.agregarVertice(v2);
		g.agregarVertice(v3);
		g.agregarVertice(v4);
		g.agregarVertice(v5);
		g.agregarVertice(v6);
		g.agregarVertice(v7);
		
		g.agregarArista(0, 1);
		g.agregarArista(1, 2);
		g.agregarArista(1, 3);
		g.agregarArista(1, 5);
		g.agregarArista(3, 4);
		g.agregarArista(4, 2);
		g.agregarArista(5, 6);
		g.agregarArista(6, 4);
		
		RecorrerSalas r = new RecorrerSalas(g);
		
		System.out.println(g.toString());
		System.out.println(r.recorrerSalas(0, 2));
		
	}
}
