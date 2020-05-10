package practice.lanqiao.javaB2014;

import java.util.Scanner;

/*
example:
input     output
12 -16 -> -4 -4 -4
12 16 -> 4 4 4
-12 -16 -> -4 -4 -4
0 12 -> 12 12 12
12 0 -> 12 12 12
 */
public class Gcd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(gcdByRecursion(a, b));
        System.out.println(gcdByLoop_1(a, b));
        System.out.println(gcdByLoop_2(a, b));
        in.close();
    }

    /**
     * get the greatest common divisor by loop
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcdByLoop_1(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }
        int gcd = Math.min(a, b);
        while (gcd != 0) {
            if (a % gcd == 0 && b % gcd == 0) {
                break;
            }
            if (gcd > 0) {
                gcd--;
            } else {
                gcd++;
            }
        }
        return gcd;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static int gcdByLoop_2(int a, int b) {
        int r = 1;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    /**
     * get the greatest common divisor by recursion
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcdByRecursion(int a, int b) {
        if (b == 0) return a;
        return gcdByRecursion(b, a % b);
    }

}
