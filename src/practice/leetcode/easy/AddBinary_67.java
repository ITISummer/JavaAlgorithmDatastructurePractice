package practice.leetcode.easy;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/add-binary/
 * TestCase:
 * a = "11"
 * b = "1"
 *
 * a="1010"
 * b="1011"
 */
public class AddBinary_67 {
    /**
     * BigInteger
     * @param a
     * @param b
     * @return
     */
    public static String addBinary_1(String a, String b) {
        BigInteger n = new BigInteger(a,2);
        BigInteger m = n.add(new BigInteger(b,2));
//        System.out.println(m.toString(2));
        return m.toString(2);
    }

    public static String addBinary_2(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        int sum = 0;
        while (i>=0||j>=0) {
           sum = carry;
           if(i>=0) sum+=a.charAt(i--)-'0';
           if(j>=0) sum+=b.charAt(j--)-'0';
           carry = sum>1?1:0;
           res.append(sum%2);
        }
        if(carry != 0) res.append(carry);
//        System.out.println(res.reverse().toString());
        return res.reverse().toString();
    }
    public static void main(String[] args) {
//        AddBinary_67.addBinary_1("11","1");
        AddBinary_67.addBinary_2("11","1");
    }
}
