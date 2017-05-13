package ejercicio1;

public class Coin implements Comparable<Coin>{
	
	int value;
	int quantity;
	
	public Coin(int value, int quantity){
		
		this.value = value;
		this.quantity = quantity;
		
	}
	
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString(){
		return "Value: " + value + " Quantity: " + quantity;  
	}


	


	@Override
	public int compareTo(Coin o) {
		
		return this.value - o.getValue() ;
		
	}


	public void increaseQuantity() {
		this.quantity++;
	}

}
