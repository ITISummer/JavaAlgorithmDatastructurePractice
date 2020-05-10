package practice.lanqiao.javaB2014;

import java.util.Scanner;

/*
标题：分糖果有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，
然后进行下面的游戏
每个小朋友都把自己的糖果分一半给左手边的孩子。
一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。
反复进行这个游戏，直到所有小朋友的糖果数都相同为止。
你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
【格式要求】
程序首先读入一个整数N（2<N<100），表示小朋友的人数
接着是一行用空格分开的N个偶数（每个偶数不大于1000，不小于2）
要求程序输出一个整数，表示老师需要补发的糖果数
例如：
输入
3
2 2 4
程序应该输出：
4
 */
public class _08_分糖果 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.close();
        int ans = 0;
        while (true) {
            int t = a[0];
            for (int i = 0; i < n - 1; i++) {
                a[i] -= (a[i] / 2);
                a[i] += (a[i + 1] / 2);
                if ((a[i] & 1) == 1) {
                    ans++;
                    a[i]++;
                }
            }
            a[n - 1] -= (a[n - 1] / 2);
            a[n - 1] += (t / 2);
            //judge if the number is odd number
            if ((a[n - 1] & 1) == 1) {
                ans++;
                a[n - 1]++;
            }
            if (check(a)) {
                System.out.println(ans);
                return;
            }
        } //end while
    }

    /**
     * check if the number in the array are not similar
     *
     * @param a
     * @return
     */
    private static boolean check(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != a[i + 1]) return false;
        }
        return true;
    }
}
