package 클래스_6장;

public class 싱글톤_패턴 {
	
	private static 싱글톤_패턴 singleton = new 싱글톤_패턴();
	
	private 싱글톤_패턴() {	
	}
	
	public static 싱글톤_패턴 getInstance() {
		return singleton;
	}

	public static void main(String[] args) {
		
		싱글톤_패턴 singleton1 = 싱글톤_패턴.getInstance(); 
		싱글톤_패턴 singleton2 = 싱글톤_패턴.getInstance(); 
		
		System.out.println(singleton1);
		System.out.println(singleton2);
		
		System.out.println(singleton1 == singleton2);
	}
}