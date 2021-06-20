package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CreateTargetArray_1389
 * @Author LCX
 * @Date 2021 2021-06-20 9:57 a.m.
 * @Version 1.0
 **/
public class CreateTargetArray_1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int i = 0; i < index.length; i++) {
            res.add(index[i], nums[i]);
        }

        // parse Object[] to int[]
        int[] re = new int[res.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = res.get(i);
        }
        return re;
//        return res.stream().mapToInt(i -> i).toArray(); // slower
    }
}
