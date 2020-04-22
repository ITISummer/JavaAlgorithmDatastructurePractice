package datastructure.linkedlooplist;

import java.util.Scanner;

/**
 * 
 * @ClassName: JosephRing
 * @Description: TODO(约瑟夫环问题)
 *               约瑟夫问题是个著名的问题：N个人围成一圈，第一个人从1开始报数，报M的将被杀掉，下一个人接着从1开始报。如此反复，最后剩下一个，求最后的胜利者。
 *               例如只有三个人，把他们叫做A、B、C，他们围成一圈，从A开始报数，假设报2的人被杀掉。
 *               首先A开始报数，他报1。侥幸逃过一劫。 然后轮到B报数，他报2。非常惨，他被杀了 C接着从1开始报数
 *               接着轮到A报数，他报2。也被杀死了。 最终胜利者是C
 * @author LCX
 * @date 2019年10月22日
 *
 */
public class JosephRing {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("请输入人的个数：");
		int n = input.nextInt();
		System.out.println("请输入开始报数的人的序号：");
		int k = input.nextInt();
		System.out.println("请输入每次报数的次数：");
		int m = input.nextInt();
		
		//生成一个链表
		LinkedLoopList linkedLoopList = new LinkedLoopList();
		for (int i = 1; i <= n; i++) {
			linkedLoopList.tailInsert(i);
		}
		
		linkedLoopList.josephRingShow(k, m);
		
	}//end main()
}
