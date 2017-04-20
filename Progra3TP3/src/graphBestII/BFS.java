package graphBestII;

public class BFS {
	
	private static Graph graph;
	private static State [] visited;
	
	public static NodeList BFSPath(Graph g){
		
		NodeList result = new NodeList();
		setInitialValues(g);
		
		for (int i = 0; i < graph.getCantVertexes(); i++) {		
			//Si el estado es unvisited, hago el recorrido bfs con la Nodelist 
			if(visited[i] == State.unvisited){
				DFSPath(i, result);				
			}
		}
		return result;
		
	}

	// Inicializa herramientas basicas para realizar dfs
		private static void setInitialValues(Graph g){
			
			graph = g; 
			visited = new State[graph.getCantVertexes()];
			// Pongo todos los vertices en unvisited
					for (int i = 0; i < visited.length; i++) {
						visited[i] = State.unvisited;
					}
		}
	
}
