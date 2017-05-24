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
		}
		else{
			if(!poda()){
				for (int i = 0; i < conjunto.size(); i++) {
					conjunto = NodeList.sort(conjunto);
					buscarSolucion((int)conjunto.getElementAt(i));
				}			
			}
		}
		conjunto.insertAtStart(x);
		visitados.removeFirstOcurrence(x);
		sumaActual -= x;
	}
	
	private static boolean poda() {
		return sumaActual > objetivo;
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
		
		// 50 elementos
		
		for (int i = 0; i < 50; i++) {
			c1.insertAtStart((int)Math.floor(Math.random()*50));
		}
		System.out.println(c1);
		
		tiempoInicial = System.currentTimeMillis();
		System.out.println(SumaDeSubconjuntos.getSolucion(50, c1).size());
		tiempoTotal = System.currentTimeMillis() - tiempoInicial;
		
		
	}
}
