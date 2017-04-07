package Ejercicio4;

import java.util.*;

public class Pila {

	List <Object> pila;

	public Pila(){

		pila = new ArrayList<Object>();

	}

	public void push(Object o){

		pila.add(o);

	}

	public Object pop(){

		if(!pila.isEmpty()){

			int index = pila.size()-1;
			Object retorno = pila.get(index);
			pila.remove(index);
			return retorno;

		}
		else{

			return null;

		}

	}

	public Object top(){

		if(!pila.isEmpty()){

			return pila.get(pila.size()-1);

		}
		else{

			return null;

		}

	}

	public Pila copy(){

		Pila pilaCopia = new Pila();
		Pila pilaIntermedia = new Pila();

		while(!pila.isEmpty()){

			pilaIntermedia.push(this.pop());
		}
		while(pilaIntermedia.top() != null){

			pilaCopia.push(pilaIntermedia.top());
			this.push(pilaIntermedia.pop());	
		}

		return pilaCopia;
	}

	public String imprimir(){

		String result = "";
		Pila pilaIntermedia = new Pila();

		while(!pila.isEmpty()){

			result +=  this.top() + "\n" ;
			pilaIntermedia.push(this.pop());
		}

		while(pilaIntermedia.top() != null){

			this.push(pilaIntermedia.pop());	

		}
		return result;
	}

	public int size(){

		int size = 0;

		Pila pilaCopia = this.copy();

		while(pilaCopia.top() != null){

			pilaCopia.pop();
			size++;	
		}

		return size;
	}

	public Pila reverse(){
		
		Pila pilaRevertida = new Pila();
		Pila pilaCopia = this.copy();
		
		while(pilaCopia.top() != null){
			
			pilaRevertida.push(pilaCopia.pop());
			
		}
		
		return pilaRevertida;
		
	}
}
