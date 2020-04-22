package algorithm.dynamic;

import java.util.Arrays;

/**
 * 使用动态规划算法来解决 01 背包问题（一个背包只能装一件同种商品）
 * 全背包问题（一个背包可以装任意件同种商品
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        //物品的重量
        int[] weight = {1,4,3};
        //物品的价值
        int[] value = {1500,3000,2000};
        //背包的容量-所能承受的重量
        int capa = 4;
        //物品的个数
        int n = value.length;

        //创建二维数组 - 行-物品的个数，列-背包容量
        //v[i][j] 表示在前 i 个物品中能够装入容量为 j 的背包的最大价值
        int[][] v = new int[n+1][capa+1];
        int[][] path = new int[n+1][capa+1];


        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0; //设置第一列为 0
            for (int j = 0; j < v[i].length; j++) {
                v[0][j] = 0; //设置第一行为 0
            } //end for
        } //end for

        //根据公式来动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                //公式
                if (weight[i-1] > j) {
                    v[i][j] = v[i-1][j];
                } else {
//                    v[i][j] = Math.max(v[i-1][j],value[i-1]+v[i-1][j-weight[i-1]]);
                    if (v[i-1][j] < value[i-1]+v[i-1][j-weight[i-1]]) {
                        v[i][j] = value[i-1]+v[i-1][j-weight[i-1]];
                        //记录当前情况到 path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i-1][j];
                    } //end if...else
                } //end if...else
            } //end for
        } //end for

        //打印整个列表
        for (int[] ints : v) {
            System.out.println(Arrays.toString(ints));
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包！\n",i);
                j -= weight[i-1];
            }
            i--;
        } //end while

    } //end main()


}
