package grafo;
import java.util.*;

public class GrafoDirigido{
	
	protected Integer cantV;
	protected Integer cantA;
	protected List<Vertice> vertices;
	protected HashMap<Integer,LinkedList<Arista>> mapaAdyacencias; 
	
	public GrafoDirigido(){
		cantV = 0;
		cantA = 0;
		vertices = new LinkedList<Vertice>();
		mapaAdyacencias = new HashMap<Integer,LinkedList<Arista>>();
	}
	
	protected  Integer getCantV(){
		return cantV;
	}
	
	protected Integer cantA(){
		return cantA;
	}
	
	public void agregarVertice(Vertice nuevoVertice){
		vertices.add(nuevoVertice);
		mapaAdyacencias.put(nuevoVertice.getID(), new LinkedList<Arista>());
		cantV++;
	}

	public Vertice obtenerVertice(Integer idVert) {
		
		Iterator<Vertice> it = vertices.iterator();
		Vertice vActual;
		
		while(it.hasNext()){
			vActual = it.next();
			if(vActual.getID() == idVert){
				return vActual;
			}
		}
		
		return new Vertice();
	}


	public void agregarArista(Integer idVertOrigen,  Arista arista){	
		
		if(existeVertice(idVertOrigen) && existeVertice(arista.getDestino())){
			mapaAdyacencias.get(idVertOrigen).add(arista);
			cantA++;						
		}
		
	}
	
	public boolean existeArista(Integer idVertOrigen, Integer idVertFin) {
		
		if(existeVertice(idVertOrigen) && existeVertice(idVertFin)){
			Iterator<Arista> it = mapaAdyacencias.get(idVertOrigen).iterator();
			while(it.hasNext()){
				if(it.next().getDestino() == idVertFin){
					return true;
				}
			}
		}
		return false;
	}
	
	public LinkedList<Arista> obtenerAdyacentes(Integer idVert) {
		return mapaAdyacencias.get(idVert);
	}
	
	
	private boolean existeVertice(Integer target) {
		return mapaAdyacencias.containsKey(target);

	}

	public Iterator<Vertice> getVIterator() {
		return vertices.iterator();
	}

	
	public String toString(){
		return this.vertices.toString();
	}
	
	public static class DFS{
		
		static State[] estados; 
		static LinkedList<Integer> ls = new LinkedList<Integer>();
		
		public static LinkedList<Integer> DFSPath(GrafoDirigido g){
			
			ls.clear();
			llenarEstados(g.getCantV());
			Integer currentID;
			Iterator<Vertice> it = g.getVIterator();
			
			while(it.hasNext()){
				currentID = it.next().getID();
				if(estados[currentID] == State.unvisited){
					DFSPath(currentID,g);									
				}
			}
			return ls;	
		}
		
		private static void DFSPath(Integer idvert, GrafoDirigido g){
				
			ls.add(idvert);
			estados[idvert] = State.visiting;
			LinkedList<Arista> ady = g.obtenerAdyacentes(idvert);
	
			Iterator<Arista> it = ady.iterator();
			Integer destino;

			while(it.hasNext()){
				destino = ((Arista)it.next()).getDestino();
				if(estados[destino] == State.unvisited){
					DFSPath(destino,g);
				}
			}
			
			estados[idvert] = State.visited;
		}
		
		
		private static void llenarEstados(Integer cantV){
			estados = new State[cantV];
			for (int i = 0; i < cantV; i++) {
				estados[i] = State.unvisited;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		GrafoDirigido g1 = new GrafoDirigido();
		
		Vertice v1 = new Vertice("A");
		Vertice v2 = new Vertice("B");
		Vertice v3 = new Vertice("C");
		Vertice v4 = new Vertice("D");
		
		
		Arista a1 = new Arista(2,1);
		Arista a2 = new Arista(3,1);
		Arista a3 = new Arista(4,1);
		Arista a4 = new Arista(3,1);
		Arista a5 = new Arista(4,1);
		Arista a6 = new Arista(2,1);

		
		g1.agregarVertice(v1);
		g1.agregarVertice(v2);
		g1.agregarVertice(v3);
		g1.agregarVertice(v4);
		
		
		g1.agregarArista(1, a1);
		g1.agregarArista(1, a2);
		g1.agregarArista(1, a3);
		g1.agregarArista(2, a4);
		g1.agregarArista(3, a5);
		g1.agregarArista(4, a6);
		
		System.out.println(g1.toString());
		System.out.println(g1.obtenerVertice(1).toString());
		System.out.println(g1.existeArista(1, 3));
		System.out.println(g1.obtenerAdyacentes(1));
		System.out.println(DFS.DFSPath(g1));
		
	}
	
}
