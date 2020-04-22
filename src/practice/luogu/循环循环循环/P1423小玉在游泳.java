package practice.luogu.循环循环循环;

import java.util.Scanner;

/**
 * [https://www.luogu.com.cn/problem/P1423]
 */
public class P1423小玉在游泳 {
    public static void main(String[] args) {
        double distance = new Scanner(System.in).nextDouble();
        int step = 1;
        double current = 2.0; //表示当前行进距离
        double currentAll = 0.0; //记录当前行进的总距离
        int result = fun(step,current,currentAll,distance);
        System.out.println(result);


//        System.out.println((int)Math.ceil(Math.log(1-distance/100)/Math.log(0.98)));

    }


    /**
     *
     * @param step 记录走的步数
     * @param current 表示当前的距离
     * @param distance 表示要走的距离
     * @return
     */
    private static int fun(int step,double current,double currentAll,double distance) {
        currentAll += current;
        if (currentAll >= distance) {
            return step;
        }
        current *= 0.98;
        step ++;
        return fun(step,current,currentAll,distance);
    } //end fun()
}
