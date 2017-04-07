package Testing;

import java.util.*;

public class Compuesto extends Elem{

	List<Elem> elementos;
	Compuesto main;
	
	public Compuesto(){
		
		elementos = new ArrayList<Elem>();
		main = null;
	}
	
	public void addElemento(Elem e){
		
		elementos.add(e);
		this.setMenor(e);
		e.setMain(this);
		if(main != null){
			main.setMenor(e);
		}
		
		
	}

	private void setMenor(Elem e) {
		
		Integer aux = e.getMenor();
		
		if(this.getMenor() == null){
			menor = aux;
		}
		else{
			if(this.getMenor() > aux){
				menor = aux;
			}
		}
	}





}
