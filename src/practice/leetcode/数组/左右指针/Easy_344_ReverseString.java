package practice.leetcode.数组.左右指针;

/**
 * @author SummerLv
 * @version 2023/11/26 17:46
 * https://leetcode.cn/problems/reverse-string/
 */
public class Easy_344_ReverseString {
    public void reverseString(char[] s) {
        int left = 0,right = s.length-1;
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            
            left++;
            right--;
        }
    }
}
