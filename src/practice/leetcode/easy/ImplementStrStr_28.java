package practice.leetcode.easy;

import java.util.Scanner;

public class ImplementStrStr_28 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a string(hayStack):");
		String hayStack = input.next();
		System.out.println("Please input a string(needle):");
		String needle = input.next();
		System.out.println(strStr_1(hayStack, needle));
	}// end main()

	/**
	 * 1. Find the same character in "haystack" as the first "needle" character.
	 * 2. Start with this character and move back in the "haystack" one by one against the characters in the "needle".
	 * */
	/*
	 * Input: haystack = "hello", needle = "ll"
	 * Output: 2
	 * Input: haystack = "helollo", needle = "ll"
	 * Output: 4
	 * Input: haystack = "aaaaa", needle = "bba"
	 *	Output: -1
	 *Input: haystack = "a", needle = ""
	 * Output: 0
	 * Input: haystack = "abcd", needle = "b"
	 * Output: 0
	 * */
	public static int strStr_1(String hayStack, String needle) {
		int i = 0;
		boolean isInclude = false;
		// Judge "needle" is valid.
		if (needle.length()==0 || needle == null) {
			return 0;
		} // end if
		if (needle.length() > hayStack.length()) {
			return -1;
		} else {
			for (i = 0; i < hayStack.length(); i++) {
				if (hayStack.charAt(i) == needle.charAt(0)&&(hayStack.length()-i>=needle.length())) {
					int k = i;
					isInclude = true;
					for (int j = 1; j < needle.length(); j++) {
						if (needle.charAt(j) == hayStack.charAt(++k)) {
							isInclude = true;
						} else {
							isInclude = false;
							break;
						} // end if
					} // end for
				} else {
					continue;
				}//end if
				if (isInclude == true) {
					break;
				} // end if
			} // end for
		} // end if
		return i < hayStack.length() ? i : -1;
	}// end strStr()
	
	/**
	 * Use the method of  string class.
	 * */
	public static int strStr_2(String hayStack, String needle) {
		return hayStack.indexOf(needle);
	}// end strStr()
}//end ImplementStrStr_28
