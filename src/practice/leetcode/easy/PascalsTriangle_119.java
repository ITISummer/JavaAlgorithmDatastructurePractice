package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 */
public class PascalsTriangle_119 {
    public List<Integer> getRow(int rowIndex) {
        rowIndex+=1;
        List<List<Integer>> res = new ArrayList<>(rowIndex);
            for (int i = 0; i < rowIndex; i++) {
               List<Integer> temp = new ArrayList<>(i+1);
               temp.add(1);
                for (int j = 1; j < i; j++) {
                    temp.add(res.get(i-1).get(j)+res.get(i-1).get(j-1));
                }
                temp.add(1);
                res.add(temp);
            }
            res.set(0,Arrays.asList(1));
        return res.get(rowIndex-1);
    }
}
