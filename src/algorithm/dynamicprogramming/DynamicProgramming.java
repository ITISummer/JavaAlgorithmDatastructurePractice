package algorithm.dynamicprogramming;

/**
 * @ClassName dynamicprogramming
 * @Author LCX
 * @Date 2021 2021-06-21 7:10 p.m.
 * @Version 1.0
 **/
public class DynamicProgramming {
    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        System.out.println(dp.getMax());

    }

    // 7
// 3 8
// 8 1 0
// 2 7 4 4
// 4 5 2 6 5
//从上到下选择一条路，使得经过的数字之和最大。
//路径上的每一步只能往下或者右下走。
    public int getMax() {
        int MAX = 10;
        // 存储数字三角形
        int[][] D = new int[MAX][MAX];
        D[0][0] = 7;

        D[1][0] = 3;
        D[1][1] = 8;

        D[2][0] = 8;
        D[2][1] = 1;
        D[2][2] = 0;

        D[3][0] = 2;
        D[3][1] = 7;
        D[3][2] = 4;
        D[3][3] = 4;

        D[4][0] = 4;
        D[4][1] = 5;
        D[4][2] = 2;
        D[4][3] = 6;
        D[4][4] = 5;
        // n表示层数
        int n = 4;
        int i = 0;
        int j = 0;
        int maxSum = getMaxSum(D, n, i, j);
        return maxSum;
    }

    public int getMaxSum(int[][] D, int n, int i, int j) {
        if (i == n) {
            return D[i][j];
        }
        int x = getMaxSum(D, n, i + 1, j); // 向下
        int y = getMaxSum(D, n, i + 1, j + 1); // 向右下
        return Math.max(x, y) + D[i][j];
    }
}
