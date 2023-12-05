package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DesignAnOrderedStream_1656
 * @Author LCX
 * @Date 2021 2021-06-20 10:07 p.m.
 * @Version 1.0
 **/
public class DesignAnOrderedStream_1656 {
    private int pointer = 0;
    private final String[] array;

    public DesignAnOrderedStream_1656(int n) {
        array = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        // insert a value
        array[idKey - 1] = value;
        // return []
        if (array[pointer] == null) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        // search null position that after pointer position
        for (int i = pointer; i < array.length; i++) {
            if (array[i] == null) {
                pointer = i;
                break;
            }
            // add non-null values in 数组 before meet next null position
            list.add(array[i]);
        }
        return list;
    }
}
