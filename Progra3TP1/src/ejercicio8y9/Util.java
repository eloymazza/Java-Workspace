package ejercicio8y9;

import java.util.*;

public class Util {
	
	public static boolean isPalindrom(String word){
		
		if(word.length() > 2){
			String charString[] = word.split("");
			int j = charString.length -1;
			for (int i = 0; i < j; i++) {
				if(!charString[i].equals(charString[j])){
					return false;
				}
				j--;
			}
			return true;
		}
		return false;
	}
	
	public static List<Object> createDisjuctionList(List<Object> a, List<Object> b){
		
		List<Object> l3 = new LinkedList<Object>();
		for (Object o : a) {
			if(!(b.contains(o))){
				l3.add(o);
			}
		}
		return l3;
		
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(Util.isPalindrom("anana"));
		
		List<Object> l1 = new LinkedList<Object>();
		List<Object> l2 = new LinkedList<Object>();
		
		l1.add("a");
		l1.add("b");
		l1.add("c");
		l1.add("d");
		l1.add("e");
		
		l2.add("a");
		l2.add("b");
		
		List<Object> l3 = new LinkedList<Object>();
		l3 = Util.createDisjuctionList(l1, l2);
		System.out.println(l3.toString());
	}

}
