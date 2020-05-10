package practice.lanqiao.lanqiao_practice_system.基础练习;

public class 回文数 {
	public static void main(String[] args) {
		int a1,a2,a3,a4;
		for(int i=1000;i<=9999;i++) {
			a1=i%10;
			a2=i/10%10;
			a3=i/100%10;
			a4=i/1000%10;
			if(a1==a4&&a2==a3) {
				System.out.println(i);
			}else
				continue;
		}//end for
	}
}
