package graphBest;



public class VertexNode {

	private Object element;
	private VertexNode next;
	private int weight;
	State state = State.unvisited;
	

	// Constructor para el nodo ponderado
	public VertexNode(Object element, VertexNode next, int weight){

		this.element = element;
		this.next = next;
		this.weight = weight;
		
	}
	
	// Constructor para nodo vertice
	public VertexNode(Object element){
		this.element = element;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public VertexNode getNext() {
		return next;
	}

	public void setNext(VertexNode next) {
		this.next = next;
	}

	public String toString(){
		return element.toString();
	}

}
