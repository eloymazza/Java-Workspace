package Ejercicio5;

public class Juego {
	
	final static int CARTASRONDA = 2;
	Mazo m;
	Jugador j1;
	Jugador j2;

	public Juego(Jugador j1, Jugador j2, Mazo m){

		this.m = m;
		this.j1 = j1;
		this.j2 = j2;

	}
	
	public void Jugar(){
		
		repartirCartas();
		
		
		while(j1.contarCartas() >= (CARTASRONDA) && j2.contarCartas() >= (CARTASRONDA)){
			Mazo pozo = new Mazo();
			j1.jugarRonda(j2, CARTASRONDA, pozo);
		}
		
		if(j1.getValorCartasGanadas() > j2.getValorCartasGanadas()){
			System.out.println("Gano " + j1.toString());

		}
		else if(j1.getValorCartasGanadas() < j2.getValorCartasGanadas()){
			System.out.println("Gano " + j2.toString());
		}
		else{
			
			System.out.println("Hubo Empate");
		}
		
	}

	private void repartirCartas() {
		
		while(m.quedanCartas()){
			j1.addCarta(m.getCarta());
			j2.addCarta(m.getCarta());
		}
		
	}

}
