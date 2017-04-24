package ejercicio2;

public class Item implements Comparable<Item>{
	
	private String name;
	private double unitaryPrice;
	private double unitaryWeight;
	private double quantity;

	public Item(String name, double unitaryPrice, double unitaryWeight, double quantity){
		this.name = name;
		this.unitaryPrice = unitaryPrice;
		this.unitaryWeight = unitaryWeight;
		this.quantity = quantity;		
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public double getUnitaryWeight() {
		return unitaryWeight;
	}

	public void setunitaryWeight(double unitaryWeight) {
		this.unitaryWeight = unitaryWeight;
	}
	
	public String toString(){
		return this.name;
	}

	@Override
	public int compareTo(Item item2) {
		return (int) (this.getUnitaryPrice()/this.getUnitaryWeight() - item2.getUnitaryPrice() / item2.getUnitaryWeight());
	
	}
}
