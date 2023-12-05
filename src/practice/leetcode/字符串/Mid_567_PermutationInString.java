package practice.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/*
1. 当移动 right 扩大窗口，即加入字符时，应该更新哪些数据？(window,valid)
2. 什么条件下，窗口应该暂停扩大，开始移动 left 缩小窗口？(right - left >= t.length())
3. 当移动 left 缩小窗口，即移出字符时，应该更新哪些数据？(window,valid)
4. 我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？缩小
 */

/**
 * @author SummerLv
 * @version 2023/11/24 16:25
 */
public class Mid_567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        // 将 s1 放入 need
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        // 记录窗口边界以及合法字符串数量
        int left = 0, right = 0, valid = 0;

        // 窗口大小 [left,right), 扩大窗口
        while (right < s2.length()) {
            char c = s2.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内一系列数据更新
            if (need.containsKey(c)) {
                // 更新 window
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 更新 valid
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 缩小窗口
            while (right - left >= s1.length()) {
                // 包含合法的子串
                if (valid == need.size()) {
                    return true;
                }
                // d 是将移出窗口的字符
                char d = s2.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    // 更新 valid
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    // 更新 window
                    window.put(d, window.get(d) - 1);
                }
            }
        } // while
        return false;
    }
}
