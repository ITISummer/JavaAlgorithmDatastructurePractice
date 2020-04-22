package practice.lanqiao.lanqiao_practice_system;


public class 简单加法{
	public static void main(String[] args) {
		int sum=0;
		for(int i=3;i<1000;i++) {
			if(i%3==0||i%5==0) {
				sum+=i;
			}//end if
		}//end for
		System.out.println(sum);
	}
}
