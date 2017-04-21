package graphBestII;

public class Graph {

	NodeList []adjacents;
	int cantVertexes;	

	public Graph(int cantVertexes){

		this.cantVertexes = cantVertexes;
		adjacents = new NodeList[cantVertexes];

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

	// Agrega un adyacente a la lista de adyacencia..
	public void addAdjacent(int origin, int destination) {

		int length = adjacents.length;
		if((origin < length && origin >= 0) && (destination < length && destination >= 0)){

			if(adjacents[origin] == null){
				adjacents[origin] = new NodeList();
			}
			if(!hasEdge(origin, destination)){
				adjacents[origin].insertAtEnd(destination);
			}
		}
	}
	
	//Dado un indice, retorna la lisa de adjacencia vinculada al vertice en ese indice
	public NodeList getAdjacents(int i){
		
		if(i < adjacents.length && i >= 0){			
			return adjacents[i];
		}
		return null;
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
		
		Graph g1 = new Graph(7);
		
		
		g1.addAdjacent(0, 6);
		g1.addAdjacent(0, 1);
		g1.addAdjacent(1, 2);
		g1.addAdjacent(1, 3);
		g1.addAdjacent(2, 4);
		g1.addAdjacent(4, 5);
		
		
		
		/* Util para probar dfs
		g1.addAdjacent(0, 1);
		g1.addAdjacent(0, 2);
		g1.addAdjacent(1, 3);
		g1.addAdjacent(2, 4);
		g1.addAdjacent(2, 5);
		g1.addAdjacent(3, 8);
		g1.addAdjacent(3, 4);
		g1.addAdjacent(4, 9);
		g1.addAdjacent(4, 7);
		g1.addAdjacent(5,4);
		g1.addAdjacent(5, 6);
		g1.addAdjacent(6, 9);
		g1.addAdjacent(6, 7);
		g1.addAdjacent(6, 8);
		g1.addAdjacent(9, 1);
		*/
		
		System.out.println(g1);
		System.out.println(BFS.BFSPath(g1));
	}



}
