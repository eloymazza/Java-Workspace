package Graph;


public class NonDirectedGraph extends Graph{

	public NonDirectedGraph(int vertexes) {
		super(vertexes);
	}

	@Override 
	/* Agrega adyacentes a un vertice, con la diferencia de que tambien le agrega
	*  1a destino el vertice origen como adyacente
	*/
	public void addAdjacent(int origin, int destination) {

		int length = adjacents.length;
		if( (origin < length && origin >= 0) && (destination < length && destination >= 0)){

			if(adjacents[origin] == null){
				adjacents[origin] = new NodeList();
			}
			if(!hasEdge(origin, destination)){
				adjacents[origin].insertAtEnd(destination);
				adjacents[destination].insertAtEnd(origin);
			}
		}

	}

	@Override
	public void fillGraph(int maxEdges,  boolean hasCycles) {
		// TODO Auto-generated method stub
		
	}



}
