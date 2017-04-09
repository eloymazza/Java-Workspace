package ejercicio5;

public class Node {
	
	private Integer key;
	private Node left;
	private Node right;
		
	public Node(Integer key){
		
		this.key = key;
		
	}

	public Integer getKey() {
		return key;
	}


	public void setKey(Integer key) {
		this.key = key;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}


	public Node getRight() {
		return right;
	}


	public void setRight(Node right) {
		this.right = right;
	}
	
	
	public String toString() {
		// TODO Auto-generated method stub
		return key.toString();
	}	

	

}
