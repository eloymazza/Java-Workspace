package Graph;

public class Vertex {
	
	State state;
	int value;
	
	public Vertex(int value){
		this.value = value;
		state = State.unvisited;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getvalue() {
		return value;
	}

	public void setvalue(int value) {
		this.value = value;
	}
	
	public String toString(){	
		return "" + value;
	}
	
}
