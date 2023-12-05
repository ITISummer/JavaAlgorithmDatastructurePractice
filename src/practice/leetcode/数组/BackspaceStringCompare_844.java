package practice.leetcode.数组;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare_844 {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c != '#') {
                stack.push(c);
            } else if(!stack.empty()){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    public boolean backspaceCompare_1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        // While there may be chars in build(S) or build (T)
        while (i >= 0 || j >= 0) {
            // Find position of next possible char in build(S)
            while (i >= 0) {
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else {
                    break;
                }
            }
            // Find position of next possible char in build(T)
            while (j >= 0) {
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else {
                    break;
                }
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--; j--;
        }
        return true;
    }
}
