package practice.lanqiao.lanqiao_practice_system;


import java.util.Scanner;

public class 进制转换 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		int sum=0,count=0;
		for(int i=0;i<str.length();i++) {
		switch(str.charAt(i)) {
		case '0': sum=0; break;
		case '1': sum=1; break;
		case '2': sum=2; break;
		case '3': sum=3; break;
		case '4': sum=4; break;
		case '5': sum=5; break;
		case '6': sum=6; break;
		case '7': sum=7; break;
		case '8': sum=8; break;
		case '9': sum=9; break;
		case 'A': sum=10; break;
		case 'B': sum=11; break;
		case 'C': sum=12; break;
		case 'D': sum=13; break;
		case 'E': sum=14; break;
		case 'F': sum=15; break;
		}
		count+=sum*Math.pow(16, str.length()-(i+1));
		}
		System.out.println("Hex: 0x"+str);
		System.out.println("Decimal: "+count);
		new Integer(count);
		String s = Integer.toOctalString(count);
		if(s.length()==3)
		System.out.println("Octal: 0"+s);
		else if(s.length()==2)
			System.out.println("Octal: 00"+s);
		else if(s.length()==1)
			System.out.println("Octal: 000"+s);
		else
			System.out.println("Octal: "+s);
}//end main()
}
