package ejercicio7;

public class DoubleNode {

	Object element;
	DoubleNode previous;
	DoubleNode next;
	
	public DoubleNode(Object element, DoubleNode previous, DoubleNode next) {
		
		this.element = element;
		this.previous = previous;
		this.next = next;
		
	} 
	
	public Object getElement() {
		return element;
	}




	public void setElement(Object element) {
		this.element = element;
	}




	public DoubleNode getPrevious() {
		return previous;
	}




	public void setPrevious(DoubleNode previous) {
		this.previous = previous;
	}

	public DoubleNode getNext() {
		return next;
	}


	public void setNext(DoubleNode next) {
		this.next = next;
	}


	public String toString(){
		
		return element.toString();
		
	}

	
}
