package solution;

public class Solution {
	public static String solution(String myString) {
        String answer = "";
        
        for(int q=0; q<myString.length(); q++){
        	if(myString.charAt(q) < 'l') {
        		myString = myString.replace(myString.charAt(q), 'l');
        	}
        }
        
        answer = myString;
        
        return answer;
    }

	public static void main(String[] args) {

		String str = "abcdevwxyz";
//		solution(str);
		System.out.println(solution(str));
	}
}