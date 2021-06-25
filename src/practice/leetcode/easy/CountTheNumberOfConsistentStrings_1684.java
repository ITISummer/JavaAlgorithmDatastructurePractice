package practice.leetcode.easy;

import java.util.HashSet;

/**
 * @ClassName CountTheNumberOfConsistentStrings_1684
 * @Author LCX
 * @Date 2021 2021-06-21 4:26 p.m.
 * @Version 1.0
 **/
public class CountTheNumberOfConsistentStrings_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        int allLen = allowed.length();
        HashSet<Character> hashSet = new HashSet<>(allLen);
        for (int i = 0; i < allLen; i++) {
            hashSet.add(allowed.charAt(i));
        }
        int size = hashSet.size();

        // add word and calculate the new size of hashSet
        for (String word : words) {
            boolean flag = true;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                if (hashSet.add(word.charAt(i))) {
                    hashSet.remove(word.charAt(i));
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }

    /**
     * solution 2
     */
    public int countConsistentStrings_2(String allowed, String[] words) {

        int[] countArray = new int[26];
        for (char c : allowed.toCharArray()) {
            countArray[c - 'a']++;
        }

        int count = 0;
        for (String str : words) {
            boolean isValid = true;
            for (char c : str.toCharArray()) {
                if (countArray[c - 'a'] == 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) count++;
        }
        return count;
    }

    /**
     * solution 3
     */
    public int countConsistentStrings_3(String allowed, String[] words) {
        int count = 0;
        for (String word : words) {
            boolean isValid = true;
            for (int i = 0; i < word.length(); i++) {
                if (!allowed.contains(String.valueOf(word.charAt(i)))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) count++;
        }
        return count;
    }
}
