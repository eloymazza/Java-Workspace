package Ejercicio2;

public class Play {
	
	public static void main(String[] args) {
		
		String texto = "arbol perro perro casa casa perro casa arbol arbol java php php jquery javascript auto auto casa auto casa perro perro z javascript";
		
		Vocabulario2  voc = new Vocabulario2(texto);
			
		System.out.println(voc.getCantidadPalabrasUnicas());
		System.out.println(voc.getPalabrasUnicasYFrecuencia());
		System.out.println(voc.getPalabrasUnicasAlfabeticamenteConIterator());
		System.out.println(voc.getPalabrasUnicasAlfabeticamente());
		System.out.println(voc.getPalabrasPorFrecuencia());
		System.out.println(voc.getPalabrasMasFrecuentes());
		System.out.println(voc.getPalabrasMenosFrecuentes());
		System.out.println(voc.getFrecuencia("perro"));
		
	}

}
