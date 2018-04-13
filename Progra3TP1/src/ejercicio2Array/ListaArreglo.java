package ejercicio2Array;

public class ListaArreglo {

	Object arr[];
	int cantidad = 0;

	public ListaArreglo(){
		arr = new Object[2];
	}

	public boolean estaVacia(){
		return cantidad == 0;
	}

	public int getCantidad(){
		return cantidad;
	}

	public Object getElemento(int pos){
		if(pos < cantidad && pos >= 0){
			return arr[pos];
		}
		return null;
	}

	public void insertarAlComienzo(Object o){

		if(arr[arr.length-1] != null){

			Object nuevoArreglo[] = new Object[cantidad*2];
			for (int i = 0; i < cantidad; i++) {
				nuevoArreglo[i] = arr[i];
			}
			arr = nuevoArreglo;
		}
		if(!estaVacia()){
			for (int i = cantidad; i != 0; i--) {
				arr[i] = arr[i-1];
			}
		}
		arr[0] = o;
		cantidad++;
	}
	

	public void imprimirALoCroto(){

		String result = "";
		for (int i = 0; i != arr.length; i++) {
			result+= arr[i] + " ";
		}	
		System.out.println(result);

	}
	
	public void eliminarTodo(){
		arr = new Object[10];
		cantidad = 0;
	}

	public static void main(String[] args) {

		ListaArreglo l1 = new ListaArreglo();
		
		l1.insertarAlComienzo(1);
		l1.insertarAlComienzo(2);
		l1.insertarAlComienzo(3);
		l1.insertarAlComienzo(4);
		l1.insertarAlComienzo(5);
		l1.imprimirALoCroto();
		/*
		long startTime;
		long totalTime;


		// EVALUANDO TIEMPO EN INSERTAR EL COMIENZO


		// EVALUANDO 1000 INSERCIONES
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			l1.insertarAlComienzo(i);
		}
		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en agregar 1.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElemento((l1.getCantidad()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.getCantidad();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.eliminarTodo();

		// EVALUANDO 10.000 INSERCIONES
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			l1.insertarAlComienzo(i);
		}
		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en agregar 10.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElemento((l1.getCantidad()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.getCantidad();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );


		l1.eliminarTodo();

		// EVALUANDO 100.000 INSERCIONES
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			l1.insertarAlComienzo(i);
		}
		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en agregar 100.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElemento((l1.getCantidad()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.getCantidad();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );


		l1.eliminarTodo();




		// EVALUANDO 200.000 INSERCIONES
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			l1.insertarAlComienzo(i);

		}

		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en agregar 200.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElemento((l1.getCantidad()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.getCantidad();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.eliminarTodo();

		// EVALUANDO 300.000 INSERCIONES
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 300000; i++) {
			l1.insertarAlComienzo(i);

		}

		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en agregar 300.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElemento((l1.getCantidad()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.getCantidad();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.eliminarTodo();


		// EVALUANDO 400.000 INSERCIONES
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 400000; i++) {
			l1.insertarAlComienzo(i);

		}

		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en agregar 400.000 elementos: " + 
				totalTime);

		// CONSEGUIR EL ULTIMO ELEMENTO
		startTime = System.currentTimeMillis();
		l1.getElemento((l1.getCantidad()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR CANTIDAD
		startTime = System.currentTimeMillis();
		l1.getCantidad();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.eliminarTodo();		
		*/
	}

}
