package ejercicio1;;
public class Graff {
	
	NodeList[] graff;
	int size;
	
	public Graff(int n){
		
		graff = new NodeList[n];
		size = 0;
		
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public void addAdjacent(int origin, int destination){
		
		if(origin < graff.length && origin >= 0){
			if(graff[origin] == null){
				graff[origin] = new NodeList();
			}
			graff[origin].insertAtEnd(destination);
			size++;			
		}
	}
	
	public  void graffGenerator(int n){
		
		int a = n;
		int length = graff.length;
		int specialLenght = length-n-1;
		for (int i = 0; i < length; i++) {			
			for (int j = i+1; j <= a; j++) {
				addAdjacent(i, j);
			}
			if(i < specialLenght){
				a++;				
			}
		}	
	}
	public String toString(){
		
		if(!isEmpty()){
			String aux = "";
			for (int i = 0; i < graff.length; i++) {
				aux += "Nodo " + i + ": " + graff[i] + "\n" ;
			}
			return aux;			
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		Graff g = new Graff(20);
		g.graffGenerator(4);
		System.out.println(g.toString());

	}
	
}
