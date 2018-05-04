package ejercicio6;

import java.util.*;

public class BinaryTree {

	Node root;
	
	public BinaryTree(){
		root = new Node();
	}
	
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
		
		return root.isEmpty();
		
	}
	
	public void insert(Integer key){
			addNode(key, root);			
	}
	
	private void addNode(Integer key, Node node) {
		
		if(node.isEmpty()){
			node.setKey(key);
			node.setLeft(new Node());
			node.setRight(new Node());
		}
		else{
			if(key != node.getKey()){
				if(key < node.getKey()){
					addNode(key, node.getLeft());
				}
				else{
					addNode(key, node.getRight());
				}
			}			
		}
		
	}
	
	public boolean hasElem(Integer elem){	
		return hasElem(root, elem);	
	}
	
	private boolean hasElem(Node node, Integer elem){
		
		if(!node.isEmpty()){
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
		
		if(!node.getLeft().isEmpty()){
			printInOrder(node.getLeft());			
		}
		System.out.println(node.toString());
		if(!node.getRight().isEmpty()){
			printInOrder(node.getRight());
		}
	
	}
	
	public void printPostOrder() {
		if(!isEmpty()){
			printPostOrder(root);	
		}
	}
	
	private void printPostOrder(Node node) {
		if(!node.getLeft().isEmpty()){
			printPostOrder(node.getLeft());			
		}
		if(!node.getRight().isEmpty()){
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
		if(!node.getLeft().isEmpty()){
			printPreOrder(node.getLeft());			
		}
		if(!node.getRight().isEmpty()){
			printPreOrder(node.getRight());
		}
	}
	
	public boolean delete(Integer elem){
			return delete(root, elem);
	}
	
	private boolean delete(Node currentNode, Integer elem) {
		
		if(!currentNode.isEmpty()){
			if(currentNode.getKey().equals(elem)){
				Node replaceNode = replaceNode(currentNode);
				currentNode.setKey(replaceNode.getKey());
				currentNode.setLeft(replaceNode.getLeft());
				currentNode.setRight(replaceNode.getRight());
				return true;				
			}
			else{
				if(currentNode.getKey() > elem){
					 return delete(currentNode.getLeft(), elem);					
				}
				else{
					return delete(currentNode.getRight(), elem);				
				}	
			}
		}
		else{
			return false;
		}
			
	}
	

	private Node replaceNode(Node targetNode) {
		if(targetNode.noChilds()){
			return new Node();
		}
		if(targetNode.hasAChild()){
			return targetNode.getAChild();
		}
		Node nmd = getNMD(targetNode.getLeft());
		Integer nmdKey = nmd.getKey();
		delete(targetNode.getKey());
		nmd.setLeft(targetNode.getLeft());
		nmd.setRight(targetNode.getRight());
		nmd.setKey(nmdKey);
		return nmd;
	}
	
	//Nodo mas derecho del arbol izquierdo
	private Node getNMD(Node node) {
		
		if(node.getRight().isEmpty()){
			return node;
		}
		return getNMD(node.getRight());
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
				if(!node.getLeft().isEmpty()){
					maxHeight = getHeight(node.getLeft(), level, maxHeight);
				}
				if(!node.getRight().isEmpty()){
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
	
	public LinkedList<Node>getLongestBranch(){
		
		if(!isEmpty()){
			return getLongestBranch(root);
		}
		return null;
	}
	
	private LinkedList<Node> getLongestBranch(Node node) {
		
		LinkedList<Node> lb = new LinkedList<Node>();
		if(node != null){
			lb.add(node);
			Node left = node.getLeft();
			Node right = node.getRight();
			
			if(left != null || right != null){
				LinkedList<Node> lbl = getLongestBranch(left);
				LinkedList<Node> lbr = getLongestBranch(right);
				if(lbl.size() > lbr.size()){
					lb.addAll(lbl);
				}				
				else{
					lb.addAll(lbr);
				}				
			}

			return lb;
		}
		return lb;
		
	}
	
	class Node {
		
		private Integer key;
		private Node left;
		private Node right;
			
		public Node(){
			key = null;
			left = null;
			right = null;
		}
		
		public Node(Integer key){
			this.key = key;
			left = null;
			right = null;
		}
		
		public Node(Node base){
			this.key = base.getKey();
			this.left = base.getLeft();
			this.right = base.getRight();
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
			if(key != null){
				return key.toString();				
			}
			return null;
		}	
		public boolean isEmpty() {
			return key == null;
		}
		
		public boolean noChilds(){
			return left.isEmpty() && right.isEmpty(); 
		}

		public boolean hasAChild() {
			if(left.isEmpty()){
				return !right.isEmpty();
			}
			return right.isEmpty();
		}

		public Node getAChild() {
			if(!left.isEmpty()){
				return left;
			}
			return right;
		}
		
	}
	
	public static void main(String[] args) {
		
		BinaryTree t = new BinaryTree();
		
		
		t.insert(8);
		t.insert(10);
		t.insert(5);
		t.insert(12);
		t.insert(9);
		t.printInOrder();
		System.out.println(t.delete(10));
		t.printInOrder();
		/*
		System.out.println(t.hasElem(13));
		System.out.println(t.getHeight());
		System.out.println("In Order: ");
		t.printInOrder();
		System.out.println("Pre Order: ");
		t.printPreOrder();
		System.out.println("Post Order: ");
		t.printPostOrder();
		System.out.println(t.getHeight());
		System.out.println(t.getFrontera());
		System.out.println(t.getMaxElem());
		System.out.println(t.getElemAtLevel(10));
		System.out.println("Longest Branch:");
		System.out.println(t.getLongestBranch());
		 */
		
		/*

		
		 * Complejidad de los metodos Insert y hasElem
		 	El costo de los metodos insert(Integer) y hasElem(Integer) en el peor de los casos
		 	es O(Log2N). Como al arbol le podemos aplicar una busqueda binaria, el metodo
		 	hasElem tiene una complejidad O(Log2N), ya que (si el arbol esta balanceado)
		 	se descarta en cada iteracion la mitad del arbol. Como para insertar
		 	un elemento se debe buscar primero el padre, tambien la insercion tiene la misma complejidad
		 	que una busqueda (mas un paso, el de agregar, que no influye en la 
		 	complejidad).
		*/

	}

}
