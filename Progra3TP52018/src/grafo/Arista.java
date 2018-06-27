package grafo;

public class Arista {
	
	protected Integer destino;
	protected Integer peso;
	
	public Arista(Integer destino, Integer peso){
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
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
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
