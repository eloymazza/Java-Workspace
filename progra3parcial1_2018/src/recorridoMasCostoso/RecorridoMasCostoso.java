package recorridoMasCostoso;
import java.util.*;

import grafo.*;

public class RecorridoMasCostoso {

	GrafoDirigido g;
	Integer objetivo;
	LinkedList<Integer> caminoMaximo;
	Integer maxSum;
	
	public RecorridoMasCostoso(GrafoDirigido g){
		this.g = g;
		objetivo = 0;
		caminoMaximo = null;
		maxSum = null;
	}
	
	public List<Integer> getCaminoMasCostoso(Integer origen, Integer objetivo){
		
		LinkedList<Integer> caminoActual = new LinkedList<Integer>();
		caminoMaximo = new LinkedList<Integer>();
		this.objetivo = objetivo;
		maxSum = 0;
		Integer sumaActual = 0;
		encontrarCamino(caminoActual, origen, sumaActual);
		return caminoMaximo;
	}

	private void encontrarCamino(LinkedList<Integer> caminoActual, Integer vActual, Integer sumaActual) {
		
		caminoActual.add(vActual);
		if(vActual == this.objetivo){
			if(sumaActual > maxSum){
				caminoMaximo = new LinkedList<Integer>();
				caminoMaximo.addAll(caminoActual);
				maxSum = sumaActual;
			};
		}
		else{
			LinkedList<Arista> adyacentes = g.obtenerAdyacentes(vActual);
			for (Arista arista : adyacentes) {
				Integer adyacente = arista.getDestino();
				if(!caminoActual.contains(adyacente)){
					sumaActual += arista.getPeso();
					encontrarCamino(caminoActual, adyacente, sumaActual);
					sumaActual -= arista.getPeso();
				}
			}
		}
		caminoActual.remove(vActual);
	}
	
	
	public static void main(String[] args) {
		
		GrafoDirigido g = new GrafoDirigido();
		
		g.agregarVertice(new Vertice(1));
		g.agregarVertice(new Vertice(2));
		g.agregarVertice(new Vertice(3));
		g.agregarVertice(new Vertice(4));
		g.agregarVertice(new Vertice(5));
		g.agregarVertice(new Vertice(6));
		
		g.agregarArista(1, new Arista(2,7));
		g.agregarArista(1, new Arista(3,3));
		g.agregarArista(2, new Arista(3,1));
		g.agregarArista(2, new Arista(4,6));
		g.agregarArista(3, new Arista(5,8));
		g.agregarArista(4, new Arista(3,3));
		g.agregarArista(4, new Arista(6,2));
		g.agregarArista(5, new Arista(4,2));
		g.agregarArista(5, new Arista(6,8));
		
		System.out.println(g.toString());
		
		RecorridoMasCostoso r = new RecorridoMasCostoso(g);
		
		System.out.println(r.getCaminoMasCostoso(1, 6));
	}
}
