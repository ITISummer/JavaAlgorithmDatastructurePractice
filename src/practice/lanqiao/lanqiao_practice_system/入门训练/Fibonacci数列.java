package practice.lanqiao.lanqiao_practice_system.入门训练;

/*
 * [题]http://lx.lanqiao.cn/problem.page?gpid=T4###
 * passed
 */
public class Fibonacci数列 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        System.out.println(recurrence(n));
//        in.close();
        System.out.println(fibMod(10, 10007));

    }

    /**
     * recursion
     *
     * @param n
     * @return
     */
    public static int recursion(int n) {
        if (n <= 2) {
            return 1;
        }
        return (recursion(n - 1) + recursion(n - 2)) % 10007;
    }

    /**
     * right answer
     *
     * @param n
     * @return
     */
    public static int recurrence(int n) {
        int f1 = 1;
        int f2 = 1;
        int temp = f1;
        for (int i = 1; i <= n - 2; i++) {
//            f1 %= 10007;
//            f2 %= 10007;
            temp = (f1 + f2) % 10007;
            f1 = f2;
            f2 = temp;
        }
        return temp;
    }

    /**
     * has a problem
     * can not get a correct result
     *
     * @param n
     * @return
     */
    @Deprecated
    public static int recurrenceHasProblem(int n) {
        int f1 = 1;
        int f2 = 1;
        int temp = f1;
        for (int i = 1; i <= n - 2; i++) {
            f1 %= 10007;
            f2 %= 10007;
            temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        return temp;
    }

    /**
     * the solution below my question "modular arithmetic problems" on Stackoverflow.
     * https://stackoverflow.com/questions/61228886/modular-arithmetic-problems/61229351#61229351
     *
     * @param n
     * @param mod
     * @return
     */
    static int fibMod(int n, int mod) {
        if (n < 0 || mod < 2)
            throw new IllegalArgumentException();
        if (n <= 1)
            return n;
        int prev = 1, fib = 1;
        for (int i = 3; i <= n; i++)
            fib = (prev + (prev = fib)) % mod;
        return fib;
    }

}

