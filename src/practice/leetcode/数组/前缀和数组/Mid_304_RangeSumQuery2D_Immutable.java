package practice.leetcode.数组.前缀和数组;

/**
 * @author SummerLv
 * @version 2023/11/27 20:44
 * https://leetcode.cn/problems/range-sum-query-2d-immutable/description/
 */
public class Mid_304_RangeSumQuery2D_Immutable {
    // 构造二维前缀和数组: preSum[i][j] 记录 matrix 中子矩阵 [0,0,i-1,j-1] 的元素和
    private int[][] preSum;
    public Mid_304_RangeSumQuery2D_Immutable(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m==0 || n==0) return;
        // 构造前缀和矩阵
        preSum = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0,0,i,j] 的元素和
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1];
    }
}
