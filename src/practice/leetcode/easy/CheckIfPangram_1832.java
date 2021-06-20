package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CheckIfPangram_1832
 * @Author LCX
 * @Date 2021 2021-06-20 9:08 p.m.
 * @Version 1.0
 **/
public class CheckIfPangram_1832 {
    public boolean checkIfPangram(String sentence) {
        int len = sentence.length();
        if (len < 26) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(sentence.charAt(i));
        }
        if (set.size() == 26) {
            return true;
        }
        return false;
    }

    /**
     * solution 2
     */
    public boolean checkIfPangram_2(String sentence) {
        return sentence.chars().distinct().count() == 26 ? true : false;
    }

    /**
     * solution 3
     */
    public boolean checkIfPangram_3(String sentence) {
        boolean[] found = new boolean[26];
        int count = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (!found[sentence.charAt(i) - 'a']) {
                found[sentence.charAt(i) - 'a'] = true;
                count++;
            }
            if (count == 26) {
                return true;
            }
        }
        return false;
    }
}
