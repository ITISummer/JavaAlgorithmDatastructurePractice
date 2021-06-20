package practice.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName SortSentence_1859
 * @Author LCX
 * @Date 2021 2021-06-20 9:25 p.m.
 * @Version 1.0
 **/
public class SortSentence_1859 {
    public String sortSentence(String s) {
        String[] strings = s.split(" ");
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(o1.length() - 1);
                char c2 = o2.charAt(o2.length() - 1);
                if (c1 > c2) {
                    return 1;
                } else if (c1 == c2) {
                    return 0;
                }
                return -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string.substring(0, string.length() - 1) + " ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
