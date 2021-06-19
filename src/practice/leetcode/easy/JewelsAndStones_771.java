package practice.leetcode.easy;

/**
 * @ClassName JewelsAndStones_771
 * @Author LCX
 * @Date 2021 2021-06-19 1:29 p.m.
 * @Version 1.0
 **/
public class JewelsAndStones_771 {
    /**
     * solution 1
     */
    public int numJewelsInStones(String jewels, String stones) {
        int len = jewels.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int tempLen = stones.length();
            stones = stones.replace(jewels.subSequence(i, i + 1), "");
            int newLen = stones.length();
            res += (tempLen - newLen);
        }
        return res;
    }

    /**
     * solution 2
     */
    public int numJewelsInStones_2(String jewels, String stones) {
        int JewelsLen = jewels.length();
        int res = 0;
        int stonesLen = stones.length();
        for (int i = 0; i < JewelsLen; i++) {
            for (int j = 0; j < stonesLen; j++) {
                if (stones.charAt(j) == jewels.charAt(i)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        JewelsAndStones_771 j = new JewelsAndStones_771();
        System.out.println(j.numJewelsInStones("aA", "aAAbbbb"));
    }
}
