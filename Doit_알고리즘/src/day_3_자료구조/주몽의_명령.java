package day_3_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의_명령 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int material[] = new int[N];

		for (int i = 0; i < N; i++) {
			material[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(material);
		
		int count = 0;
	
		int startPoint  = 0;
		int endPoint = N - 1;

		while (startPoint < endPoint) {
			
			if(material[startPoint] + material[endPoint] > M) {
				endPoint--;
			} else if(material[startPoint] + material[endPoint] < M) {
				startPoint++;
			} else if(material[startPoint] + material[endPoint] == M) {
				count++;
				startPoint++;
				endPoint--;
			}
			
		}
		
		System.out.println(count);
		br.close();

	}

}