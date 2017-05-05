package graphBestII;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	private static Graph graph;
	private static State [] visited;
	
	public static NodeList BFSPath(Graph graph){
		
		NodeList result = new NodeList();
		setInitialValues(graph);
		Queue <Integer> q = new LinkedList<Integer>();
		
		q.add(0);
		result.insertAtEnd(0);
		
		Integer currentVertex;
		NodeList currentAdjacents;
		
		while(!q.isEmpty()){
			
			currentVertex = q.remove();
			currentAdjacents = graph.getAdjacents(currentVertex);
			visited[currentVertex] = State.visiting;
			
			if(currentAdjacents != null){
				Integer adjacent;
				for (int i = 0; i < currentAdjacents.size(); i++) {
					adjacent =(Integer) currentAdjacents.getElementAt(i);
					if(visited[adjacent] == State.unvisited){
						q.add(adjacent);
						visited[adjacent] = State.visiting;
						result.insertAtEnd(adjacent);
					}	
				}
				
			visited[currentVertex] = State.visited;
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
