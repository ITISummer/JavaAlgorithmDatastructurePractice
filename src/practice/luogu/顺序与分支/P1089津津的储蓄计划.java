package practice.luogu.顺序与分支;

import java.util.Scanner;

/**
 * [https://www.luogu.com.cn/problem/P1089]
 * 测试一：
 290
 230
 280
 200
 300
 170
 340
 50
 90
 80
 00
 60
 测试二：
 290
 230
 280
 200
 300
 170
 330
 50
 90
 80
 200
 60
 */
public class P1089津津的储蓄计划 {
    public static void main(String[] args) {
        //代表这个月手中的钱
        int moneyInHands = 0;
        //代表这个月的花费
        int cost = 0;
        //表示在妈妈手中的整百数量
        int amount = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= 12; i ++) {
            moneyInHands += 300; //首先每个月收入 300
            cost = input.nextInt();
            moneyInHands -= cost;
            //判断 moneyOfRemain 是否小于0
            if (moneyInHands < 0) {
                System.out.println("-"+i);
                return ;
            } else {
                //在妈妈那里可以存储的整百的数量
                amount += moneyInHands / 100;
                //存储整百的数量后，还在手中的钱
                moneyInHands %= 100;
            } //end if...else
        } //end for

        //结束循环，输出年末的钱
        System.out.println(moneyInHands+amount*120);
        input.close();
    } //end main()
}
