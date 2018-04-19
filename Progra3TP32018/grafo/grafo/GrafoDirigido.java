package grafo;

import java.util.*;

import nodeList.Node;
import nodeList.NodeList;

public class GrafoDirigido extends Grafo{
	
	
	public GrafoDirigido(){
		cantV = 0;
		cantA = 0;
		vertices = new NodeList();
		mapaAdyacencias = new HashMap<Integer,NodeList>();
	}
	
	protected void agregarArista(Integer idVertOrigen,  Arista arista){	
		
		if(!mapaAdyacencias.containsKey(idVertOrigen)){
			NodeList listaNueva = new NodeList();
			listaNueva.insertAtEnd(arista);
			mapaAdyacencias.put(idVertOrigen, listaNueva);
		}
		else{
			mapaAdyacencias.get(idVertOrigen).insertAtEnd(arista);
		}
		cantA++;
	}
	
	protected Vertice obtenerVertice(Integer idVert) {
		
		Iterator<Node> it = vertices.iterator();
		Vertice vActual;
		
		while(it.hasNext()){
			vActual = (Vertice)it.next().getElement();
			if(vActual.id == idVert){
				return vActual;
			}
		}
		return null;
	}
	
	@Override
	protected boolean existeArista(Integer idVertOrigen, Integer idVertFin) {
		
		NodeList listaAdy = mapaAdyacencias.get(idVertOrigen);
		if(listaAdy != null){
			Iterator<Node> it = listaAdy.iterator();
			Arista currentA;
			while(it.hasNext()){
				currentA = (Arista)it.next().getElement();
				if(currentA.getDestino() == idVertFin){
					return true;
				}
			}	
			return false;			
		}
		return false;
	}
	@Override
	protected NodeList obtenerAdyacentes(Integer idVert) {
		return mapaAdyacencias.get(idVert);
	}
	
	public String toString(){
		return this.vertices.toString();
	}
	
	public static void main(String[] args) {
		
		GrafoDirigido g1 = new GrafoDirigido();
		
		Vertice v1 = new Vertice(1, "Olavarria");
		Vertice v2 = new Vertice(2, "Tandil");
		Vertice v3 = new Vertice(3, "Tapalque");
		Vertice v4 = new Vertice(4, "Azul");
		
		Arista a1 = new Arista(3,100);
		Arista a2 = new Arista(4,80);
		Arista a3 = new Arista(4,100);
		Arista a4 = new Arista(3,150);
		
		g1.agregarVertice(v1);
		g1.agregarVertice(v2);
		g1.agregarVertice(v3);
		g1.agregarVertice(v4);
		
		g1.agregarArista(1, a1);
		g1.agregarArista(1, a2);
		g1.agregarArista(2, a3);
		g1.agregarArista(2, a4);
		
		System.out.println(g1.toString());
		System.out.println(g1.obtenerVertice(2).toString());
		System.out.println(g1.existeArista(5, 3));
		System.out.println(g1.obtenerAdyacentes(5));
		
	}
	
}
