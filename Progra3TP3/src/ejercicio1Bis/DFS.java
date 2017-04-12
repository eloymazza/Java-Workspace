package ejercicio1Bis;

import java.util.*;

import ejercicio1.NodeList;


public class DFS {
	
	 private int time = 0;
	 private ArrayList<Vertex> vertexes;
	 private NodeList[] adjacents;
	 
	 public DFS (Graph g){
		 vertexes = g.getVertexes();
		 adjacents = g.getAdjacentList();
	 }
	 
	
	public ArrayList<Vertex> search(Graph graph){
	
		for (Vertex vertex : vertexes) {
			if(vertex.state == State.unvisited){
				search(vertex);
			}
		}
		time = 0;
		Collections.sort(vertexes, new VertexComparator());
		return vertexes;	
	}

	private  void search(Vertex vertex) {
		
		vertex.setState(State.visiting);
		
		vertex.setTime(time);
		time++;
		
		int value = vertex.getvalue();
		int currentAdjacent;
		if(adjacents[value] != null){
			for (int i = 0; i < adjacents[value].size(); i++) {				
				currentAdjacent = (int) adjacents[value].getElementAt(i);
				for (Vertex v : vertexes) {
					if(v.getvalue() == currentAdjacent && (v.state == State.unvisited)){
						search(v);
						break;
					}
				}
			}
		}
		
		vertex.setState(State.visited);
		
		
	}
	
	public  ArrayList<Vertex>  iterativeSearch(Graph graph){

		
		Stack<Vertex> s = new Stack<Vertex>();
		int time = 0;
		
		s.push(vertexes.get(0));
		
		NodeList currentAdjacents;
		int targetValue;
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
								time++;
								vertex.setTime(time);
								vertex.setState(State.visiting);
								s.push(vertex);
								i = currentAdjacents.size();
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
	
		}while(!s.isEmpty());
		
		Collections.sort(vertexes, new VertexComparator());
		time = 0;
		return vertexes;
		
		
	}

	
}
