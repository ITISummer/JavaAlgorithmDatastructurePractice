package datastructure.primenumber;

/**
 * 质数输出的三种方式
 * 只能被1和它本身整除的自然数
 * 2是最小的质数
 */
public class PrimeNumber {
    public static void main(String[] args) {
        printPrime2();
    }//end main()

    /**
     * 输出100以内质数
     * 方法一：使用i来除以[2,i-1)的数，如果都不能整除，则说明i是质数
     * 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
     */
    public static void printPrime1() {
        boolean isPrime = true;
        int i = 0;
        for (i = 2; i <= 100; i++) {
            isPrime = true;
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            } //end for
            if (isPrime) {
                System.out.print(i+" ");
            }
        } //end for
    } //end printPrime()


    /**
     * 优化2：根据一个数的因子配对的数学现象得出只需要考虑[2,Math.sqrt(i)]范围内就行
     */
    public static void printPrime2() {
        boolean isPrime = true;
        int i = 0;
        for (i = 2; i <= 100; i++) {
            isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            } //end for
            if (isPrime) {
                System.out.print(i+" ");
            }
        } //end for
    } //end printPrime()

}
