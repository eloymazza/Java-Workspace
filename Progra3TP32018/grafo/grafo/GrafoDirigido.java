package grafo;
import java.util.HashMap;
import java.util.Iterator;
import nodeList.*;

public class GrafoDirigido{
	
	protected Integer cantV;
	protected Integer cantA;
	protected NodeList vertices;
	protected HashMap<Integer,NodeList> mapaAdyacencias; 
	
	public GrafoDirigido(){
		cantV = 0;
		cantA = 0;
		vertices = new NodeList();
		mapaAdyacencias = new HashMap<Integer,NodeList>();
	}
	
	protected  Integer getCantV(){
		return cantV;
	}
	
	protected Integer cantA(){
		return cantA;
	}
	
	protected void agregarVertice(Vertice nuevoVertice){
		vertices.insertAtEnd(nuevoVertice);
		mapaAdyacencias.put(nuevoVertice.getID(), new NodeList());
		cantV++;
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
	
	protected boolean existeArista(Integer idVertOrigen, Integer idVertFin) {
		
		if(vertices.contains(idVertOrigen) && vertices.contains(idVertFin)){
			return mapaAdyacencias.get(idVertOrigen).contains(idVertFin);
		}
		return false;
	}
	
	protected NodeList obtenerAdyacentes(Integer idVert) {
		return mapaAdyacencias.get(idVert);
	}
	
	protected void agregarArista(Integer idVertOrigen,  Arista arista){	
		
		Integer idDestino = arista.getDestino();
		
		if(vertices.contains(idVertOrigen) && vertices.contains(idDestino)){
			mapaAdyacencias.get(idVertOrigen).insertAtEnd(arista);
			cantA++;			
		}
	}
	
	public String toString(){
		return this.vertices.toString();
	}
	
	public static void main(String[] args) {
		
		GrafoNoDirigido g1 = new GrafoNoDirigido();
		
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
		System.out.println(g1.obtenerVertice(3).toString());
		System.out.println(g1.existeArista(4, 1));
		System.out.println(g1.obtenerAdyacentes(1));
		
	}
	
}
