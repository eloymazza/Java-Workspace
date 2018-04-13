package grafo;

public class Vertice {
	
	Object id;
	Object contenido;
	State estado;
	
	public Vertice(Object contenido){
		this.contenido = contenido;
		estado = State.unvisited;
	}

	public Object getContenido() {
		return contenido;
	}

	public void setContenido(Object contenido) {
		this.contenido = contenido;
	}

	public State getEstado() {
		return estado;
	}

	public void setEstado(State estado) {
		this.estado = estado;
	}
	
}
