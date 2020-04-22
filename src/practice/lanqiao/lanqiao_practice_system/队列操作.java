package practice.lanqiao.lanqiao_practice_system;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 队列操作 {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner input =new Scanner(System.in);
		int n=input.nextInt();
		int operations = 0;
		int i=1;
		while(i++<=n) {
			operations=input.nextInt();
			switch(operations) {
			case 1: queue.offer(input.nextInt());break;
			case 2: if(!queue.isEmpty())
									System.out.println(queue.poll());
							else
									System.out.println("no");break;
			case 3: System.out.println(queue.size());break;
			}//end switch 
			
		}//end while
		input.close();
	}//end main()

}
