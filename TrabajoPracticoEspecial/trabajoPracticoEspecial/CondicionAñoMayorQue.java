package trabajoPracticoEspecial;

public class CondicionA�oMayorQue extends Condicion{
	
	private int input;
	
	public CondicionA�oMayorQue(int input){
		
		this.input = input;
		
	}

	public boolean cumple(Pista p) {
		
		return p.getAnio() > input;
		
	}
	
}
