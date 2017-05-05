package graphBestII;

import java.util.Stack;

public class DFS {
	
	private static Graph graph;
	private static State [] visited;
	
	
	// Realiza DFS recursivo y retorna lista de vertices por los que fue pasando
	public static NodeList DFSPath(Graph g){
		
		NodeList result = new NodeList();
		setInitialValues(g);
				
		// Itero sobre cada vertice agregandole a result los nodos por los que voy pasando
		for (int i = 0; i < graph.getCantVertexes(); i++) {		
			//Si el estado es unvisited, hago el recorrido dfs con la Nodelist 
			if(visited[i] == State.unvisited){
				DFSPath(i, result);				
			}
		}
		return result;
		
	}
	
	// Repito dfs  por cada nodo que tengo
	private static NodeList DFSPath(int vertex, NodeList result) {
		
		visited[vertex] = State.visiting;
		result.insertAtEnd(vertex);
		
		if(graph.getAdjacents(vertex) != null){	
			NodeList currentAdjacents = graph.getAdjacents(vertex);
			int length = currentAdjacents.size();
			int currentVertex;
			for (int i = 0; i < length; i++) {
				
				currentVertex =(int)currentAdjacents.getElementAt(i);
				if(visited[currentVertex] == State.unvisited){
					DFSPath(currentVertex, result);
				}
			}
		}	
			
		visited[vertex] = State.visited;
		return result;
	}
	
	public static NodeList DFSPathIterative(Graph g){
		
		NodeList result = new NodeList();
		Stack<Integer> s = new Stack<Integer>();
		setInitialValues(g);
		
		s.push(0);
		visited[0] = State.visiting;
		result.insertAtEnd(0);
		NodeList currentAdjacents;
		boolean allVisited = true;
		do{
			currentAdjacents = graph.getAdjacents(s.peek());
			if(currentAdjacents != null){
				allVisited = true;
				for (int i = 0; i < currentAdjacents.size(); i++) {
					if(visited[(int)currentAdjacents.getElementAt(i)] == State.unvisited){
						s.push((Integer) currentAdjacents.getElementAt(i));
						visited[s.peek()] = State.visiting;
						result.insertAtEnd(s.peek());
						i = currentAdjacents.size();
						allVisited = false;
					}
				}
			}
			if(allVisited || currentAdjacents == null){
				visited[s.peek()] = State.visited;
				s.pop();					
			}			
		}while(!s.isEmpty());
		
		return result;
	}
	
	// Utilizo dfs recursivo para encontrar ciclos en un grafo
	public static boolean hasCycle(Graph g){
		
		setInitialValues(g);
		for (int i = 0; i < graph.getCantVertexes(); i++) {
			if(visited[i] == State.unvisited && hasCycle(i)){
				return true;
			}	
		}
		return false;
	}
	
	private static boolean hasCycle(int vertex) {

		visited[vertex] = State.visiting;
		
		
		if(graph.getAdjacents(vertex) != null){
			
			NodeList currentAdjacents = graph.getAdjacents(vertex);
			int length = currentAdjacents.size();
			int currentVertex;
			
			for (int i = 0; i < length; i++) {
				currentVertex = (int)currentAdjacents.getElementAt(i);
				if(visited[currentVertex] == State.visiting){
					return true;
				}
				if(visited[currentVertex] == State.unvisited){
					if(hasCycle(currentVertex)){
						return true;
					}
				}
			}			
		}
		visited[vertex] = State.visited;
		return false;
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
