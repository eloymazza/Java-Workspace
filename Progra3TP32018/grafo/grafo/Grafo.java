package grafo;

import nodeList.NodeList;

public interface Grafo {
	
	public Grafo grafo();
	public void agregarVertice(Vertice vertice);
	public void agregarArista(Integer idIni, Integer idFin);
	public Vertice obtenerVertice(Integer idVert);
	public NodeList obtenerVertices();
	public int numVertices();
	public int numAristas();
	public boolean existeArista(Integer idIni, Integer idFin);
	public NodeList obtenerAdyacentes(Integer idVertice);
	
}
