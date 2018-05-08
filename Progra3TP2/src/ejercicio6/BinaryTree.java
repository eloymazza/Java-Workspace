package ejercicio6;
import java.util.*;



public class BinaryTree {

	Node root;
	
	public BinaryTree(){
		root = new Node();
	}
	
	public BinaryTree(Comparable<Object> object){
		root = new Node(object);
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
	
	public void insert(Comparable<Object> object){
			addNode(object, root);			
	}
	
	private void addNode(Comparable<Object> object, Node node) {
		
		if(node.isEmpty()){
			node.setObject(object);
			node.setLeft(new Node());
			node.setRight(new Node());
		}
		else{
			if(!object.equals(node.getObject())){
				if(node.getObject().compareTo(object) > -1){
					addNode(object, node.getLeft());
				}
				else{
					addNode(object, node.getRight());
				}
			}			
		}
		
	}
	
	public boolean hasElem(Comparable<Object> object){	
		return hasElem(root, object);	
	}
	
	private boolean hasElem(Node node, Comparable<Object> object){
		
		if(!node.isEmpty()){
			Comparable<Object> currentObject = node.getObject();
			if(currentObject.equals(object)){
				return true;
			}
			else{
				if(currentObject.compareTo(object) < 1){
					return hasElem(node.getLeft(), object);
				}
				else{
					return hasElem(node.getRight(), object);
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
		System.out.println(node.getObject().toString());
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
		System.out.println(node.getObject().toString());
	}
	
	public void printPreOrder() {
		if(!isEmpty()){
			printPreOrder(root);	
		}
	}
	
	private void printPreOrder(Node node) {
		System.out.println(node.getObject().toString());
		if(!node.getLeft().isEmpty()){
			printPreOrder(node.getLeft());			
		}
		if(!node.getRight().isEmpty()){
			printPreOrder(node.getRight());
		}
	}
	
	
	public boolean delete(Object elem){
			return delete(root, elem);
	}
	
	
	private boolean delete(Node currentNode, Object object) {
		
		if(!currentNode.isEmpty()){
			if(currentNode.getObject().equals(object)){
				currentNode.replace(replaceNode(currentNode));
				return true;				
			}
			else{
				if(currentNode.getObject().compareTo(object) > -1){
					 return delete(currentNode.getLeft(), object);					
				}
				else{
					return delete(currentNode.getRight(), object);				
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
		Node nmd = new Node(getNMD(targetNode.getLeft()));
		delete(nmd.getObject());
		nmd.setRight(targetNode.getRight());
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
		if(!isEmpty()){
			int maxHeight = -1;
			return getHeight(root, level, maxHeight);
		}
		return level;
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
		
		List<Node> frontera = new LinkedList<Node>();
		return getFrontera(root, frontera);
		
	}
	
	private List<Node> getFrontera(Node currentNode, List<Node> frontera) {
		
		Node left = currentNode.getLeft();
		Node right = currentNode.getRight();
		if(currentNode.noChilds()){
			frontera.add(currentNode);
		}
		else{
			if(!left.isEmpty()){
				frontera = getFrontera(left, frontera);				
			}
			if(!right.isEmpty() ){
				frontera = getFrontera(right,frontera);
			}
		}
		return frontera;
	}
	
	public Node getMaxElem() {
		return getMaxElem(root); 
	}
	
	private Node getMaxElem(Node currentNode) {
		
		if(!currentNode.getRight().isEmpty()){
			return getMaxElem(currentNode.getRight());
		}
		return currentNode;
	}
	
	public List<Node> getElemAtLevel(int targetLevel) {
		
		if(getHeight() >= targetLevel && targetLevel > -1){
			int currentLevel = 0;
			return getElemAtLevel(root, targetLevel, currentLevel);
		}
		return null;
	}
	
	private List<Node> getElemAtLevel(Node node, int targetLevel, int currentLevel){
		
		List<Node> elements = new LinkedList<Node>();
		if(currentLevel == targetLevel){
			elements.add(node);
		}
		else{
			currentLevel++;
			if(!node.getLeft().isEmpty()){
				elements.addAll(getElemAtLevel(node.getLeft(), targetLevel, currentLevel));
			}
			if(!node.getRight().isEmpty()){
				elements.addAll(getElemAtLevel(node.getRight(), targetLevel, currentLevel));
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
		if(!node.isEmpty()){
			lb.add(node);
			Node left = node.getLeft();
			Node right = node.getRight();
			
			if(!left.isEmpty() || !right.isEmpty()){
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
		
		private Comparable<Object> object;
		private Node left;
		private Node right;
			
		public Node(){
			object = null;
			left = null;
			right = null;
		}
		
		public void replace(Node replaceNode) {
			object = replaceNode.getObject();
			left = replaceNode.getLeft();
			right = replaceNode.getRight();
			
		}

		public Node(Comparable<Object> object){
			this.object = object;
			left = new Node();
			right = new Node();
		}
		
		public Node(Node base){
			this.object = base.getObject();
			this.left = base.getLeft();
			this.right = base.getRight();
		}
		
		public Comparable<Object> getObject() {
			return object;
		}
		

		public void setObject(Comparable<Object> object) {
			this.object = object;
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
			if(object != null){
				return object.toString();				
			}
			return null;
		}	
		
		public boolean isEmpty() {
			return object == null;
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
		
		t.insert(new Thing("m"));
		t.insert(new Thing("f"));
		t.insert(new Thing("u"));
		t.insert(new Thing("c"));
		t.insert(new Thing("p"));
		t.insert(new Thing("h"));
		t.insert(new Thing("v"));

		System.out.println(t.getElemAtLevel(2));
		
		t.printInOrder();

		
		/* Complejidad de los metodos Insert y hasElem
		 	El costo de los metodos insert(Object) y hasElem(Object) en el peor de los casos
		 	es O(Log2N). Como al arbol le podemos aplicar una busqueda binaria, el metodo
		 	hasElem tiene una complejidad O(Log2N), ya que (si el arbol esta balanceado)
		 	se descarta en cada iteracion la mitad del arbol. Como para insertar
		 	un elemento se debe buscar primero el padre, tambien la insercion tiene la misma complejidad
		 	que una busqueda (mas un paso, el de agregar, que no influye en la 
		 	complejidad).
		*/

	}

}
