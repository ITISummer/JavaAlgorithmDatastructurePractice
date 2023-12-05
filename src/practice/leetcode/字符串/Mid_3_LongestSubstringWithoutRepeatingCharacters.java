package practice.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SummerLv
 * @version 2023/11/26 11:13
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class Mid_3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            // 更新右边界
            char c = s.charAt(right++);
            window.put(c,window.getOrDefault(c,0)+1);
            
            while (window.get(c) > 1) {
                // 更新左边界
                char d = s.charAt(left);
                left++;
                window.put(d,window.get(d)-1);
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
