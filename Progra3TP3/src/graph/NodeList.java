package graph;

public class NodeList {

	private Node root;
	private int size = 0;

	public NodeList(){
		root = null;
	}

	public boolean isEmpty(){
		return root == null;
	}

	public int size(){
		return size;
	}

	public void insertAtStart(Object o){

		Node newNode = new Node(o, null);
		newNode.setNext(root);
		root = newNode;
		size++;	
	}

	public void insertAtEnd(Object o){

		if(isEmpty()){
			insertAtStart(o);
		}
		else{
			Node aux = root;
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			aux.setNext(new Node(o,null));
			size++;
		}

	}

	public void insertAt(int pos, Object o){

		if(pos < size() && pos >= 0){	
			if(pos == 0){
				insertAtStart(o);
			}
			else if( pos == size()-1){
				insertAtEnd(o);
			}
			else{
				int count = 0;
				Node aux = root;
				while(count < size()-1){
					if(count == pos){
						Node newNode = new Node(o, aux.getNext());
						aux.setNext(newNode);
						size++;
						count = size();
					}
					else{
						aux = aux.getNext();
						count++;
					}
				}
			}
		}

	}


	public Object getElementAt(int pos){

		if( pos >= 0  && pos < size() ){	
			int count = 0;
			Node aux = root;
			while(pos != count){
				aux = aux.getNext();
				count++;
			}
			return aux.getElement();
		}
		return null;
	}

	public void removeFirst(){

		if(!isEmpty()){
			Node temp = root;
			root = root.getNext();	
			temp.setNext(null);
			size--;
		}	
	}

	public void removeLast(){

		if(size() <= 1){
			removeFirst();
		}
		else{
			Node aux = root;
			int count = 0;
			while(count < size()-2){
				aux = aux.getNext();
				count++;
			}
			aux.getNext().setNext(null);
			aux.setNext(null);
			size--;
		}

	}

	public void removeAll(){

		if(!isEmpty()){
			while(root.getNext() != null){
				Node temp = root.getNext();
				root.setNext(null);;
				root = temp;
			}
			root = null;
			size = 0;
		}

	}

	public boolean removeFirstOcurrence(Object o){

		if(!isEmpty()){
			if (root.getElement().equals(o)) {
				removeFirst();
				size--;
				return true;
			}
			else{
				Node aux = root;
				while(aux.getNext() != null){
					if(aux.getNext().getElement().equals(o)){
						Node temp = aux.getNext().getNext();
						aux.getNext().setNext(null);
						aux.setNext(temp);
						size--;
						return true;
					}
					aux = aux.getNext();
				}
				
				if(aux.getElement().equals(o)){
					System.out.println("entro");
					removeLast();
					size--;
					return true;
				}
			}	
		}
		return false;
	}


	//EJERCICIO 4
	public Object max(){

		if(isEmpty()){	
			return null;
		}
		else if(size() == 1){
			return root.getElement();
		}
		Node aux = root;
		Object max = root.getElement();
		Object current = null;
		int pos = 0;
		while(pos < size){
			current = aux.getElement();
			if((int)max < (int)current){
				max = current;
			}
			aux = aux.getNext();
			pos++;
		}
		return max;
	}

	public boolean contains(Object o){

		if(!isEmpty()){	
			int count = 0;
			Node aux = root;
			while(count < size()){
				if(aux.getElement().equals(o)){
					return true;
				}
				aux = aux.getNext();
				count++;
			}
		}
		return false;
	}

	public static NodeList createIntersectionList(NodeList a, NodeList b){

		NodeList newList = new NodeList();

		for (int i = 0; i < a.size(); i++) {

			Object element = a.getElementAt(i);
			if(b.contains(element)){
				newList.insertAtStart(element);
			}	
		}
		return newList;
	}
	
	public static NodeList createDisjunctionList(NodeList a, NodeList b){
		
		NodeList newList = new NodeList();

		for (int i = 0; i < a.size(); i++) {

			Object element = a.getElementAt(i);
			if(!b.contains(element)){
				newList.insertAtStart(element);
			}	
		}
		return newList;
	}
		
	public static NodeList sort(NodeList l) {

		NodeList newList = new NodeList();
		while(!l.isEmpty()){
			Object max = l.max();
			l.removeFirstOcurrence(max);
			newList.insertAtStart(max);
		}
		return  newList;
	}

	public String toString(){

		String result = "";
		Node aux = root;
		while(aux != null){
			result += aux.getElement() + " ";
			aux = aux.getNext();
		}

		return result;
	}



	public static void main(String[] args) {

		NodeList l1 = new NodeList();
		NodeList l2 = new NodeList();

		l1.insertAtEnd(4);
		l1.insertAtEnd(3);
		l1.insertAtEnd(2);
		l1.insertAtEnd(1);
		
		l2.insertAtEnd(5);
		l2.insertAtEnd(1);
		l2.insertAtEnd(3);
		l2.insertAtEnd(2);
		
		NodeList l3 = sort(createDisjunctionList(l1,l2));
		System.out.println(l3);
	

		/*
		for (int i = 0; i < 100; i++) {		
			l1.insertAtEnd((int)Math.floor(Math.random()*100));
		}
		System.out.println(l1.max());
		System.out.println(l1.toString());
		 */

		/* TESTING TESTING TESTING TESTING  TESTING 
		long startTime;
		long totalTime;


		// EVALUANDO TIEMPO EN INSERTAR EL COMIENZO

		// EVALUANDO 1000 INSERCIONES

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			l1.insertAtStart(i);
		}
		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en agregar 1.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElementAt(l1.size()-1);
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.size();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.removeAll();

		// EVALUANDO 10.000  INSERCIONES
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			l1.insertAtStart(i);
		}
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en agregar 10.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElementAt(l1.size()-1);
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.size();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.removeAll();

		// EVALUANDO 100.000  INSERCIONES

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			l1.insertAtStart(i);
		}
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en agregar 100.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElementAt(l1.size()-1);
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.size();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.removeAll();

		// EVALUANDO 1.000.000 INSERCIONES

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			l1.insertAtStart(i);
		}
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en agregar 1.000.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElementAt(l1.size()-1);
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.size();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.removeAll();


		// EVALUANDO 10.000.000 INSERCIONES

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			l1.insertAtStart(i);
		}
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en agregar 10.000.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElementAt(l1.size()-1);
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.size();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.removeAll();

		 */
	}


}
