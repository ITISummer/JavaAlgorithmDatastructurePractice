package practice.luogu.数组;

import java.util.Scanner;

/**
 * 【https://www.luogu.com.cn/problem/P1047】
 */
public class P1047校门外的树 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int L = input.nextInt();//L 代表马路长度
        int M = input.nextInt();//M 代表区域个数

        int[] road = new int[L+1]; //初始化马路，默认值都为0，规定 0-表示没有被占领 1-表示被占领
//        System.out.println(Arrays.toString(road));
        int result = 0; //用于统计结果数
        //循环输入
        int start = 0,end = 0;
        for (int i = 0; i < M; i++) {
            start = input.nextInt();
            end = input.nextInt();
            //从 start 开始，到 end 结束，为 road 赋值
            for (;start <= end; start ++) {
                road[start] = 1; //标记为 1 表示被占领
            }
        } //end for

        // 统计结果
        for (int i = 0; i < road.length; i++) {
            if (road[i] == 0) {
                result ++;
            } //end if
        } //end for
        System.out.println(result);
    } //end main()
}
