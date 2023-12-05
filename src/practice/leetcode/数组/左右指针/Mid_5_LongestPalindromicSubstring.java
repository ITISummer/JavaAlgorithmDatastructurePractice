package practice.leetcode.数组.左右指针;

/**
 * @author SummerLv
 * @version 2023/11/26 17:52
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 */
public class Mid_5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length()? res : s1;
            res = res.length() > s2.length()? res : s2;
        }
        
        return res;
    }

    /**
     * 在 s 中寻找以 s[left] 和 s[right] 为中心的最长回文串
     * @param s
     * @param left
     * @param right
     * @return
     */
    public String palindrome(String s, int left, int right) {
        // 防止索引越界
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 双指针，向两边展开
            left--;
            right++;
        }
        // 返回以 s[left] 和 s[right] 为中心的最长回文串
        return s.substring(left+1,right);
    }
}
