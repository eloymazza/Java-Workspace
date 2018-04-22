package ejercicio6;
import java.util.*;

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
		
		return root == null;
		
	}
	
	public void insert(Integer key){
		if(!hasElem(key)){
			Node newNode = new Node(key);
			addNode(newNode, root);			
		}
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
	
	private boolean hasElem(Node node, Integer elem){
		
		if(node != null){
			Integer currentKey = node.getKey();
			if(elem == currentKey){
				return true;
			}
			else{
				if(elem < currentKey){
					return hasElem(node.getLeft(), elem);
				}
				else if(elem > currentKey){
					return hasElem(node.getRight(), elem);
				}
			}
		}
		return false;
	}
	
	public void printInOrder(){
		if(!isEmpty()){
			printInOrder(root);	
		}
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
	
	public void printPostOrder() {
		if(!isEmpty()){
			printPostOrder(root);	
		}
	}
	
	private void printPostOrder(Node node) {
		if(node.getLeft() != null){
			printPostOrder(node.getLeft());			
		}
		if(node.getRight() != null){
			printPostOrder(node.getRight());
		}
		System.out.println(node.toString());
	}
	
	public void printPreOrder() {
		if(!isEmpty()){
			printPreOrder(root);	
		}
	}
	
	private void printPreOrder(Node node) {
		System.out.println(node.toString());
		if(node.getLeft() != null){
			printPreOrder(node.getLeft());			
		}
		if(node.getRight() != null){
			printPreOrder(node.getRight());
		}
	}
	
	public boolean delete(Integer elem){
		
		Integer rootKey = root.getKey();
		
		if(hasElem(elem)){
			if(rootKey == elem){
				root = null;
				return true;
			}
			return delete(root, elem);
		}
		return false;
	}
	
	private boolean delete(Node currentNode, Integer elem) {
		
		Node left = currentNode.getLeft();
		Node right = currentNode.getRight();
		
		if(currentNode.getKey() > elem){
			if(left.getKey() == elem){
				currentNode.setLeft(removeNode(left));	
				return true;
			}
			else{
				return delete(left, elem);
			}
		}
		else{
			if(right.getKey() == elem){
				currentNode.setRight(removeNode(right));
				return true;
			}
			else{
				return delete(right, elem);				
			}
		}
		
	}
	

	private Node removeNode(Node targetNode) {
		if(targetNode.noChilds()){
			return null;
		}
		if(targetNode.hasAChild()){
			return targetNode.getAChild();
		}
		Node nmi = getNMI(targetNode.getLeft());
		delete(targetNode, nmi.getKey());
		nmi.setLeft(targetNode.getLeft());
		nmi.setRight(targetNode.getRight());
		return nmi;
	}
	
	//Nodo mayor izquierdo del arbol derecho
	private Node getNMI(Node node) {
		
		if(node.getRight() == null){
			return node;
		}
		return getNMI(node.getRight());
	}
	
	public int getHeight(){
		
		int level = -1;
		int maxHeight = -1;
		
		if(isEmpty()){
			return maxHeight;
		}
		return getHeight(root, level, maxHeight);
		
	}
	
	
	private int getHeight(Node node, int level, int maxHeight) {
		
			level++;
			if(node.noChilds()){
				if(level > maxHeight){
					maxHeight = level;
				}				
			}else{
				if(node.getLeft() != null){
					maxHeight = getHeight(node.getLeft(), level, maxHeight);
				}
				if(node.getRight() != null){
					maxHeight = getHeight(node.getRight(), level, maxHeight);
				}				
			}
			return maxHeight;
		
	}
	
	public List<Node> getFrontera(){
		
		if(!isEmpty()){
			List<Node> frontera = new LinkedList<Node>();
			return getFrontera(root, frontera);
		}
		return null;
	
	}
	
	private List<Node> getFrontera(Node currentNode, List<Node> frontera) {
		
		Node left = currentNode.getLeft();
		Node right = currentNode.getRight();
		
		if(currentNode.noChilds()){
			frontera.add(currentNode);
		}
		else{
			if(left != null){
				frontera = getFrontera(left, frontera);				
			}
			if(right != null){
				frontera = getFrontera(right,frontera);
			}
		}
		return frontera;
	}
	
	public Node getMaxElem() {
		
		if(!isEmpty()){
			return getMaxElem(root); 
		}
		return null;
	}
	
	private Node getMaxElem(Node currentNode) {
		
		if(currentNode.getRight() != null){
			return getMaxElem(currentNode.getRight());
		}
		return currentNode;
	}
	
	public List<Node> getElemAtLevel(int targetLevel) {
		
		if(getHeight() >= targetLevel){
			List<Node> elements = new LinkedList<Node>();
			if(targetLevel == 0){
				elements.add(root);
				return elements;
			}
			int currentLevel = -1;
			return getElemAtLevel(root, targetLevel, currentLevel, elements);
		}
		return null;
	}
	
	private List<Node> getElemAtLevel(Node node, int targetlevel, int currentLevel, List<Node> elements){
		
		Node left = node.getLeft();
		Node right = node.getRight();
		currentLevel++;
		if(currentLevel == targetlevel-1){
			if(left != null){
				elements.add(left);
			}
			if(right != null){
				elements.add(right);
			}
		}
		else{
			if(left != null){
				elements = getElemAtLevel(left, targetlevel, currentLevel, elements);
			}
			if(right != null){
				elements = getElemAtLevel(right, targetlevel, currentLevel, elements);
			}
		}
		return elements;
	}
	

	
	public static void main(String[] args) {
		
		BinaryTree t = new BinaryTree(5);
		
		t.insert(4);
		t.insert(2);
		t.insert(8);
		t.insert(6);
		t.insert(7);
		t.insert(10);
		t.insert(11);
		t.insert(12);
		t.insert(13);
		t.insert(14);
		
		System.out.println("In Order: ");
		t.printInOrder();
		System.out.println("Pre Order: ");
		t.printPreOrder();
		System.out.println("Post Order: ");
		t.printPostOrder();
		
		System.out.println(t.hasElem(5));
		System.out.println(t.getHeight());
		System.out.println(t.delete(14));
		t.printInOrder();
		System.out.println(t.getHeight());
		System.out.println(t.getFrontera());
		System.out.println(t.getMaxElem());
		System.out.println(t.getElemAtLevel(10));
		System.out.println("Longest Branch:");
		System.out.println(DFSTree.getLongestBranch(t));

	}

}
