package practice.leetcode.easy;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle_168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber --;
            res.append((char)(columnNumber%26+65));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}
