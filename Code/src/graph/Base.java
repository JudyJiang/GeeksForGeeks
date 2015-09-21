package graph;

public class Base {
	public int count;
	
	public class Inner{
		public Inner(){
			
		}
	}
	
	
	public static class StaticNested{
		public StaticNested(){
			
		}
	}
	
	public static void main(String[] args){
		Base b = new Base();
		StaticNested n = new StaticNested();
		Base.Inner inner = b.new Inner();
	}
}
