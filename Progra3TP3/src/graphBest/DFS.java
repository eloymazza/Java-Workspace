 package graphBest;

import graph.State;

public class DFS {
	
	public static GraphNodeList[] adjacentsList;
	public static VertexNode[] vertexes;

	public static boolean hasCycle(Graph graph){
		
		adjacentsList = graph.getAdjacentList();
		vertexes = new VertexNode[adjacentsList.length];
		
		for (int i = 0; i < vertexes.length; i++) {
			vertexes[i] = new VertexNode(i);
		}
		
		for (VertexNode v : vertexes) {
			if(v.getState() == State.unvisited && hasCycle(v)){
				return true;
			}
		}
		return false;
		
	}

	private static  boolean hasCycle(VertexNode v) {
		
		v.setState(State.visiting);
		System.out.println(v.getElement());
		
		GraphNodeList CurrentVertexAdjacents = adjacentsList[(int)v.getElement()];
		if(CurrentVertexAdjacents != null){
			
			int currentVertexValue;
			for (int i = 0; i < CurrentVertexAdjacents.size(); i++) {
				
				currentVertexValue = (int) CurrentVertexAdjacents.getElementAt(i);
				for (VertexNode adjacent : vertexes) {
					if(adjacent.getElement().equals(currentVertexValue) && (adjacent.getState() != State.visited)){
						if(adjacent.getState() == State.visiting){
							return true;
						}
						if(hasCycle(adjacent)){
							return true;
						}
						break;
					}
				}
			}
			
		}
		v.setState(State.visited);
		return false;
		
	}
	
}
