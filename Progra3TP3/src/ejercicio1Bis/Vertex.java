package ejercicio1Bis;

public class Vertex {
	
	State state;
	int value;
	int time;
	
	public Vertex(int value){
		this.value = value;
		state = State.unvisited;
		time = 0;
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
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public String toString(){
		
		return "" + value;
	}
	
	 
	
}
