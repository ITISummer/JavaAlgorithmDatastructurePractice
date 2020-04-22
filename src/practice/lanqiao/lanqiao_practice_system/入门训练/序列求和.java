package practice.lanqiao.lanqiao_practice_system.入门训练;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T2
 * 问题描述
 * 求1+2+3+...+n的值。
 */
public class 序列求和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger bigN = new BigInteger(n+"");
        System.out.println((BigInteger.ONE.add(bigN).multiply(bigN).divide(new BigInteger("2"))));
        in.close();
    }
}
