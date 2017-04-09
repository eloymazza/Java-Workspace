package ejercicio1_2_3_4;


public class RecursiveArray {

	Object arr[];
	int size = 0;

	public RecursiveArray(){
		arr = new Object[10];
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public Object getElement(int pos){
		if(pos < size){
			return arr[pos];
		}
		return null;
	}

	public Object max(){

		if(!isEmpty()){
			if(size == 1){
				return arr[0];
			}
			Object max = arr[0];
			for (Object o : arr) {
				if((int)max < (int)o){
					max = o;
				}
			}
			return max;
		}
		return null;
	}


	public void insertAtStart(Object o){

		if(arr[arr.length-1] != null){

			Object nuevoArreglo[] = new Object[size*2];
			for (int i = 0; i < size; i++) {
				nuevoArreglo[i] = arr[i];
			}
			arr = nuevoArreglo;
		}
		if(!isEmpty()){
			for (int i = size; i != 0; i--) {
				arr[i] = arr[i-1];
			}
		}
		arr[0] = o;
		size++;
	}



	public void selectionSort(){

		if(size>1){
			int minPos;
			for (int i = 0; i < size; i++) {
				minPos = i;
				for (int j = i+1; j < size; j++) {
					if((int)arr[j] < (int)arr[minPos]){
						minPos = j;
					}
				}
				swap(i,minPos);
			}
		}

	}

	public void bubbleSort(){

		if(size>1){
			int aux = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size-1-i; j++) {
					if((int)arr[j] > (int)arr[j+1]){
						aux = (int) arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = aux;
					}
				}
			}

		}

	}


	public boolean isSorted(){

		if(size > 2){
			return isSorted(0);
		}
		return true;
	}

	private boolean isSorted(Integer pos){

		Integer next = pos+1;
		if((int) next < (int)size){
			if((int)arr[pos] <= (int)arr[next]){
				return isSorted(next);
			}
			else{
				return false;
			}
		}
		return true;

	}

	public void quickSort(){

		quickSort(0, size-1);

	}

	private void quickSort(int start, int end) {


		int i = start;
		int j = end;
		int pivot = (int)arr[start+(end-start)/2];

		while(i <= j){

			while((int)arr[i] < pivot){
				i++;
			}
			while((int)arr[j] > pivot){
				j--;
			}
			if(i <= j){
				swap(i,j);
				i++;
				j--;
			}
		}
		if(start < j ){
			quickSort(start,j);
		}
		if(i < end){
			quickSort(i, end);
		}

	}

	public void mergeSort(){

		mergeSort(0,size-1);

	}

	private void mergeSort(int low, int high) {

		if(low < high){

			int middle = (low+high)/2;
			mergeSort(low,middle);
			mergeSort(middle +1,high);
			int helper[] = new int[size];
			merge(low, middle, high, helper); 

		}

	}

	private void merge(int low, int middle, int high, int []helper) {

		for (int i = low; i <= high; i++) {
			helper[i] = (int) arr[i];  
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while(i <= middle && j <= high){
			if(helper[i] <= helper[j]){
				arr[k] = helper[i];
				i++;
			}
			else{
				arr[k] = helper [j];
				j++;
			}
			k++;
		}
		while(i <= middle){
			arr[k] = helper[i];
			k++;
			i++;
		}

	}

	private void swap(int i, int j) {
		int aux = 0;
		aux = (int) arr[i];
		arr[i] = arr[j];
		arr[j] = aux;
	}

	public Object getElementRecursively(int pos){

		int count = 0;

		if(pos >= 0 && pos < size){
			if(count == pos){
				return arr[count];
			}
			count++;
			return getElementRecursively(pos, count);   
		}
		return null;

	}

	private Object getElementRecursively(int pos, int count) {

		if(count == pos){
			return arr[count]; 
		}
		count++;
		return getElementRecursively(pos, count);

	}

	public void print(){

		for (int i = 0; i != size; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}

	public void deleteAll(){
		arr = new Object[10];
		size = 0;
	}

	public RecursiveArray copy(){

		RecursiveArray copy = new RecursiveArray();
		for (int i = 0; i < size; i++) {
			copy.insertAtStart(arr[i]);
		}
		return copy;
	}

	public void fill(int n){
		for (int i = 0; i < n; i++) {
			this.insertAtStart((int)Math.floor(Math.random()*1000));		
		}
	}


	public static void main(String[] args) {

		long startTime;
		long totalTime;
		
		
				// SEGUNDO ENTREGABLE 
		
		// SELECTION SORT
		
		RecursiveArray selection = new RecursiveArray();
		selection.fill(50000);
		startTime = System.currentTimeMillis();
		selection.selectionSort();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println(totalTime);
		
		// MERGESORT
		
		RecursiveArray merge = new RecursiveArray();
		merge.fill(50000);
		startTime = System.currentTimeMillis();
		merge.mergeSort();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println(totalTime);
		
		// Analisis:
		/*
		 * El tiempo de ejecucion del metodo Mergesort es menor al de selection sort, a medida
		 * que se va incrementando el numero de elementos. La velocidad del ultimo se incrementa
		 * de manera logaritmica, mientras que el metodo selection sort lo hace de manera
		 * exponencial, por lo cual es menos recomendado ordenar grandes cantidades.
		 * Por ejemplo, si testeamos cincuentamil elementos, mergesort tarda 9 segundos mientras que 
		 * selection tarda 36 segundos. 
		 * El punto a favor que tiene selection sort contra mergesort es que el primero no requiere 
		 * memoria adicional, mientras que mergesort crea una copia exacta, de la misma cantidad de elementos
		 * que posee el arreglo original.
		 */

				// EJERCICIO 5 DEL TP 2
		/*
		RecursiveArray test = new RecursiveArray();
		test.fill(10000);

		// Probando selectionSort()
		RecursiveArray selection = new RecursiveArray();
		selection = test.copy();
		startTime = System.currentTimeMillis();
		selection.selectionSort();
		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en implementar selectionSort(): " + totalTime);

		// Probando bubbleSort()
		RecursiveArray bubble = new RecursiveArray();
		bubble = test.copy();
		startTime = System.currentTimeMillis();
		bubble.bubbleSort();
		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en implementar bubbleSort(): " + totalTime);


		// Probando quickSort()
		RecursiveArray quick = new RecursiveArray();
		quick = test.copy();
		startTime = System.currentTimeMillis();
		quick.quickSort();
		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en implementar quickSort(): " + totalTime);

		// Probando mergeSort()
		RecursiveArray merge = new RecursiveArray();
		merge = test.copy();
		startTime = System.currentTimeMillis();
		merge.mergeSort();
		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en implementar mergeSort(): " + totalTime);

		// Probando Arrays.sort();
		int[] arr = new int[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)Math.floor(Math.random()*1000);
		}
		startTime = System.currentTimeMillis();
		Arrays.sort(arr);
		totalTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo en implementar Arrays.sort(): " + totalTime);
		/*
		

		/*
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
		l1.getElemento((l1.getsize()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR size
		startTime = System.currentTimeMillis();
		l1.getsize();
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
		l1.getElemento((l1.getsize()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR size
		startTime = System.currentTimeMillis();
		l1.getsize();
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
		l1.getElemento((l1.getsize()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR size
		startTime = System.currentTimeMillis();
		l1.getsize();
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
		l1.getElemento((l1.getsize()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR size
		startTime = System.currentTimeMillis();
		l1.getsize();
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
		l1.getElemento((l1.getsize()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR size
		startTime = System.currentTimeMillis();
		l1.getsize();
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
		l1.getElemento((l1.getsize()-1));
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en encontrar ultimo elemento: " + totalTime);

		// DETERMINAR size
		startTime = System.currentTimeMillis();
		l1.getsize();
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo en obtener tamaño: " + totalTime );

		l1.eliminarTodo();
		 */
	}

}



