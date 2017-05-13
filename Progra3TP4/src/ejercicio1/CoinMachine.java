package ejercicio1;

import java.util.*;
import java.util.Map.Entry;

public class CoinMachine {

	private static List<Integer> coinValues;
	private static Map<Integer, Integer> solution;
	private static int objective;
	private static int currentValue;
	private static int coin;
	
	public static Map<Integer, Integer> getCashReturn(List<Integer> coins, int target){
		
		coinValues = coins;
		Collections.sort(coinValues);
		Collections.reverse(coinValues);
		
		solution = new HashMap<Integer,Integer>();
		for (Integer i : coinValues) {
			solution.put(i, 0);
		}
		objective = target;
		currentValue = 0;
		
		while(!coinValues.isEmpty() && !solution()){
			
			coin = selection();
			if(isFactible(coin)){
				solution.replace(coin, (solution.get(coin))+1);
				currentValue += coin;
			}else{
				coinValues.remove(0);
			}
		}
		
		return solution;
		
	}
	
	
	public static String sortedPrint(Map<Integer, Integer> solution) {
		
		String result = "";
		List <Integer> values = new ArrayList<Integer>();
		Iterator<Entry<Integer, Integer>> it = solution.entrySet().iterator();
		Entry<Integer, Integer> aux;
		
		
		while(it.hasNext()){
			aux = it.next();
			values.add(aux.getKey());
		}
		
		Collections.sort(values);
		Collections.reverse(values);
		
		for (Integer i : values) {
			result += " Valor: " + i + " Cantidad: " + solution.get(i) + "\n";
		}
		
		return result;
	}


	private static boolean isFactible(int coin) {
		
		return (currentValue + coin) <= objective;
	}

	private static int selection() {
		return coinValues.get(0);
	}

	private static boolean solution() {
		return objective == currentValue;
	}

	public static void main(String[] args) {
		
		List<Integer> c = new ArrayList<Integer>();
		
		c.add(50);
		c.add(20);
		c.add(10);
		c.add(5);
		c.add(2);
		c.add(1);
		
		System.out.println(CoinMachine.sortedPrint(CoinMachine.getCashReturn(c, 177)));
		
	}
}
