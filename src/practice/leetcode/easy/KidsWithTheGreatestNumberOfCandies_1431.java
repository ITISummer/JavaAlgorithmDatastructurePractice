package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName KidsWithTheGreatestNumberOfCandies_1431
 * @Author LCX
 * @Date 2021 2021-06-19 12:47 p.m.
 * @Version 1.0
 **/
public class KidsWithTheGreatestNumberOfCandies_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // find the original max candy in candies
        int originalMaxNum = 0;
        for (int candy : candies) {
            if (originalMaxNum < candy) {
                originalMaxNum = candy;
            }
        }
        List<Boolean> res = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies < originalMaxNum) {
                res.add(false);
            } else {
                res.add(true);
            }
        }
        return res;
    }
}
