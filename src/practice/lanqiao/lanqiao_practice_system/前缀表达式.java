package practice.lanqiao.lanqiao_practice_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 前缀表达式 {

		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			String s=bf.readLine();
			String [] str = s.split(" ");
			int a=Integer.parseInt(str[1]);
			int b=Integer.parseInt(str[2]);
			if("+".equals(str[0])){
				add(a,b);
			}else if("-".equals(str[0])){
				subtract(a, b);
			}else if("*".equals(str[0])){
				multiply(a, b);
			}else{
				divide(a, b);
			}
		}	
		public static void add(int a, int b){			
			System.out.println(a + b);
		}
		public static void subtract(int a, int b){
			System.out.println(a - b);
		}
		public static void multiply(int a, int b){
			System.out.println(a * b);
		}

		public static void divide(int a, int b){
			if(b != 0){
				System.out.println(a / b);
			}else {
				System.out.println("by zero");
			}
		}

	}

