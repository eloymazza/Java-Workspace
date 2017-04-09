package ejercicio5;

public class BinaryTree {

	Node root;
	
	public BinaryTree(Integer key){
		root = new Node(key);
	}
	public BinaryTree(Node root){
		this.root = root;
	}
	
	public Node getRoot(){
		return root;
	}
	
	public boolean isEmpty(){
		
		return root != null;
		
	}
	
	public void addNode(Integer key){
		Node newNode = new Node(key);
		addNode(newNode, root);
	}
	
	private void addNode(Node newNode, Node node) {
		
		if(node == null){
			node = newNode;
		}
		else{
			
			if(newNode.getKey() <= node.getKey()){
				if(node.getLeft() != null){
					addNode(newNode, node.getLeft());
				}
				else{
					node.setLeft(newNode);
				}
			}
			else{
				if(node.getRight() != null){
					addNode(newNode, node.getRight());
				}
				else{
					node.setRight(newNode);
				}
			}
		
		}
	}
	
	public boolean hasElem(Integer elem){
		
		return hasElem(root, elem);
		
	}
	
	private boolean hasElem(Node node, Integer elem) {
		
		if(node != null){
			if(node.getKey().equals(elem)){
				return true;
			}
			else{
				if(hasElem(node.getLeft(), elem)){
					return true;
				}
				if(hasElem(node.getRight(), elem)){
					return true;
				}
			}
		}
		return false;
	}
	
	public void printInOrder(){
		
		 printInOrder(root);
		
	}
	
	private void printInOrder(Node node) {
		
		if(node.getLeft() != null){
			printInOrder(node.getLeft());			
		}
		System.out.println(node.toString());
		if(node.getRight() != null){
			printInOrder(node.getRight());
		}
	
	}
	
	public static void main(String[] args) {
		
		BinaryTree t = new BinaryTree(5);
		
		t.addNode(4);
		t.addNode(2);
		t.addNode(6);
		t.addNode(10);
		
		t.printInOrder();
		
		System.out.println(t.hasElem(10));
	}
}
