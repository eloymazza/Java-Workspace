package ejercicio1;

public class SumaDeSubconjuntos {

	private static NodeList conjunto;
	private static NodeList visitados = new NodeList();
	private static int objetivo;
	private static int sumaActual;
	private static NodeList solucion = new NodeList();
	

	public static NodeList getSolucion(int o, NodeList c){
		
		sumaActual = 0;
		objetivo = o;
		conjunto = c;
			
		for (int i = 0; i < conjunto.size(); i++) {
			buscarSolucion((int)conjunto.getElementAt(i));
		}
		return solucion;	
	}

	private static void buscarSolucion(int x) {
		sumaActual += x;
		conjunto.removeFirstOcurrence(x);
		visitados.insertAtEnd(x);
		if(sumaActual == objetivo){
			solucion.insertAtEnd(visitados);
			System.out.println(solucion);
		}
		else{
			for (int i = 0; i < conjunto.size(); i++) {
				buscarSolucion((int)conjunto.getElementAt(i));
			}			
		}
		conjunto.insertAtStart(x);
		visitados.removeFirstOcurrence(x);
		sumaActual -= x;
	}
	
	public static void main(String[] args) {
		
		NodeList c1 = new NodeList();
		c1.insertAtEnd(1);
		c1.insertAtEnd(2);
		c1.insertAtEnd(3);
		
		System.out.println(SumaDeSubconjuntos.getSolucion(6, c1));
		
	}
}
