package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class AestheticLesson {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int kid = scanner.nextInt();
		int picture = scanner.nextInt();
		int[][] array = new int[kid][picture];
		for (int i = 0; i < kid; i++) {
			for (int j = 0; j < picture; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		taste(array, kid, picture);
	}

	public static void taste(int[][] array, int kid, int picture) {
		int count = 0;
		int INF = (1 << picture) - 1;
		int[] ten = new int[INF + 1];
		for (int i = 0; i < kid; i++) {
			int sum = 0;
			for (int j = 0; j < picture; j++) {
				sum = (sum << 1) + array[i][j];
			}//end for
			ten[sum]++;
		}//end for

		for (int x = 0; x < ten.length; x++) {
			if (ten[x] != 0) {
				int y = x ^ INF;
				count += ten[y] * ten[x];
			}
		}
		System.out.println(count / 2);
	}
}
