package day2_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int dataNo = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		
		//s[0]은 0으로 초기화 시키기 위해 + 1;
		long[] sum = new long[dataNo+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<dataNo+1; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i= 0; i< quizNo; i++) {
			st = new StringTokenizer(br.readLine());
			int startNum = Integer.parseInt(st.nextToken());
			int endNum = Integer.parseInt(st.nextToken());
			System.out.println(sum[endNum]-sum[startNum-1]);
		}
	}
}