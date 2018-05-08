package grafo;

public class Arista {
	
	protected Integer destino;
	protected double peso;
	
	public Arista(Integer destino, double peso){
		this.destino = destino;
		this.peso = peso;
	}
	
	public Arista(Integer destino){
		this.destino = destino;
		this.peso = 1;
	}
	
	public Integer getDestino() {
		return destino;
	}
	public void setDestino(Integer destino) {
		this.destino = destino;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String toString(){
		return "Destino: " + destino + " Peso: " + peso;
	}
	
	@Override
	public boolean equals(Object obj) {
		return destino == (Integer)obj;
	}

}
