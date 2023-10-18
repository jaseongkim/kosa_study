package 참조타입_5장;

public class 문자열 {

	public static void main(String[] args) {
		
		// 문자열 비교
		String name1 ="홍길동";
		String name2 ="홍길동";
		
		System.out.println(name1 == name2);
		
		
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		
		System.out.println(name1 == name4);
		System.out.println(name2 == name4);
		System.out.println(name3 == name4);
		
		// 주소 값이 아닌 내부 내용만 비교해야 할 때는 equals를 사용
		System.out.println(name1.equals(name4));
		System.out.println(name2.equals(name4));
		System.out.println(name3.equals(name4));
		
//		-------------------------------------------------------------
		
		// 문자열 추출
		for(int i =0 ; i<name1.length(); i++) {
			System.out.println(name1.charAt(i));
		}
		
		// String 객체의 문자열을 변경이 불가한 특성이 있다
		// 문자열 안의 내용을 바꿔주면 새로운 주소 값의 String 객체가 생겨나게 된다
		
//		-------------------------------------------------------------
		
		//문자열 자르기 
		String str ="문자열 자르기 테스트";
		String subStr1 = str.substring(1);
		String subStr2 = str.substring(0,5); //endindex 앞까지  
		
		System.out.println(subStr1);
		System.out.println(subStr2);
		
	}
}