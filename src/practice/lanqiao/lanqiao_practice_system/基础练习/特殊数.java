package practice.lanqiao.lanqiao_practice_system.基础练习;


public class 特殊数{
	public static void main(String[] args) {
		int a1,a2,a3;
		for(int i=100;i<=999;i++) {
			a1=i%10;
			a2=i/10%10;
			a3=i/100%10;
			if(Math.pow(a1, 3)+Math.pow(a2, 3)+Math.pow(a3, 3)==i) {
				System.out.println(i);
			}else {
				continue;
			}
		}//end for
	}
}
