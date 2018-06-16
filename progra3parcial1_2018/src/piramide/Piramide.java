package piramide;

import java.util.*;

public class Piramide {
	
	protected Integer maxNum;
	protected Integer baseLength;
	protected Integer[][] piramide;
	
	public Piramide(){
		maxNum = 0;
		baseLength = 0;
	}
	
	public String obtenerPiramideDeSumas(Integer maxNum, Integer baseLength){
		
		this.maxNum = maxNum;
		this.baseLength = baseLength;
		this.piramide = new Integer[baseLength][baseLength];
		Integer nivelInicial = 0;
				
		if(generarPiramide(nivelInicial)){
			return impirmirPiramide();			
		}
		else{
			return "La piramide no tiene solucion";
		}
		
	}


	private boolean generarPiramide(int nivel) {
		
		if(nivel == baseLength){
			if(esSolucion()){
				return true;
			}
		}
		else{
			for (int i = 1; i <= maxNum; i++) {
				if(!poda(i, nivel)){
					piramide[baseLength-1][nivel] = i;
					if(generarPiramide(nivel+1)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	private boolean poda(int valor, int columna) {
		
		for (int i = 0; i < columna; i++) {
			if(piramide[baseLength-1][i] == valor){
				return true;
			}
		}
		return false;
	}

	private boolean esSolucion() {
		
		Integer base = baseLength-1;
		LinkedList<Integer> repetidos = new LinkedList<Integer>();
		for (int col = 0; col <= base; col++) {
			repetidos.add(piramide[base][col]);
		}

		return validarPiramide(repetidos, base);
	}

	private boolean validarPiramide(LinkedList<Integer> repetidos, int nivel) {
		
		Integer actual;
		Integer suma;

		for (int columna = 0; columna < nivel; columna++) {
			actual = piramide[nivel][columna];
			suma = actual + piramide[nivel][columna+1];
			if(repetidos.contains(suma)){
				return false;
			}
			piramide[nivel-1][columna] = suma;
		}
		if(nivel == 1){
			return true;
		}
		repetidos.add(piramide[nivel][nivel]);			
		return validarPiramide(repetidos, nivel-1);

	}
	
	private String impirmirPiramide() {
		String result = "";
		for (int i = 0; i < baseLength; i++) {
			for (int j = 0; j < baseLength; j++) {
				result += piramide[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Piramide p = new Piramide();
		System.out.println(p.obtenerPiramideDeSumas(100,5));
		
	}
	
}
