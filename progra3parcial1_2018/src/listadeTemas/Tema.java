package listadeTemas;

public class Tema implements Comparable<Tema> {

		
	String titulo;
	Integer duracion;
	
	public Tema(String t, Integer d){
		titulo = t;
		duracion = d;
	}
	
	public Integer getDuracion(){
		return duracion;
	}

	@Override
	public int compareTo(Tema t) {
		
		if(duracion > t.getDuracion()){
			return 1;
		}
		else{
			return -1;
		}
	}
	
	public String toString(){
		return "Titulo: " + titulo + " Duracion: " + duracion;
	}
}
