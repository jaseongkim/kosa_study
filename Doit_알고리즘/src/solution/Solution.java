package solution;

public class Solution {
	public static int solution(String binomial) {
		int answer = 0;

		String[] str = binomial.split(" ");

		int aNum = Integer.parseInt(str[0]);

		int bNum = Integer.parseInt(str[2]);

		String op = str[1];
		
		if(op.equals("+")) {
			answer = aNum + bNum;
		} else if(op.equals("-")) {
			answer = aNum + bNum;
		} else if(op.equals("*")) {
			answer = aNum * bNum;
		} 
		
		return answer;
	}

	public static void main(String[] args) {

		String str = "43 + 12";
		System.out.println(solution(str));
	}
}