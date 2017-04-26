package ejercicio2;

import java.util.*;

public class BackPack {

	private static double bagCapacity;
	private static double currentWeight;
	private static List<Item> startItems;
	private static Map<String, Double> solution;
	private static double solutionValue;
 	public static boolean isFractal = false;

	
	/*
	 * Este metodo recibe un conjunto de items, un peso maximo que puede cargar la mochila, y 
	 * un booelano que indica si los items del conjunto dado son fraccionables.
	 */
	public static Map<String, Double> fillBackPack(Set<Item> items, Double weight, boolean isFractal){

		setStartingTools(weight); // inicializo las estructuras y variables que necesito para esta funcion 
		Item bestPick = null;  // En esta variable se va a guardar los items elegidos.
		sortItems(items);  // Ordeno la lista de items iniciales.
		// Inicia hashmap de items y proporcion con todos los valores en 0.
		for (Item i : items) {			
			solution.put(i.getName(), 0.0);
		}
		double bestPickQuantity = 0.0;  // Inicalizo la variable que guarda la cantidad de un item x que voy a poner en la mochila
		// Mientras tenga items o no haya alcanzado la solucion, itero.
		
		while(!startItems.isEmpty() && !solution()){
			bestPick = selection(); 	// Elijo el mejor candidato
			startItems.remove(bestPick); // Elimino el item que elegí como mejor opcion.
			if(isFractal){
				// Calculo la mayor cantidad en kg del mejor candidato que puede entrar en la mochila.
				bestPickQuantity = getQuantityInKG(bestPick)/bestPick.getUnitaryWeight(); 
				solution.put(bestPick.getName(), bestPickQuantity); // Agrego a mi solucion el nombre del item mas la proporcion del mismo que pongo en la mochila
			}
			else{
				// Calculo la cantidad de items (sin fraccionar) del mejor candidato que puden entrar en la mochila. 
				bestPickQuantity = getQuantity(bestPick);
				if(bestPickQuantity != 0){ // Solo agrego el item si la canidad que entra es mayor a 0.
					solution.put(bestPick.getName(), bestPickQuantity);
				}
			}
			currentWeight += bestPickQuantity * bestPick.getUnitaryWeight(); // Actualizo el peso actual que tiene mi mochila.
			solutionValue += bestPick.getUnitaryPrice()* bestPickQuantity; // Actualizo total en valor de los items de mi mochila.
		}
		return solution;  
	}

	
	static void setStartingTools(double weight){

		bagCapacity = weight;  // Capacidad total de la mochila
		currentWeight = 0;		// Peso actual de los items en conjunto
		startItems = new ArrayList<Item>();  // Lista  de items iniciales
		solution = new HashMap<String, Double>(); // Inicio el hashmap que va a representar al conjunto solucion
		solutionValue = 0; // Suma de los valores (precio) de los items que conforman el conjunto solucion

	}
	
	// Retorna la cantidad (no fraccional) del item elegido que puede ser ingresado en la mochila sin sobrepasar su peso restante.
	private static double getQuantity(Item bestPick) {
		
		double capacityLeft = bagCapacity - currentWeight;  // Capacidad que le queda a la mochila
		double quantity = bestPick.getQuantity(); 
		// Mientras el total de existencias del item elegido no entre en la mochila, se le resta una existencia.
		while(capacityLeft < bestPick.getUnitaryWeight()* quantity && quantity != 0){
			quantity--;  
		}
		return quantity;
	}
	
	// REtorna la cantidad fraccional del item elegido que puede ser ingresado en la mochila sin sobrepasar su peso restante.   
	private static Double getQuantityInKG(Item bestPick) {

		double capacityLeft = bagCapacity - currentWeight;
		/* Si la capacidad restante de la mochila es mayor o igual al peso del item elegido 
		multiplicado por su cantidad, retorno este ultimo valor, es decir, pongo toda la cantidad
		que exista del item elegido en la mochila.
		De lo contrario, fracciono el item para llenar lo que quede de la mochila. 
		*/ 
		if(capacityLeft >= bestPick.getUnitaryWeight()*bestPick.getQuantity()){
			return bestPick.getUnitaryWeight()*bestPick.getQuantity();
		}
		return capacityLeft;

	}
	
	// Siempre retorno el primer item, ya que la lista de items esta ordenada de acuerdo a la mejor relacion precio/peso.
	private static Item selection() {
		return startItems.get(0);
	}

	// Retorno true si el peso total de la mochila fue alcanzado.
	private static boolean solution() {
		return currentWeight ==  bagCapacity;
	}
	
	// Retorna la sumatoria de los precios de los productos que fueron ingresados en la mochila.
	private static double getSolutionValue() {
		return solutionValue;
	}

	// Ordena los items con la mayor relacion precio/peso.
	private static void sortItems(Set<Item> items){
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			startItems.add(it.next());
		}
		Collections.sort(startItems);
		Collections.reverse(startItems);

	}

	public static void main(String[] args) {

		Set<Item> items = new HashSet<Item>();
//		Para probar el metodo con items fraccionables
//		Item i1 = new Item("Pan 1kg",40, 1, 1);
//		Item i2 = new Item("Zapallo calabaza", 50, 2.5, 1);
//		Item i3 = new Item("Bondiola baston", 1000, 5, 1);
//		Item i4 = new Item("Queso roquefort horma", 900, 3.0, 4);
//
//		items.add(i1);
//		items.add(i2);
//		items.add(i3);
//		items.add(i4);
		
		// Para probar el metodo con items no fraccionables
		Item l1 = new Item("Monitor", 2000, 1.0, 2);
		Item l2 = new Item("Pc", 10000, 4.0, 3);
		Item l3 = new Item("Mouse", 300, 0.3, 10);
		
		items.add(l1);
		items.add(l2);
		items.add(l3);

		Map <String, Double> result = BackPack.fillBackPack(items, 16.0, false);
		System.out.println(result);
		System.out.println("Valor maximizado: " + BackPack.getSolutionValue());
	}

}
