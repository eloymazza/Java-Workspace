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
	
	public  Integer getCantV(){
		return cantV;
	}
	
	public Integer cantA(){
		return cantA;
	}
	
	public void agregarVertice(Vertice nuevoVertice){
		vertices.add(nuevoVertice);
		mapaAdyacencias.put(nuevoVertice.getID(), new LinkedList<Arista>());
		cantV++;
	}
	
	public void agregarVertice(Integer obj){
		vertices.add(new Vertice(obj));
		mapaAdyacencias.put(obj, new LinkedList<Arista>());
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
	
	public void agregarArista(Integer idVertOrigen,  Integer vertDestino){	
		
		if(existeVertice(idVertOrigen) && existeVertice(vertDestino)){
			mapaAdyacencias.get(idVertOrigen).add(new Arista(vertDestino,1));
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
	
	public static class Recorridos{
		
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
		
		public static LinkedList<Integer> obtenerCaminos(Integer objetivo, GrafoDirigido g){
			
			LinkedList<Integer> lista = new LinkedList<Integer>();
			
			Iterator<Vertice> it = g.getVIterator();
			
			while(it.hasNext()){
				llenarEstados(g.getCantV());
				Vertice v = it.next();
				Integer vActual = (Integer)v.getContenido();
				if(!(vActual).equals(objetivo)){
					if(hayCamino(vActual,objetivo,g)){
						lista.add(vActual);
					}
				}
			}		
			return lista;		
		}
		
		private static boolean hayCamino(Integer vActual, Integer objetivo, GrafoDirigido g) {
			
			estados[vActual] = State.visiting;
			if(vActual.equals(objetivo)){
				return true;
			}
			else{
				LinkedList<Arista> adyacentes = g.obtenerAdyacentes(vActual);
				for (Arista ady : adyacentes) {
					Integer proximo = ady.getDestino();
					if(estados[proximo] == State.unvisited){
						if(hayCamino(proximo,objetivo,g)){
							return true;
						}
					}
				}
			}
			estados[vActual] = State.visited;
			return false;
		}
		


		public static boolean tieneCiclo(GrafoDirigido g){
			
			ls.clear();
			llenarEstados(g.getCantV());
			return tieneCiclo(0,g);

		}
		
		private static boolean tieneCiclo(Integer idvert, GrafoDirigido g){
			
			estados[idvert] = State.visiting;
			LinkedList<Arista> adyacentes = g.obtenerAdyacentes(idvert);
			Integer destino;
			
			for (Arista arista : adyacentes) {
				destino = arista.getDestino();
				if(estados[destino] == State.visiting){
					return true;
				}
				if(estados[destino] == State.unvisited){
					if(tieneCiclo(destino,g)){
						return true;
					}
				}
			}
			estados[idvert] = State.visited;
			return false;
		}
		
		public static LinkedList<Integer> BFSPath(GrafoDirigido g, Integer idVInicial){
			
			ls.clear();
			llenarEstados(g.getCantV());
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(idVInicial);
			BFSPath(idVInicial, g, queue);
			return ls;
			
		}
		
			
		private static void BFSPath(Integer idVActual, GrafoDirigido g, Queue<Integer> queue) {
			
			estados[idVActual] = State.visited;
			ls.add(idVActual);
			while(!queue.isEmpty()){
				LinkedList<Arista> adyacentes = g.obtenerAdyacentes(queue.poll());
				for (Arista arista : adyacentes) {
					Integer adyacente = arista.getDestino();
					if(estados[adyacente] == State.unvisited){
						ls.add(adyacente);
						estados[adyacente] = State.visited;
						queue.add(adyacente);
					}
				}
			}
			
		}
		

		private static void llenarEstados(Integer cantV){
			estados = new State[cantV];
			for (int i = 0; i < cantV; i++) {
				estados[i] = State.unvisited;
			}
		}
		
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
		
		
		g.agregarArista(0,7);
		g.agregarArista(0,1);
		g.agregarArista(1,2);
		g.agregarArista(1,3);
		g.agregarArista(1,6);
		g.agregarArista(1,5);
		g.agregarArista(2,4);
		g.agregarArista(3,4);
		g.agregarArista(5,4);
	
		
		System.out.println(g.toString());
		System.out.println(Recorridos.obtenerCaminos(4,g));
		
	}
	
}
