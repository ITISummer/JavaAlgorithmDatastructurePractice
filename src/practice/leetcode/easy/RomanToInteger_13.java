package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class RomanToInteger_13 {
	public static void main(String[] args) {
		System.out.println("Please input a roman numeral:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String s = input.next();
		System.out.println(romanToInt_3(s));
	}// end main()

	/**
	 * Conventional thinking.
	 * Scan from head to tail and use Map or Array.
	 */
	/*
	 * Test Data: 
	 * III--3 
	 * IV--4 
	 * IX--9 
	 * LVIII--58 
	 * MCMXCIV--1994
	 * MCCCXIV--1314
	 * MMMIX--3009
	 * MMMCCXLIX--3249
	 */
	public static int romanToInt_1(String s) {
		char[] str = s.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int num = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (map.get(str[i]) >= map.get(str[i + 1])) {
				num += map.get(str[i]);
			} else {
				num -= map.get(str[i]);
			} // end if
		} // end for
		num += map.get(str[str.length - 1]);
		return num;
	}// end romanToInt()
	
	/**
	 * Conventional thinking.
	 * Scan from head to tail and use Stack to reserve the total.
	 */
	public static int romanToInt_2(String s) {
		char[] str = s.toCharArray();
		Stack <Integer>romanStack = new Stack<Integer>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		

		int num = 0;
		romanStack.push(map.get(str[0]));
		for (int i = 1; i < s.length() ; i++) {
			if (map.get(str[i]) <= map.get(str[i - 1])) {
				romanStack.push(map.get(str[i]));
			} else {
				romanStack.push(map.get(str[i])-romanStack.pop());
			} // end if
		} // end for
		
		//Don't write "for(int I =0;I < romanStack. The size ();I++) ", 
		//because the stack size is fetched every time the loop occurs
		int length = romanStack.size();
		for(int i=0;i<length;i++) {
			num += romanStack.pop();
		}//end for
		return num;
	}// end romanToInt()
	
	public static int romanToInt_3(String s) {
		int num = 0;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='I') {num += 1;}
			if(c=='V') {num += 5;}
			if(c=='X') {num += 10;}
			if(c=='L') {num += 50;}
			if(c=='C') {num += 100;}
			if(c=='D') {num += 500;}
			if(c=='M') {num += 1000;}
			
		}//end for
		
		if(s.contains("IV")) {num -= 2;}
		if(s.contains("IX")) {num -= 2;}
		if(s.contains("XL")) {num -= 20;}
		if(s.contains("XC")) {num -= 20;}
		if(s.contains("CD")) {num -= 200;}
		if(s.contains("CM")) {num -= 200;}
		
		return num;
	}// end romanToInt()
}// end RomanToInteger_13
