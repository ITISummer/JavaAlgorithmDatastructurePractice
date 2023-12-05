package practice.leetcode.数组;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColumnNumber_171 {
    public static int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int idx = 0;
        int res = 0;
        for (int i = len-1; i >= 0; i--) {
            res += (columnTitle.charAt(i)-65 + 1) * Math.pow(26,idx++);
        }
        return res;
    }

    public static void main(String[] args) {
        titleToNumber("A");
    }
}
