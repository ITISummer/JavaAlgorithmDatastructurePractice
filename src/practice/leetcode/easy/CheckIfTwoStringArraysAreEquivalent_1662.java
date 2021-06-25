package practice.leetcode.easy;

/**
 * @ClassName CheckIfTwoStringArraysAreEquivalent_1662
 * @Author LCX
 * @Date 2021 2021-06-21 10:22 a.m.
 * @Version 1.0
 **/
public class CheckIfTwoStringArraysAreEquivalent_1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }
        System.out.println(sb1);
        System.out.println(sb2);
        if (sb1.toString().equals(sb2.toString())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfTwoStringArraysAreEquivalent_1662 obj = new CheckIfTwoStringArraysAreEquivalent_1662();
        String[] w1 = new String[]{"ab", "c"};
        String[] w2 = new String[]{"a", "bc"};
        boolean res = obj.arrayStringsAreEqual(w1, w2);
        System.out.println(res);
    }
}
