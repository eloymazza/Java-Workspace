package sumaSubconjuntos;

import java.util.*;

public class SumaDeSubconjuntos {

	
	protected Integer objetivo;
	protected ArrayList<Integer> usados;
	protected ArrayList<Integer> conjunto;

	
	public SumaDeSubconjuntos(){
		objetivo = null;
		usados = new ArrayList<Integer>();
		conjunto = new ArrayList<Integer>();
	}
	
	public void encontrarSolucion(Integer objetivo, ArrayList<Integer> conjunto){
		
		this.objetivo = objetivo;
		this.conjunto = conjunto;
		ArrayList<Integer> conjSolucion = new ArrayList<Integer>();
		encontrarSolucion(conjSolucion);

			
	}
	
	
	private void encontrarSolucion(ArrayList<Integer> conjSolucion) {
		
		if(esSolucion(conjSolucion)){
			System.out.println(conjSolucion.toString());
		}
		else{
			for (Integer elem : conjunto) {
				if(!usados.contains(elem) && !poda(conjSolucion,elem)){
					usados.add(elem);
					conjSolucion.add(elem);
					encontrarSolucion(conjSolucion);
					usados.remove(elem);
					conjSolucion.remove(elem);
				}
			}
		}
	}

	private boolean poda(ArrayList<Integer> solucion, Integer proxElem) {
		
		Integer suma = 0;
		for (Integer element : solucion) {
			suma += element;
		}	
		return suma + proxElem > objetivo;
	}

	private boolean esSolucion(ArrayList<Integer> solucion) {
		
		Integer suma = 0;
		for (Integer element : solucion) {
			suma += element;
		}	
		return suma == objetivo;
	}
	
	public static void main(String[] args) {
		
		SumaDeSubconjuntos s = new SumaDeSubconjuntos();
		
		ArrayList<Integer> conjunto = new ArrayList<Integer>();
		
		conjunto.add(4);
		conjunto.add(6);
		conjunto.add(2);
		conjunto.add(1);

		
		s.encontrarSolucion(9, conjunto);
		
	}
	
	
}
