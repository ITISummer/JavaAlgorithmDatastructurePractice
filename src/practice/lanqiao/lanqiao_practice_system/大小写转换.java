package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 大小写转换 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		char a[] = str.toCharArray();
		for(int i=0;i<a.length;i++) {
			if(a[i]>='A'&&a[i]<='Z') {
				a[i]=(char)(a[i]+32);
			}else {
				a[i]=(char)(a[i]-32);
			}
		}//end for
		for(char c:a)
			System.out.print(c);
	}

}
