package solution;

public class Solution {
	public static String[] solution(String[] strArr) {
		String[] answer = {};

		int cnt = 0;
		for (int i = 0; i < strArr.length; i++) {
			if (!strArr[i].contains("ad")) {
				cnt++;
			}
		}
		
		answer = new String[cnt];
		
		for (int i = 0,j = 0; i < strArr.length; i++, j++) {
			if(strArr[i].contains("ad")) {
				j--;
				continue;
			}
			answer[j]=strArr[i];	
		}
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		


		return answer;
	}

	public static void main(String[] args) {

		String[] str = { "and","notad","abcd" };
		System.out.println(solution(str));
	}
}