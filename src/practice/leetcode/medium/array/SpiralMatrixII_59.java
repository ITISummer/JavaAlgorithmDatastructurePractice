package practice.leetcode.medium.array;

/**
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        int loop = 0;
        int[][] res = new int[n][n];
        int start = 0; // 定义开始填充的点(start,start)
        int count = 1; // 定义填充的数字
        int row,col; // 行，列
        while (loop++ < n/2) {
            // 模拟上侧从左到右（遵循左闭右开原则）
            for(col = start; col<n-loop; col++) {
                res[start][col] = count++;
            }
            // 模拟右侧从上到下（遵循上闭下开原则）
            for(row = start; row<n-loop; row++) {
                res[row][col] = count++;
            }
            // 模拟下侧从右到左（遵循右闭左开原则）
            for(; col>=loop; col--) {
                res[row][col] = count++;
            }
            // 模拟下侧从下到上（遵循下闭上开原则）
            for(; row>=loop; row--) {
                res[row][col] = count++;
            }
            start++;
        }
        // 处理最后一个节点
        if(n%2==1) {
            res[start][start] = count;
        }
        return res;
    }

    /**
     * https://leetcode.cn/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
     * @param n
     * @return
     */
    public int[][] generateMatrix_2(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] res = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = left; i <= right; i++) res[top][i] = num++; // left to right.
            top++;
            for(int i = top; i <= bottom; i++) res[i][right] = num++; // top to bottom.
            right--;
            for(int i = right; i >= left; i--) res[bottom][i] = num++; // right to left.
            bottom--;
            for(int i = bottom; i >= top; i--) res[i][left] = num++; // bottom to top.
            left++;
        }
        return res;
    }
}
