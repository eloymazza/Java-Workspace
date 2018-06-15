package laberinto;

import java.util.LinkedList;

public class Laberinto {

	Casilla[][] laberinto;
	Integer llegada;
	
	public Laberinto(){
		laberinto = null;
		llegada = null;
	}
	
	
	public LinkedList<Casilla> resolverLaberinto(Casilla[][] laberinto, Integer x, Integer y, Integer llegada){
		
		this.laberinto = laberinto;
		LinkedList<Casilla> caminoAcumulado = new LinkedList<Casilla>();	
		this.llegada = llegada;
		return resolverLaberinto(x,y, caminoAcumulado);
		
	}


	private LinkedList<Casilla> resolverLaberinto(Integer x, Integer y, LinkedList<Casilla> caminoAcumulado) {
		
		Casilla actual = laberinto[x][y];
		if(visitada(actual,caminoAcumulado)){
			return null;
		}
		caminoAcumulado.add(actual);
		if(esSolucion(actual)){
			return caminoAcumulado;
		}
		else{
			LinkedList<Casilla> camino = new LinkedList<Casilla>();
			if(actual.getUp()){
				camino = resolverLaberinto(x-1,y, caminoAcumulado);
				if(camino != null){
					return camino;
				}
			}
			if(actual.getRight()){
				camino = resolverLaberinto(x,y+1, caminoAcumulado);
				if(camino != null){
					return camino;
				}
			}
			if(actual.getDown()){
				camino = resolverLaberinto(x+1,y, caminoAcumulado);
				if(camino != null){
					return camino;
				}
			}
			if(actual.getLeft()){
				camino = resolverLaberinto(x,y-1, caminoAcumulado);
				if(camino != null){
					return camino;
				}
			}
			
		}
		caminoAcumulado.remove(actual);
		return null;
		
	}
	
	private boolean esSolucion(Casilla actual) {
		// TODO Auto-generated method stub
		return actual.getID() == llegada;
	}


	private boolean visitada(Casilla actual, LinkedList<Casilla> caminoActual) {
		return caminoActual.contains(actual);
	}


	public static void main(String[] args) {
		
		Laberinto juegoLaberinto = new Laberinto();
		
		boolean[] vecinos1 = {false,false,true,false};
		Casilla c1 = new Casilla(1,vecinos1);
		
		boolean[] vecinos2 = {false,true,true,false};
		Casilla c2 = new Casilla(2,vecinos2);

		boolean[] vecinos3 = {false,false,true,true};
		Casilla c3 = new Casilla(3, vecinos3);
		
		boolean[] vecinos4 = {true,true,false,false};
		Casilla c4 = new Casilla(4, vecinos4);
		
		boolean[] vecinos5 = {false,false,true,true};
		Casilla c5 = new Casilla(5, vecinos5);
		
		boolean[] vecinos6 = {true,false,true,false};
		Casilla c6 = new Casilla(6, vecinos6);
		
		boolean[] vecinos7 = {false,true,false,false};
		Casilla c7 = new Casilla(7, vecinos7);
		
		boolean[] vecinos8 = {false,true,false,true};
		Casilla c8 = new Casilla(8, vecinos8);
		
		boolean[] vecinos9 = {true,false,false,true};
		Casilla c9 = new Casilla(9, vecinos9);
		
		Casilla[][] laberinto = new Casilla[3][3];
		
		laberinto[0][0] = c1;
		laberinto[0][1] = c2;
		laberinto[0][2] = c3;
		laberinto[1][0] = c4;
		laberinto[1][1] = c5;
		laberinto[1][2] = c6;
		laberinto[2][0] = c7;
		laberinto[2][1] = c8;
		laberinto[2][2] = c9;
		
		System.out.println(juegoLaberinto.resolverLaberinto(laberinto, 0,0, 7).toString());
	}
	
	
}
