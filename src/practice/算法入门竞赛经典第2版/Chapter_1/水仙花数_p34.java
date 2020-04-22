package practice.算法入门竞赛经典第2版.Chapter_1;

/**
 * 水仙花数
 * 100~999 中的所有水仙花数
 * 判断三位数 (ABC) 是否满足 ABC = A3 + B3 + C3
 */
public class 水仙花数_p34 {

    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            if (isDaffodil(i)) {
                System.out.println(i);
            } //end if
        } //end for
    }

    /**
     * 返回一个整数的各位数
     * @param num
     */
    public static boolean isDaffodil(int num) {
        int temp = num;
        int sum = 0;
        while (temp > 0) {
            sum += (Math.pow((temp % 10),3));
            temp /= 10;
        } //end while
        if (sum == num) {
            return true;
        }
        return false;
    } //end getDigital()
}

