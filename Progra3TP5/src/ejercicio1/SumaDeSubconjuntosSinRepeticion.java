package ejercicio1;

import java.util.*;

public class SumaDeSubconjuntosSinRepeticion {

	private static NodeList conjunto;
	private static NodeList visitados = new NodeList();
	private static int objetivo;
	private static int sumaActual;
	private static NodeList solucion = new NodeList();
	private static Map<Integer, NodeList> noPermitidos;

	public static NodeList getSolucion(int o, NodeList c){

		sumaActual = 0;
		objetivo = o;
		conjunto = c;
		noPermitidos = new HashMap<Integer, NodeList>();

		for (int i = 0; i < conjunto.size(); i++) {
			noPermitidos.put((Integer) conjunto.getElementAt(i), new NodeList());
		}
		for (int i = 0; i < conjunto.size(); i++) {
			buscarSolucion((int)conjunto.getElementAt(i));
			conjunto = NodeList.sort(conjunto);
		}
		return solucion;
	}

	private static void buscarSolucion(int x) {
		
		sumaActual += x;
		conjunto.removeFirstOcurrence(x);
		visitados.insertAtEnd(x);
		if(sumaActual == objetivo){
			guardarSolucion(visitados);
			actualizarNoPermitidos(visitados);
		}
		else{
			for (int i = 0; i < conjunto.size(); i++) {
				conjunto = NodeList.sort(conjunto);
				if(!(noPermitidos.get(x).contains(conjunto.getElementAt(i)))){
					buscarSolucion((int) conjunto.getElementAt(i));					
				}
			}	
		}
		conjunto.insertAtStart(x);
		visitados.removeFirstOcurrence(x);
		sumaActual -= x;
	}

	private static void actualizarNoPermitidos(NodeList visitados) {

		Integer currentKey = null;
		for (int i = 0; i < visitados.size(); i++) {
			currentKey = (Integer) visitados.getElementAt(i);
			for (int j = 0; j < visitados.size(); j++) {
				if(currentKey != visitados.getElementAt(j)){
					noPermitidos.get(currentKey).insertAtEnd(visitados.getElementAt(j));
				}
			}
		}
	}

	private static void guardarSolucion(NodeList visitados) {

		NodeList copiaVisitados = new NodeList();
		for (int i = 0; i < visitados.size(); i++) {
			copiaVisitados.insertAtEnd(visitados.getElementAt(i));
		}
		solucion.insertAtEnd(copiaVisitados);
	}

	public static void main(String[] args) {

		NodeList c1 = new NodeList();
		long tiempoInicial;
		long tiempoTotal;

		c1.insertAtEnd(1);
		c1.insertAtEnd(2);
		c1.insertAtEnd(3);
		c1.insertAtEnd(4);
		c1.insertAtEnd(5);

		// 50 elementos

		//for (int i = 0; i < 20; i++) {
		//	c1.insertAtStart((int)Math.floor(Math.random()*30));
		//}

		tiempoInicial = System.currentTimeMillis();
		System.out.println(SumaDeSubconjuntosSinRepeticion.getSolucion(15, c1));
		tiempoTotal = System.currentTimeMillis() - tiempoInicial;


	}

}
