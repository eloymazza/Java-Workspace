package Ejercicio5;

public class Play {

	public static void main(String[] args) {
		
Mazo mazo = new Mazo();
		
		for (int i = 0; i < 8; i++) {
			
			mazo.addCarta(new Carta((int) Math.floor((Math.random()*12) + 1)));
			
		}
		
		Jugador j1 = new Jugador("Eloy");
		Jugador j2 = new Jugador("Nico");
		Juego j = new Juego(j1, j2, mazo);
		j.Jugar();

	}

}
