package graphBest;

import graphBest.GraphNodeList;

public class Graph {

	GraphNodeList []adjacents;
	int cantVertexes;	

	public Graph(int cantVertexes){

		this.cantVertexes = cantVertexes;
		adjacents = new GraphNodeList[cantVertexes];

	}

	// Pregunta si el grafo no tiene vertices
	public boolean isEmpty(){	
		return cantVertexes == 0;	
	}

	// Comprueba si la arista ya existe
	public boolean hasEdge(int origin, int destination){	
		return adjacents[origin].contains(destination);	
	}

	// Retorna la cantidad total de vertices del grafo
	public int getCantVertexes(){
		return cantVertexes;
	}

	// Retorna una copia de los adjacentes del grafo
	public GraphNodeList[] getAdjacentList() {

		GraphNodeList[] clone = new GraphNodeList[cantVertexes];
		
		for (int i = 0; i < cantVertexes; i++) {
			if(adjacents[i] != null){
				clone[i] = adjacents[i].clone();				
			}
			else{
				clone[i] = null;
			}
		}
		
		return clone;
	}

	// Agrega un adyacente a la lista de adyacencia..
	public void addAdjacent(int origin, int destination, int weight) {

		int length = adjacents.length;
		if((origin < length && origin >= 0) && (destination < length && destination >= 0)){

			if(adjacents[origin] == null){
				adjacents[origin] = new GraphNodeList();
			}
			if(!hasEdge(origin, destination)){
				adjacents[origin].insertAtEnd(destination, weight);
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
				this.addAdjacent(i, j, 0);
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
			this.addAdjacent(i, j, 0);
		}
	}

	private int generateRandom(int i) {

		return (int)Math.floor(Math.random()*i);
	}


	public static void main(String[] args) {

		Graph g1 = new Graph(4);
		
		g1.addAdjacent( 0, 1, 0);
		g1.addAdjacent( 0, 2, 0);

		g1.addAdjacent(1, 1, 0);
		g1.addAdjacent(1, 3, 0);
		g1.addAdjacent(3, 1, 0);
		
		
		System.out.println(g1 + "\n");
		System.out.println(DFS.hasCycle(g1.getAdjacentList()));
			
		
	}


}
