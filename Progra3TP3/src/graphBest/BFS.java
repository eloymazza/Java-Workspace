package graphBest;
import graphBestII.State;

import java.util.*;

public class BFS {

	public static GraphNodeList[] adjacentsList;
	public static VertexNode[] vertexes;
	public static int vertexLevel[]; 
	
	public static GraphNodeList search(Graph g){
		
		GraphNodeList[] adjacentsList = g.getAdjacentList();
		vertexes = new VertexNode[adjacentsList.length];
		GraphNodeList result = new GraphNodeList();
		
		for (int i = 0; i < vertexes.length; i++) {
			vertexes[i] = new VertexNode(i);
		}
		
		Queue<VertexNode> q = new LinkedList<VertexNode>();
		vertexLevel = new int[vertexes.length];
		
		for(VertexNode v : vertexes) {
			v.setD(0);
		}
		
		vertexes[0].setD(0);
		q.add(vertexes[0]);
		
		int currentVertexValue;
		VertexNode currentVertex;
		GraphNodeList currentAdjacents;
		int level = 0;
		while(!q.isEmpty()){
			currentVertexValue = (int) q.remove().getElement();
			currentVertex = vertexes[currentVertexValue];
			currentAdjacents = adjacentsList[currentVertexValue];
			level++;
			
				if(currentAdjacents != null){					
					for (int i = 0; i < currentAdjacents.size(); i++) {
						
						VertexNode v = vertexes[(int)currentAdjacents.getNodeAt(i).getElement()];
						if(v.getState() == State.unvisited){
							v.setState(State.visiting);
							v.setD(vertexes[currentVertexValue].getD() +1);
							vertexLevel[(int)v.getElement()] = level;
							q.add(v);
							
						}
					}
				}
				currentVertex.setState(State.visited);
		}
			for (int i = 0; i < adjacentsList.length; i++) {
				for (VertexNode vertex : vertexes) {
					if(vertex.getD() == i){
						result.insertAtEnd(vertex.getElement(), 0);
					}
				}
			}
		return result;
	}
	
	
}
