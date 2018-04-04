package ejercicio3;
import ejercicio1_4_5_6.NodeList;

public class Pila {
	
	NodeList pila;
	
	public Pila(){
		pila = new NodeList();
	}
	public Pila(NodeList p){
		pila = p;
	}
	
	public boolean isEmpty(){
		return pila.isEmpty();
	}
	
	public int size(){
		return pila.size();
	}
	
	public Pila copy(){
		
		Pila copia = new Pila();
		for (int i = 0; i < size(); i++) {
			copia.push((Integer)pila.getElementAt(i));
		}
		return copia;	
	}
	
	public void push(Integer o){	
		pila.insertAtEnd(o);	
	}
	
	public Integer top(){
		
		if(!pila.isEmpty()){
			return (Integer)pila.getElementAt(size()-1);
		}	
		return null;
	}
	
	public Integer pop(){
		Integer aux = this.top();
		pila.removeLast();
		return aux;
	}
	
	public String toString(){
		
		String result = "";
		Pila aux = this.copy(); 	
		while(!aux.isEmpty()){
			result += aux.pop()+  "\n ";
		}
		return result;
	}
	
	public static void main(String[] args) {

		Pila p1 = new Pila();

		String space = "\n------------------";
		
		System.out.println("La pila inicia vacia: " + p1.isEmpty());
		
		for (int i = 0; i < 20; i++) {
			p1.push(i);
		}
		
		System.out.println("Imprimo Pila:");
		System.out.println(p1.toString()+ "------------------");
		System.out.println("La pila no esta vacia: " + !p1.isEmpty() + space);
		System.out.println("El tamaño de la pila es " + p1.size() + space);
		System.out.println("El elemento tope es  " + p1.top() + space);
		System.out.println("Borro el elemento tope " + p1.pop() + space);
		System.out.println("El elemento tope ahora es " + p1.top() + space);
		
		for (int i = 0; !p1.isEmpty(); i++) {
			p1.pop();
		}
		
		System.out.println("Borre todos los elementos, ahora el tamaño es " + p1.size() + space);
		System.out.println("La pila esta vacia: " + p1.isEmpty() + space);
		System.out.println("Ahora el elemento tope es : " + p1.top());
		System.out.println(p1);
		
	}

}
