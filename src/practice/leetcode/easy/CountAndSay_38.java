package practice.leetcode.easy;

import java.util.Scanner;

public class CountAndSay_38 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a integer:");
        int n = input.nextInt();
        System.out.println(countAndSay_2(n));

    }// end main()

    public static String countAndSay_1(int n) {

		StringBuilder str = new StringBuilder("1");
		if (n <= 0 || n > 30) {
			return null;
		} else {
			int i = 1;
			int num = 1;// Count the number of character.
			int temp = 1;// Control the whileLoop.
			while (temp < n) {
				StringBuilder str_1 = new StringBuilder();
				for (i = 1; i < str.length(); i++) {
					if (str.charAt(i) == str.charAt(i - 1)) {
						num += 1;
					} else {
						str_1.append(num + "" + str.charAt(i - 1));
						num = 1;
					} // end if
				} // end for
				str_1.append(num + "" + str.charAt(i - 1));
				num = 1;
				str = str_1;
				temp++;
			} // end while
		} // end if
		return str.toString();
	}// end countAndSay()

	public static String countAndSay_2(int n) {

		StringBuilder str = new StringBuilder("");
		if (n >= 1 && n <= 30) {
			str.append("1");
			str = countAndSay_2_1(n, str);
		} else {
			;
		} // end if
		return str.toString();
	}// end countAndSay()

	public static StringBuilder countAndSay_2_1(int n, StringBuilder str) {

		if (n > 1) {
			int i = 1;
			int num = 1;// Count the number of character.
			StringBuilder str_1 = new StringBuilder();
			for (i = 1; i < str.length(); i++) {
				if (str.charAt(i) == str.charAt(i - 1)) {
					num += 1;
				} else {
					str_1.append(num + "" + str.charAt(i - 1));
					num = 1;
				} // end if
            } // end for
            str_1.append(num + "" + str.charAt(i - 1));
            str = str_1;
            str = countAndSay_2_1(--n, str);
//			return str;
        } else {
            ;
        } // end if
        return str;
    }// end countAndSay_2_1()
}// end CountAndSay_38
