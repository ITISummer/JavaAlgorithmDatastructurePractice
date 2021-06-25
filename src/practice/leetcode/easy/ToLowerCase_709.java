package practice.leetcode.easy;


/**
 * @ClassName ToLowerCase_709
 * @Author LCX
 * @Date 2021 2021-06-22 10:09 a.m.
 * @Version 1.0
 **/
public class ToLowerCase_709 {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public String toLowerCase_2(String s) {
        int len = s.length();
        StringBuilder res = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            // uppercase letters
            if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
                res.append((char) (s.charAt(i) + 32));
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
