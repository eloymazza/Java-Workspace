package Ejercicio1;

public class Play {
	
	public static void main(String[] args) {
		
		Fabrica f1 = new Fabrica("Eloy SA");
		Fabrica f2 = new Fabrica("Pedrito SA");
		Fabrica f3 = new Fabrica("Juan SA");
		
		f1.setFabricaCercana(f2);
		f2.setFabricaCercana(f3);
		
		Pedido p1 = new Pedido(1.0, "rojo", 200, "20");
		Politica pol1 = new TamañoMayorQue(1.5);
		
		f1.cambiarPolitica(pol1);
		f2.cambiarPolitica(pol1);
		f3.cambiarPolitica(pol1);
		
		f1.aceptarPedidos(p1.getPedido());
	}

}
