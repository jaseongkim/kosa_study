package 참조타입_5장;

public class NullpointExceptionExample {

	public static void main(String[] args) {

		int[] intArray = null;

		intArray[0] = 10; // NullpointException

		String str = null;

		System.out.println("문자 수 : " + str.length()); // NullpointException

	}

}
