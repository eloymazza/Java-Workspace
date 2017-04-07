package Ejercicio4;

public class Play {

	public static void main(String[] args) {
		
		Pila p1 = new Pila();
		p1.push("c");
		p1.push("b");
		p1.push("a");
		
		System.out.println(p1.imprimir());
		
		Pila p2 = p1.copy();
		
	//	System.out.println(p2.imprimir());	
	//	System.out.println(p1.size());
	//	System.out.println(p2.size());
		System.out.println(p1.reverse().imprimir());
		System.out.println(p2.reverse().imprimir());
		
	}

}
