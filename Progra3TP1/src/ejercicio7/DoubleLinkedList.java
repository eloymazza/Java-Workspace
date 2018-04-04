package ejercicio7;



public class DoubleLinkedList {

	DoubleNode root;
	DoubleNode last;
	int size = 0;
	
	public DoubleLinkedList(){
		root = null;
		last = null;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void insertAtStart(Object o){
		
		if(isEmpty()){
			DoubleNode newNode = new DoubleNode(o, null, null);
			newNode.setNext(root);
			root = newNode;
			last = root;
			last.setPrevious(root);
			size++;	
		}
		else{
			DoubleNode newNode = new DoubleNode(o, null, null);
			newNode.setNext(root);
			root = newNode;
			root.getNext().setPrevious(root);
			DoubleNode aux = root;
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			last = aux;
			last.setPrevious(aux.getPrevious());
			size++;
		}
		
	}
	
	public void insertAtEnd(Object o){
		
		if(isEmpty()){
			insertAtStart(o);
		}
		else{
			DoubleNode newNode = new DoubleNode(o,null,null);
			newNode.setPrevious(last);
			last.setNext(newNode);
			last = newNode;
			size++;			
		}
	}

	public void insertAt(Object o, int pos){
		
		if(pos < size() && pos >= 0){
			if(pos == 0){
				insertAtStart(o);
			}
			else if(pos == size()-1){
				insertAtEnd(o);
			}
			else{
				
			}
		}
		
	}
	
	// RETORNA EL OBJETO QUE ESTE EN LA POSICION INDICADA.
	// POSEE LA VENTAJA PODER EMPEZAR DESDE LA RAIZ O DESDE
	// EL ULTIMO ELEMENTO SEGUN CUAL SEA EL CAMINO MAS CORTO
	// PARA LLEGAR A LA POSISION DESEADA.
	public Object getElementAt(int pos){

		if(!isEmpty()){
			if(pos < size() && pos >= 0){
				if(pos == 0){
					return root.getElement();
				}
				else if(pos == size()-1){
					return last.getElement();
				}
				if(pos < size()/2){
					int count = 0;
					DoubleNode aux = root;
					while(count != pos){
						aux = aux.getNext();
						count++;
					}
					return aux.getElement();
				}
				else{
					DoubleNode aux = last;
					int count = size()-1;
					while(count != pos){
						aux = aux.getPrevious();
						count--;
					}
					return aux.getElement();
				}
			}
		}
		return null;
		
	}
	
	
	
	public String toString(){
		String result = "";
		DoubleNode aux = root;
		while(aux != null){
			result += aux.getElement() + " ";
			aux = aux.getNext();
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		DoubleLinkedList l = new DoubleLinkedList();
		
		for (int i = 0; i < 20; i++) {
			l.insertAtEnd(i);
		}
		
		System.out.println(l);
		System.out.println(l.getElementAt(19));
		
	}
	
	
}

