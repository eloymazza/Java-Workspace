package ejercicio6;
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
		return key.toString();
	}	
	
	public boolean noChilds(){
		return left == null && right == null; 
	}

	public boolean hasAChild() {
		if(left == null){
			return right != null;
		}
		return right == null;
	}

	public Node getAChild() {
		if(left != null){
			return left;
		}
		return right;
	}

	

}
