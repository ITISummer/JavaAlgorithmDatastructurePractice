package practice.leetcode.easy;

import java.util.Scanner;
import java.util.Stack;

public class PalindromeNumber_9 {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the integer:");			
		int x=input.nextInt();
		System.out.println(isPalindrome_3(x));
	}// end main()

	/**
	 * Data is stored on a stack.
	 */
	
	/*
	 * Test data:
	 * 121
	 * 1221
	 * -121
	 * 10
	 * 1221
	 * */
	public static boolean isPalindrome_1(int x) {
		
		String str = Integer.toString(x);
		char[] cha = str.toCharArray();
		Stack <Character>stack = new Stack<Character>();
		boolean isPalindrome = true;
		
		for(int i=0;i<str.length()/2;i++) {
			stack.push(cha[i]);
		}//end for
		
		int temp=0;
		if(str.length()%2==0) {
			temp= str.length()/2;			
		}else {
			temp = str.length()/2+1;
		}//end if
		
		for(int i=temp;i<str.length();i++) {
			
			if(stack.pop()==cha[i]) {
				isPalindrome = true;
			}else {
				isPalindrome = false;
				break;
			}
		}//end for
		
		return isPalindrome;
	}// end isPalindrome()
	
	/**
	 * Use the Conventional thinking.
	 * */
public static boolean isPalindrome_2(int x) {
		
		String str = Integer.toString(x);
		char[] cha = str.toCharArray();
		boolean isPalindrome = true;
		
		int temp = str.length();
		for(int i=0;i<temp/2;i++) {
			if(cha[i]==cha[temp-i-1]) {
				isPalindrome = true;
			}else {
				isPalindrome = false;
				break;
			}//end if
		}//end for
		
		return isPalindrome;
	}// end isPalindrome()

/**
 * Answer online 
 * Use the MathMetical method.
 * */
public static boolean isPalindrome_3(int x) {
	
	boolean isPalindrome = false;
	int temp = 0;
	
	if(x < 0 || (x % 10 == 0 && x != 0)) {
        return isPalindrome;
    }//end if
	
	while(temp<x) {
		temp = (temp*10)+ (x%10);
		x /= 10;
	}//end while()
	
	if(temp/10==x||temp == x)
		isPalindrome = true;
	
	return isPalindrome;
}// end isPalindrome()
}
