package graph;


public class NonDirectedGraph extends Graph{

	public NonDirectedGraph(int cantVertexes) {
		super(cantVertexes);

	}
	
	public void addAdjacent(int origin, int destination) {
		
		super.addAdjacent(origin, destination);
		super.addAdjacent(destination, origin);	
	}

}
