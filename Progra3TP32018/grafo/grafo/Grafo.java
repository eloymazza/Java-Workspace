package grafo;

import nodeList.NodeList;

public interface Grafo {
	
	public Grafo grafo();
	public void agregarVertice(Vertice vertice);
	public void agregarArista(Vertice deVertice, Vertice aVertice);
	public Vertice obtenerVertice(Vertice claveVert);
	public NodeList obtenerVertices();
	public int numVertices();
	public int numAristas();
	public boolean existeArista(Vertice deVertice, Vertice aVertice);
	public NodeList obtenerAdyacentes(Vertice vertice);
	
}
