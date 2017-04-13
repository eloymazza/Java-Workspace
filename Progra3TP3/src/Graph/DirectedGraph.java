package Graph;

import java.util.*;

public class DirectedGraph extends Graph {

	public DirectedGraph(int cantVertexes) {
		super(cantVertexes);
	}

	// Agrega un adjacente al vertice indicado
	public void addAdjacent(int origin, int destination) {

		int length = adjacents.length;
		if( (origin < length && origin >= 0) && (destination < length && destination >= 0)){

			if(adjacents[origin] == null){
				adjacents[origin] = new NodeList();
			}
			if(!hasEdge(origin, destination)){
				adjacents[origin].insertAtEnd(destination);		
			}
		}

	}

	// Imprime lista de adjacencia
	public String toString(){
		if(!isEmpty()){
			String aux = "";
			for (int i = 0; i < cantVertexes; i++) {
				aux += "Nodo " + i + ": " + adjacents[i] + "\n" ;
			}
			return aux;			
		}
		return null;
	}

	/* Este metodo crea adjacentes automaticamente. Se puede especificar la cantidad de aristas deseadas
	 *  y tambien si se desea que el grafo tenga ciclos o no.
	 */
	public void fillGraph(int maxEdges,  boolean hasCycles) {

		int a  = maxEdges;
		int length = adjacents.length;
		for (int i = 0; i < length; i++) {

			for (int j = i+1; j <= a; j++) {
				this.addAdjacent(i, j);
			}

			//a se incrementa solo hasta lenght - maxedges para evitar que se creen aristas que apunten
			// a nodos que no existen
			if(i < length - maxEdges){
				a++;
			}	
		}

		// Si hasCycles es true, se activa este generador de ciclos
		if(hasCycles){
			int i = generateRandom(adjacents.length);
			int j = generateRandom(i);
			this.addAdjacent(i, j);
		}
	}

	private int generateRandom(int i) {

		return (int)Math.floor(Math.random()*i);
	}

	public static void main(String[] args) {

		long startTime;
		long totalTime;

		// Recordar que el indice del arreglo de adjacencia empieza en 0, por lo cual si se desean n 
		// vertices debe crearce el grafo con (n+1).
		Graph g = new DirectedGraph(10000);

		g.fillGraph(2,false);



		System.out.println(g.toString());
		DFS dfs = new DFS(g);



		// DFS ITERATIVO

		startTime = System.currentTimeMillis();
		System.out.println(dfs.iterativeSearch(g));
		totalTime = System.currentTimeMillis() - startTime;


		System.out.println("Tiempo total Recursivo: " + totalTime);



		// DFS RECURSIVO

		/*
		 startTime = System.currentTimeMillis();
		 System.out.println(dfs.iterativeSearch(g));
		 totalTime = System.currentTimeMillis() - startTime;

		 System.out.println("Tiempo total Iterativo:" + totalTime);
		 */

		// Conclusiones:

		/*
		 * Hacer el dfs recursivo trae el tipico problema del StackOverFlow.
		 * La diferencia de tiempo de ejecucion no varía demasiado entre ambos, Sin embargo,
		 * el recursivo es mas apenas mas rapido en mi implementacion.
		 * 
		 */
	}


}
