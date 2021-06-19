package practice.leetcode.easy;

/**
 * @ClassName ShuffleString_1528
 * @Author LCX
 * @Date 2021 2021-06-19 8:49 p.m.
 * @Version 1.0
 **/
public class ShuffleString_1528 {
    public String restoreString(String s, int[] indices) {
        int sLen = s.length();
        char[] newChar = new char[sLen];
        for (int i = 0; i < sLen; i++) {
            newChar[indices[i]] = s.charAt(i);
        }
        return new String(newChar);
    }
}
