package grafo;

public class Vertice {
	
	static Integer numV = 0;
	Integer id;
	Object contenido;
	
	public Vertice(Object contenido){
		this.id = numV;
		this.contenido = contenido;
		numV++;
	}
	
	public Vertice(){
		contenido = "Vertice Inexistente";
	}

	public Object getContenido() {
		return contenido;
	}

	public void setContenido(Object contenido) {
		this.contenido = contenido;
	}
	
	public Integer getID(){
		return id;
	}
	
	public void setID(Integer id){
		this.id = id;
	}
	
	public String toString(){
		return "ID vertice:" + this.id + ", contenido: " +  this.contenido;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.id == (Integer)obj;
	}
	
}
