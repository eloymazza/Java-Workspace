package graphBest;

public class GraphNodeList {

	private VertexNode root;
	private int size = 0;

	public GraphNodeList(){
		root = null;
	}

	public boolean isEmpty(){
		return root == null;
	}

	public int size(){
		return size;
	}

	public void insertAtStart(Object o, int weight){

		VertexNode newNode = new VertexNode(o, null, weight);
		newNode.setNext(root);
		root = newNode;
		size++;	
	}

	public void insertAtEnd(Object o, int weight){

		if(isEmpty()){
			insertAtStart(o, weight);
		}
		else{
			VertexNode aux = root;
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			aux.setNext(new VertexNode(o,null,weight));
			size++;
		}

	}

	public void insertAt(int pos, Object o, int weight){

		if(pos < size() && pos >= 0){	
			if(pos == 0){
				insertAtStart(o, weight);
			}
			else if( pos == size()-1){
				insertAtEnd(o,weight);
			}
			else{
				int count = 0;
				VertexNode aux = root;
				while(count < size()-1){
					if(count == pos){
						VertexNode newNode = new VertexNode(o, aux.getNext(), weight);
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
			VertexNode aux = root;
			while(pos != count){
				aux = aux.getNext();
				count++;
			}
			return aux.getElement();
		}
		return null;
	}

	public VertexNode getNodeAt(int pos){

		if( pos >= 0  && pos < size() ){	
			int count = 0;
			VertexNode aux = root;
			while(pos != count){
				aux = aux.getNext();
				count++;
			}
			return aux;
		}
		return null;
	}
	
	public void removeFirst(){

		if(!isEmpty()){
			VertexNode temp = root;
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
			VertexNode aux = root;
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
				VertexNode temp = root.getNext();
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
				VertexNode aux = root;
				while(aux.getNext() != null){
					if(aux.getNext().getElement().equals(o)){
						VertexNode temp = aux.getNext().getNext();
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
		VertexNode aux = root;
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
			VertexNode aux = root;
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

	public static GraphNodeList createIntersectionList(GraphNodeList a, GraphNodeList b){

		GraphNodeList newList = new GraphNodeList();

		for (int i = 0; i < a.size(); i++) {

			Object element = a.getElementAt(i);
			if(b.contains(element)){
				newList.insertAtStart(element, 0);
			}	
		}
		return newList;
	}
	
	public static GraphNodeList createDisjunctionList(GraphNodeList a, GraphNodeList b){
		
		GraphNodeList newList = new GraphNodeList();

		for (int i = 0; i < a.size(); i++) {

			Object element = a.getElementAt(i);
			if(!b.contains(element)){
				newList.insertAtStart(element, 0);
			}	
		}
		return newList;
	}
		
	public static GraphNodeList sort(GraphNodeList l) {

		GraphNodeList newList = new GraphNodeList();
		while(!l.isEmpty()){
			Object max = l.max();
			l.removeFirstOcurrence(max);
			newList.insertAtStart(max, 0);
		}
		return  newList;
	}
	
	public GraphNodeList clone(){
		
		GraphNodeList clone = new GraphNodeList();
		
		VertexNode aux = root;
		while(aux != null){
			clone.insertAtEnd(aux.getElement(), aux.getWeight());
			aux = aux.getNext();
		}	
		return clone;
	}

	public String toString(){

		String result = "";
		VertexNode aux = root;
		while(aux != null){
			result += aux.getElement() + " ";
			aux = aux.getNext();
		}

		return result;
	}




}
