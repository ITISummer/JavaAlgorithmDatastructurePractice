package practice.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SummerLv
 * @version 2023/11/24 14:48
 * https://leetcode.cn/problems/minimum-window-substring/description/
 */
public class Hard_76_MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s,t);
        System.out.println(res);
    }
    public static String minWindow(String s, String t) {
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();
        // 将 t 放入 need
        for(int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
//        System.out.println(need);
        // 记录窗口边界以及合法字符串数量
        int left = 0, right = 0, valid = 0;
        // 记录最小覆盖子串的起始索引长度
        int start = 0, len = Integer.MAX_VALUE;
        
        // 窗口大小 [left,right), 扩大窗口
        while (right < s.length()) {
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内一系列数据更新
            if(need.containsKey(c)) {
                // 更新 window
                window.put(c,window.getOrDefault(c,0)+1);
                // 更新 valid
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            // 缩小窗口
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if(right - left < len) {
                    start = left; // 起始位置
                    len = right - left; // 窗口长度
                }
                
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)) {
                    // 更新 valid
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    // 更新 window
                    window.put(d,window.get(d)-1);
                }
            }
        } // while
        return len==Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
    
}
