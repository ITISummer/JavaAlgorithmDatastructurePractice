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
    private int pointer;
    private final String[] array;

    public DesignAnOrderedStream_1656(int n) {
        array = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        array[idKey - 1] = value;
        if (array[pointer] == null) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = pointer; i < array.length; i++) {
            if (array[i] == null) {
                pointer = i;
                break;
            }
            list.add(array[i]);
        }
        return list;
    }
}
