package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DecompressRunLengthEncodedList_1313
 * @Author LCX
 * @Date 2021 2021-06-19 10:39 p.m.
 * @Version 1.0
 **/
public class DecompressRunLengthEncodedList_1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            int freq = nums[2 * i];
            int val = nums[2 * i + 1];
            for (int j = 0; j < freq; j++) {
                res.add(val);
            }
        }
        // parse Object[] to int[]
        int[] re = new int[res.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = res.get(i);
        }
        return re;
        // return resultList.stream().mapToInt(i -> i).toArray();
    }
}
