package practice.leetcode.字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1. 当移动 right 扩大窗口，即加入字符时，应该更新哪些数据？(window,valid)
2. 什么条件下，窗口应该暂停扩大，开始移动 left 缩小窗口？(right - left >= t.length())
3. 当移动 left 缩小窗口，即移出字符时，应该更新哪些数据？(window,valid)
4. 我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？缩小
*/

/**
 * @author SummerLv
 * @version 2023/11/26 10:18
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 */
public class Mid_438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        // 案例1
//        String s = "cbaebabacd";
//        String p = "abc";
        // 案例2
        String s = "abab";
        String p = "ab";
        List<Integer> res = findAnagrams(s, p);
        System.out.println(res);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
        }
//        System.out.println(need);
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            // 右边界更新
            char c = s.charAt(right);
            right++;

            // 更新 window 和 valid
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
           // 左侧窗口更新
           while(right - left >= p.length()) {
               // 更新结果
               if(valid == need.size()) {
                   res.add(left);
               }

               // 左边界更新
               char d = s.charAt(left);
               left++;
               
               // 更新 window 和 valid
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
        return res;
    }
}
