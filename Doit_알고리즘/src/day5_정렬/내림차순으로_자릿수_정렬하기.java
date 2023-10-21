package day5_정렬;

import java.io.IOException;
import java.util.Scanner;

public class 내림차순으로_자릿수_정렬하기 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int[] A = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i + 1));
		}

		for (int i = 0; i < str.length(); i++) {
			int max = i;
			for (int j = i + 1; j < str.length(); j++) {

				if (A[j] > A[max]) {
					max = j;
				}
			}
			if (A[i] < A[max]) {
				int temp = A[i];
				A[i] = A[max];
				A[max] = temp;
			}

		}

		for (int i = 0; i < str.length(); i++) {
			System.out.println(A[i]);
		}

	}

}
