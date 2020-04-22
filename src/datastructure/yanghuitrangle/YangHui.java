package datastructure.yanghuitrangle;

import datastructure.myutils.MyUtils;

/**
 * 杨辉三角
 * 每一行的第一个数和最后一个数为1
 * 除了每一行的第一个数和最后一个数以外，其他数都是满足a[i][j] = a[i-1][j]+a[i-1][j-1]
 */
public class YangHui {
    public static void main(String[] args) {
        yangHui(10);
    }

    /**
     * 输出杨辉三角
     * 传入杨辉三角行数
     */
    public static void yangHui(int cow) {
        //声明一个二维数组
        int[][] yangHui = new int[cow][];

        //初始化杨辉三角-动态初始化每一行
        for (int i = 0; i < yangHui.length; i++) {
            yangHui[i] = new int[i+1];

            //给首末元素赋值
            yangHui[i][0] = 1;
            yangHui[i][i] = 1;

            //给每行非首末元素赋值
            if (i>1) {
                for (int j = 1; j < yangHui[i].length-1; j++) {
                    yangHui[i][j] = yangHui[i-1][j] + yangHui[i-1][j-1];
                } //end for
            } //end if
        } //end for
        //打印杨辉三角
        MyUtils.printDoubleDimArray(yangHui);

    } //end yangHui()
}
