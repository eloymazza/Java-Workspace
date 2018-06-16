package listadeTemas;

import java.util.Comparator;
import java.util.LinkedList;

public class ListaDeTemas {
	
	Integer tiempoMaximo;
	LinkedList<Tema> listaTemas;
	
	public ListaDeTemas(Integer tiempoMaximo){
		this.tiempoMaximo = tiempoMaximo;
		listaTemas = new LinkedList<Tema>();
	}
	
	
	public LinkedList<Tema> crearListaTemas(LinkedList<Tema> conjuntoTemas){
		
		conjuntoTemas.sort(new Comparator<Tema>(){

			@Override
			public int compare(Tema t1, Tema t2) {
				return t1.compareTo(t2);
			}
			
		});
		
		boolean solucion = false;
		Tema eleccion;
		Integer tiempoAcumulado = 0;
		Integer duracionActual = 0;
		while(!solucion && !conjuntoTemas.isEmpty()){
			eleccion = conjuntoTemas.removeFirst();
			duracionActual = eleccion.getDuracion();
			if(esFactible(duracionActual, tiempoAcumulado)){
				tiempoAcumulado += duracionActual;
				listaTemas.add(eleccion);
			}
			else{
				solucion = true;
			}
		}
		System.out.println(tiempoAcumulado);
		return listaTemas;
		
	}
	
	private boolean esFactible(Integer duracionTema, Integer tiempoAcumulado) {
		return duracionTema + tiempoAcumulado <= tiempoMaximo;
	}


	public static void main(String[] args) {
		
		ListaDeTemas l = new ListaDeTemas(300);
		
		LinkedList<Tema> conjuntoTemas = new LinkedList<Tema>();
		
		Tema t1 = new Tema("a", 301);
		Tema t2 = new Tema("b", 100);
		Tema t3 = new Tema("c", 10);
		Tema t4 = new Tema("d", 5);
		Tema t5 = new Tema("e", 27);
		Tema t6 = new Tema("f", 132);
		Tema t7 = new Tema("g", 75);
		Tema t8 = new Tema("h", 82);
		Tema t9 = new Tema("i", 62);
		Tema t10 = new Tema("j", 31);
		
		conjuntoTemas.add(t1);
		conjuntoTemas.add(t2);
		conjuntoTemas.add(t3);
		conjuntoTemas.add(t4);
		conjuntoTemas.add(t5);
		conjuntoTemas.add(t6);
		conjuntoTemas.add(t7);
		conjuntoTemas.add(t8);
		conjuntoTemas.add(t9);
		conjuntoTemas.add(t10);
		
		System.out.println(l.crearListaTemas(conjuntoTemas));
	}
	


	
}

