package practice.lanqiao.lanqiao_practice_system.基础练习;

public class 十转二进制 {
	public static void main(String[] args) {
		for(int i=0;i<32;i++) {
			fun(1,i);
			System.out.println();
		}
	}//end main()
	private static void fun(int n,int num) {
		
		if(n==5) {
			System.out.print(num%2);
			return ;
		}else {
			fun(n+1,num/2);
			System.out.print(num%2);
			return ;
		}
		
	}//end fun()
}
