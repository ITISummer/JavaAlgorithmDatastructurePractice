package practice.leetcode.easy;

import java.util.Scanner;
/**
 * Given a 32-bit signed integer, reverse digits of an integer. <b>Example 1:
 * <li>Input: 123
 * <li>Output: 321 Example 2:
 * <li>Input: -123
 * <li>Output: -32  Example 3:
 * <li>Input: 120
 * <li>Output: 21
 */

/*
 * Test data: 
 *1534236469->0
 *999999991->199999999
 *2147483647->0
 *2147483642 ->0
 *1000000000->1
 *-2147483648->0
 *-214748364->-463847412
 *901000-> 109
 */
public class ReverseInteger_7 {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a integer:");
		int x = input.nextInt();
		System.out.println(reverse_2(x));
	}// end main

	/**
	 * Use simple and inefficient methods to solve problems.
	 */
	public static int reverse_1(int x) {

		int[] arr = new int[10];// Stores the number of bits of a parameter
		int countDigit = 0;// Calculate the length of the number
		int cf = 0;// Leave the parameter state
		int i = 0;
		// The element that initializes 数组 is 0.
		for (i = 0; i < arr.length; i++) {
			arr[i] = 0;
		} // end for
		
		if (x < 0) {
			cf = 1;
			x *= -1;
		} // end if

		//Get the the digit of parameter and reverse/invert  it.
		i = 0;
		while (x > 0) {
			countDigit++;
			arr[i] = x % 10;
			x /= 10;
			i++;
		} // end while

		// Print the integer
		i = 0;
		long  y = 0;
		for (; i < countDigit; i++) {
			y = y * 10 + arr[i];
		} // end for

		//Judge whether  the integer is valid.
		if(y>2147483647) {
			x = 0;
		}else {
			x = (int)y;
		}//end if
		
		if (cf == 1) {
			x *= -1;
		} // end if

		return x;

	}// end reverse()
	
	/**
	 * Answer online
	 * */
	public static int reverse_2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }//end reverse()
}
