package Testing;

public abstract class Elem {

	Integer menor;
	Compuesto main;
	public Integer getMenor() {
		// TODO Auto-generated method stub
		return menor;
	}
	
	public Compuesto getMain(){
		return main;
	}
	public void setMain(Compuesto c) {
		
		main = c;
		
	}
	
	
	public static void main(String[] args) {
		
		Unit u1 = new Unit(100);
		Unit u2 = new Unit(50);
		Unit u3 = new Unit(45);
		Unit u4 = new Unit(40);
		Unit u5 = new Unit(39);
		Unit u6 = new Unit(35);
		Unit u7 = new Unit(25);
		Unit u8 = new Unit(23);
		Unit u9 = new Unit(15);
		Unit u10 = new Unit(10);
		Unit u11 = new Unit(9);
		Unit u12 = new Unit(5);
		Unit u13 = new Unit(1);
		
		Compuesto c1 = new Compuesto();
		Compuesto c2 = new Compuesto();
		Compuesto c1_c2_u4 = new Compuesto();
		Compuesto c3 = new Compuesto();
		Compuesto c3_u8 = new Compuesto();
		Compuesto c4 = new Compuesto();
		Compuesto u9_10_c4 = new Compuesto();
		Compuesto all = new Compuesto();
		
		
		c1.addElemento(u1);
		c1.addElemento(u2);
		c2.addElemento(u3);
		c1_c2_u4.addElemento(c1);
		c1_c2_u4.addElemento(c2);
		c1_c2_u4.addElemento(u4);
		c3.addElemento(u5);
		c3.addElemento(u6);
		c3.addElemento(u7);
		c3_u8.addElemento(c3);
		c3_u8.addElemento(u8);
		c4.addElemento(u11);
		c4.addElemento(u12);
		u9_10_c4.addElemento(u9);
		u9_10_c4.addElemento(u10);
		u9_10_c4.addElemento(c4);
		all.addElemento(c1_c2_u4);
		all.addElemento(c3_u8);
		all.addElemento(u9_10_c4);
		c2.addElemento(u13);
		
		
		
		System.out.println(all.getMenor());
		
		
		
		
		

		
	}
	
}
