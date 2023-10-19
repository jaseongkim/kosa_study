package day2_자료구조;

import java.io.IOException;
import java.util.Scanner;

public class 평균_구하기 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] point = new int[N];

		long max = 0;
		long sum = 0;
	
		for (int i = 0; i < N; i++) {
			point[i] = sc.nextInt();
			if (point[i] > max) {
				max = point[i];
			}
			sum += point[i];
		}

		for (int i = 0; i < N; i++) {
			
		}

		System.out.println(sum * 100.0 / max / N);

	}
}
