package ejercicio6;

public class Thing implements  Comparable<Object>{

	String key;
	
	public Thing(String key){
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int compareTo(Object s) {
		// TODO Auto-generated method stub
		return key.compareTo(s.toString());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return key.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return key.equals(obj.toString());
	}
}
