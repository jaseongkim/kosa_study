package 클래스_6장;

public class 가변길이_매개변수 {

	public static int sum (int ... value) {
		
		int result = 0;
		
		for(int i = 0; i<value.length; i++) {
			result += value[i];
		}
		return result;
	}

	public static void main(String[] args) {
		
		int result = sum(1,2,3,4,5,6,7,8,9);
		
		System.out.println(result);
		
	}
}