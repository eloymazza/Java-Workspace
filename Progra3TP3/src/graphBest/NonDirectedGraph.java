package graphBest;

public class NonDirectedGraph extends Graph{

	public NonDirectedGraph(int cantVertexes) {
		super(cantVertexes);

	}
	
	public void addAdjacent(int origin, int destination, int weight) {
		
		super.addAdjacent(origin, destination, weight);
		super.addAdjacent(destination, origin, weight);	
	}

}
