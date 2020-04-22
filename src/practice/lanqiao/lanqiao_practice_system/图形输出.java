package practice.lanqiao.lanqiao_practice_system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class 图形输出 {

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int number = Integer.valueOf(br.readLine());
			for (int i = 0; i < number; i++) {
				for (int j = i; j < number; j++) {
					if (i != number - 1)
						System.out.print("* ");
					else
						System.out.print("*");
				}
				System.out.println();
			}
		}

	}

