package practice.lanqiao.lanqiao_practice_system;

public class 斐波那契 {
	public static int fn(int num) {
		if(num<3) {
			return 1%10007;
		}else {
			
			return (fn(num-1)+fn(num-2))%10007;
		}//end if
		
	}//end fn()
	public static void main(String[] args) {
		System.out.println(fn(10));
	}
}
