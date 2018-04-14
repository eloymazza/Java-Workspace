package grafo;

public class Vertice {
	
	Integer id;
	Object contenido;
	
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
	
}
