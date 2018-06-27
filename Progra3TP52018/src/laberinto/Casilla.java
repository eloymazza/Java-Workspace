package laberinto;

public class Casilla {

	
	protected Integer id;
	protected boolean up;
	protected boolean down;
	protected boolean right;
	protected boolean left;
	
	public Casilla(Integer id, boolean []vecinos){
		this.id = id;
		setVecinos(vecinos);	
	}
	

	private void setVecinos(boolean[] vecinos) {
		up = vecinos[0];
		right = vecinos[1];
		down = vecinos[2];
		left = vecinos[3];
	}
	

	public boolean getUp() {
		return up;
	}

	public boolean getDown() {
		return down;
	}

	public boolean getRight() {
		return right;
	}

	public boolean getLeft() {
		return left;
	}
	
	public String toString(){
		return this.id.toString();
	}
	
	public boolean equals(Object o){
		return this.id.equals(((Casilla) o).getID());
	}


	public Integer getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
