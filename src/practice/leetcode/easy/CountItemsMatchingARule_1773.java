package practice.leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CountItemsMatchingARule_1773
 * @Author LCX
 * @Date 2021 2021-06-20 10:50 a.m.
 * @Version 1.0
 **/
public class CountItemsMatchingARule_1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        Map<String, Integer> keyMap = new HashMap<>();
        keyMap.put("type", 0);
        keyMap.put("color", 1);
        keyMap.put("name", 2);
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(keyMap.get(ruleKey)))) {
                res++;
            }
        }
        return res;
    }

    /**
     * solution 2
     */
    public int countMatches_2(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            if ((ruleKey.equals("type") && ruleValue.equals(item.get(0))) ||
                    (ruleKey.equals("color") && ruleValue.equals(item.get(1))) ||
                    (ruleKey.equals("name") && ruleValue.equals(item.get(2)))) {
                count++;
            }
        }
        return count;
    }
}
