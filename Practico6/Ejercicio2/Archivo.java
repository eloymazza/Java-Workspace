package Ejercicio2;

 class Archivo extends Elemento{

	String fechaDeCreacion;
	String fechaUltimaModificacion;
	
	public Archivo(String n, int t, String fC){		
		super(n,t,fC);
		fechaUltimaModificacion = null;
	}

	@Override
	public int getTamaño() {
	
		return this.tamaño;
	}
	
	
	

	
}
