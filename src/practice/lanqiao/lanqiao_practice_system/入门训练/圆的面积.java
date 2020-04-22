package practice.lanqiao.lanqiao_practice_system.入门训练;


import java.util.Scanner;

public class 圆的面积 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double r = input.nextDouble();
		System.out.printf("%.7f",Math.PI*Math.pow(r, 2));
	}
}
