package practice.leetcode.easy;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses_20 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a string:");
		String s = input.next();
		System.out.println(isValid_1(s));
	}//end main
	
	/**
	 * Use Stack.
	 * */
	
	/*
	 * Test Data:
	 * ()--true
	 * ()[]{}--true
	 * {[]}--true
	 * ((()))([{}])--true
	 * {{(}})[(])--false
	 * (]-- false
	 * ([)]--false
	 * [])--false
	 * [--false
	 * ([]--false
	 * */
public static boolean isValid_1(String s) {
	boolean isMatch = false;
	//There should be a procedure for handling strings.
	if(s==null)
		return false;
	if(s .length()!= 0) {
		char []cha = s.toCharArray();
		Stack <Character>charStack = new Stack<Character>();
		if(charStack.isEmpty()) {
			charStack.push(cha[0]);
			for(int i=1;i<cha.length;i++) {
				if(cha[i]=='('||cha[i]=='['||cha[i]=='{') {
					charStack.push(cha[i]);
				}else if((!charStack.isEmpty())&&(cha[i]==')'&&charStack.peek()=='('||cha[i]==']'&&charStack.peek()=='['||cha[i]=='}'&&charStack.peek()=='{')){
						charStack.pop();
						isMatch = true;
				}else {
					isMatch = false;
					break;
				}//end if
			}//end for
		}//end if
		if(!charStack.isEmpty()) {
			isMatch = false;
		}//end if
	}else {
		isMatch = true;
	}//end if
	return isMatch;
    }//end isValid()
}//end ValidParentheses_20
