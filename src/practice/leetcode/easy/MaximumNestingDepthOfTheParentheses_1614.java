package practice.leetcode.easy;

import java.util.Stack;

/**
 * @ClassName MaximumNestingDepthOfTheParentheses_1614
 * @Author LCX
 * @Date 2021 2021-06-20 6:55 p.m.
 * @Version 1.0
 **/
public class MaximumNestingDepthOfTheParentheses_1614 {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                max = Math.max(max, stack.size());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return max;
    }
}
