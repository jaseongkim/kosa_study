package 제네릭_13장;

public class 제네릭_메소드 {

	static class Box<T> {
		
		private T t;
		
		public T get() {
			
			return t; 
		}
		
		public void set(T t) {
			this.t = t;
		}
		
	}
	
	
	static class GenericExample {
		
		
		public static <T> Box<T> box(T t){
			
			Box<T> box = new Box<>();
			
			box.set(t);
			
			return box;
		}	
		
	}
	
	public static void main(String[] args) {
		
		
		Box<String> box1 = GenericExample.box("홍길동");
		
		String strValue = box1.get(); 
		
		System.out.println(strValue);
		
		
		
		Box<Integer> box2 = GenericExample.box(100);
		
		int intValue = box2.get(); 
		
		System.out.println(intValue);
		
	}
	
}
