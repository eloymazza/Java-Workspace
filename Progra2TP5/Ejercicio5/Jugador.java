package Ejercicio5;

import java.util.*;;

public class Jugador {

	String name;
	Mazo mazo;
	Mazo cartasGanadas;
	
	public Jugador(String name){
		
		this.name = name;
		mazo = new Mazo();
		cartasGanadas = new Mazo();
		
	}
	
	public void addCarta(Carta c){	
		mazo.addCarta(c);	
	}
	
	public void addCartasGanadas(Carta c){
		cartasGanadas.addCarta(c);
	}
	
	public Carta getCarta(){		
		return mazo.getCarta();
	}
	
	public int contarCartas(){
		
		return mazo.size();
		
	}
	
	public String toString(){
		return name;
	}

	public void jugarRonda(Jugador j2, int cartasRonda, Mazo p) {
		
		Mazo pozo = p;
		int score1 = 0;
		int score2 = 0;
		
		for (int i = 0; i < cartasRonda; i++) {
		
			Carta c1 = this.getCarta();
			Carta c2 = j2.getCarta();
			pozo.addCarta(c1);
			pozo.addCarta(c2);
			score1 += c1.getValor();
			score2 += c2.getValor();
			
		}
		
		if(score1 > score2){	
			while(pozo.quedanCartas()){
				this.addCartasGanadas(pozo.getCarta());
			}			
		}
		else if(score1 < score2){
			while(pozo.quedanCartas()){
				j2.addCartasGanadas(pozo.getCarta());
			}
		}
		else{
			if(quedanCartas() && j2.quedanCartas()){
				this.jugarRonda(j2, 1, pozo);
			}
		}
		
	}
	
	private boolean quedanCartas() {
		// TODO Auto-generated method stub
		return mazo.quedanCartas();
	}

	public int getValorCartasGanadas(){
		
		Iterator <Carta> it = cartasGanadas.iterator();
		int retorno = 0;
		
		while(it.hasNext()){
			retorno += it.next().getValor();
		}
		return retorno;
	}
}
