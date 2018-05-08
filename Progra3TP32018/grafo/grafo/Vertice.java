package grafo;

public class Vertice {
	
	Integer id;
	Object contenido;
	
	public Vertice(Integer id, Object contenido){
		this.id = id;
		this.contenido = contenido;
	}
	
	public Vertice(Object contenido){
		this.contenido = contenido;
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
