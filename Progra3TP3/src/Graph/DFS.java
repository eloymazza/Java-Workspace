package Graph;

import java.util.*;



public class DFS {
	
	 private ArrayList<Vertex> vertexes;
	 private NodeList[] adjacents;
	 private boolean cycleDetected;
	 
	 public DFS (Graph g){
		 vertexes = g.getVertexes();
		 adjacents = g.getAdjacentList();
		 cycleDetected = false;
	 }
	 
	
	 //DFS RECURSIVO
	public boolean search(Graph graph){
		
		for (Vertex vertex : vertexes) {
			if(vertex.state == State.unvisited && cycleDetected == false){
				cycleDetected = search(vertex);
				
			}
		}
		return cycleDetected;	
	}

	private  boolean search(Vertex vertex) {
		
		vertex.setState(State.visiting);
		
		int value = vertex.getvalue();
		int currentAdjacent;
		if(adjacents[value] != null){
			for (int i = 0; i < adjacents[value].size(); i++) {				
				currentAdjacent = (int) adjacents[value].getElementAt(i);
				for (Vertex v : vertexes) {
					if(v.getvalue() == currentAdjacent){
						if(v.state == State.unvisited){
							cycleDetected = search(v);
						}
						else if(v.state == State.visiting){
							 cycleDetected = true;
						}	
					}
				}
			}
		}
		vertex.setState(State.visited);
		return cycleDetected;
	}
	
	
	//DFS ITERATIVO
	public  boolean  iterativeSearch(Graph graph){

		
		Stack<Vertex> s = new Stack<Vertex>();
		NodeList currentAdjacents;
		int targetValue;
		
		s.push(vertexes.get(0));
;		s.peek().setState(State.visiting);
		
		do{
			currentAdjacents = adjacents[s.peek().getvalue()];
			if(currentAdjacents != null){
				for (int i = 0; i < currentAdjacents.size(); i++) {
					targetValue = (int) currentAdjacents.getElementAt(i);
					currentAdjacents.removeFirst();
					if(currentAdjacents.isEmpty()){
						adjacents[s.peek().getvalue()] = null;
					}
					for (Vertex vertex : vertexes) {
						if(vertex.getvalue() == targetValue){
							if(vertex.state == State.unvisited){
								vertex.setState(State.visiting);
								s.push(vertex);
								i = currentAdjacents.size();
								break;
							}
							else if(vertex.state == State.visiting){
								cycleDetected = true;
								break;
							}
						}
					}
				}
			}
			else{
				s.peek().setState(State.visited);
				s.pop();
			}
	
		}while(!s.isEmpty() && !cycleDetected);
		
		return cycleDetected;
		
		
	}

	
}
