package algorithm.divideandconquer;

/**
 * 利用 分治法 来实现 汉诺塔
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(2,'A','B','C');

    }

    /**
     *
     * @param num 表示盘的数量
     * @param a
     * @param b
     * @param c
     */
    public static void hanoitower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从 "+a+"->"+c);
        } else {
            //盘的数量大于 2 的情况，将情况都看成是两个盘：1. 最下面的一个盘 2. 除了最下面的一个盘的所有盘
            //1. 先递归把除了最下面盘的上面的所有盘 从 a 移动到 b
            hanoitower(num - 1,a,c,b);
            //2. 把最下面的一个盘 从 a 移动到 c
            System.out.println("第"+ num +"个盘从 "+a+"->"+c);
            //3. 把 b 上面的盘从 b->c
            hanoitower(num - 1,b,a,c);
        }
    } //end hanoitower()
}
