package trabajoPracticoEspecial;

public class CondicionA�o extends Condicion{

	private Integer input;
	
	public CondicionA�o(Integer input){
		
		this.input = input;
		
	}

	
	public boolean cumple(Pista p) {
		
		return p.getAnio() == input;
	}
	
	

}
