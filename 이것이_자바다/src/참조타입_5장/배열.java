package 참조타입_5장;

public class 배열 {
	
	public static void main(String[] args) {
		
		//배열 NullpointException 확인
		String[] stringArray1 = new String[5];
		
		System.out.println(stringArray1[0]);
		
		String[] stringArray2 = null;
		
//		System.out.println(stringArray2[0]); //NullpointException
		
//		--------------------------------------------------------------
		
		// 중괄호 사용 주의사항
		String strArray1[] = {"안녕","잘가"};
		
		System.out.println(strArray1[0]);
		
		String strArray2[];
//		strArray2 = {"안녕","잘가"}; // 컴파일 에러
		
		strArray2 = new String[] {"안녕","잘가"};
		System.out.println(strArray1[0]);
		
		
	
		
		
		
		
	}
}