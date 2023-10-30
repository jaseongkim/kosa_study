package java_base_모듈_12장;

import java.lang.reflect.Method;

public class Test {

	
	public void test() {
		System.out.println("method 호출");
	}
	
	
	public static void main(String[] args) throws Exception {
		
		
		Method[] methods = Test.class.getDeclaredMethods();
		
		for(Method method : methods) {
			System.out.println(method);
		}
		
		methods[1].invoke(new Test());
		
	}
	
}
