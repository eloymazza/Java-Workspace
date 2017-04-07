package tpTioRemake;
public class Stock {

	String name ;
	int numberShares ;
	double price ;
	
	public Stock ( String name , int numberShares, double price )
	{
		this.name = name ;
		this.numberShares = numberShares ;
		this.price = price ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberShares() {
		return numberShares;
	}

	public void setNumberShares(int numberShares) {
		this.numberShares = numberShares;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString()
	{
		return this.name ;
	}
	
}
