package algorithm.kmp;

import java.util.Arrays;

/**
 * 字符串匹配 - KMP 算法
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext("ABCDABD"); // [0,0,0,0,1,2,0]
        System.out.println(Arrays.toString(next));

        int index = kmp(str1,str2,next);
        System.out.println(index);
    }

    /**
     *
     * @param str1
     * @param str2
     */
    public static int kmp(String str1, String str2, int[] next) {
        for (int i = 0,j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            } //end if
        } //end for
        return -1;
    }

    /**
     * 求得一个字符串的部分匹配值表
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串的长度是1的话，部分匹配值就是 0
        for (int i = 1,j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //当满足如下条件时，部分匹配值 +1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        } //end for
        return next;
    }
}
