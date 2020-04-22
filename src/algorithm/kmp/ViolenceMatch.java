package algorithm.kmp;

/**
 * 字符串暴力匹配算法
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        int res = violenceMatch("lcxllv", "lv");
        System.out.println(res);
    }

    /**
     * 暴力匹配算法实现
     *
     * @param str1 待匹配的字符串
     * @param str2 目标字符串
     * @return
     */
    public static int violenceMatch(String str1, String str2) {
        int str1L = str1.length();
        int str2L = str2.length();
        int i = 0;
        int j = 0;
        while (i < str1L && j < str2L) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            } //end if...else
        } //end while
        if (j == str2L) {
            return i - j;
        } else {
            return -1;
        } //end if...else
    } //end violenceMatch()
}
