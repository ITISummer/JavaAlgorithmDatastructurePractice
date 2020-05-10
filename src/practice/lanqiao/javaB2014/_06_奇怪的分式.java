package practice.lanqiao.javaB2014;

/*
1/4乘以8/5小明居然把分子拼接在一起，分母拼接在一起，答案是：18/45（参见图1.png）
老师刚想批评他，转念一想，这个答案凑巧也对啊，真是见鬼！
对于分子、分母都是1~9中的一位数的情况，还有哪些算式可以这样计算呢？
请写出所有不同算式的个数（包括题中举例的）。
显然，交换分子分母后，例如：4/1乘以5/8是满足要求的，这算做不同的算式。
但对于分子分母相同的情况，
2/2乘以3/3这样的类型太多了，不在计数之列
注意：答案是个整数（考虑对称性，肯定是偶数）。
请通过浏览器提交。不要书写多余的內容。
 */
public class _06_奇怪的分式 {
    public static void main(String[] args) {
        int ans = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                if (a != b) {
                    for (int c = 1; c <= 9; c++) {
                        for (int d = 1; d <= 9; d++) {
                            if (c != d) {
                                int gcd1 = gcd(a * c, b * d);
                                int gcd2 = gcd(a * 10 + c, b * 10 + d);
                                if ((a * c) / gcd1 == (a * 10 + c) / gcd2 && (b * d) / gcd1 == (b * 10 + d) / gcd2) {
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    /**
     * calculate the greatest common divisor
     * division algorithm
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
