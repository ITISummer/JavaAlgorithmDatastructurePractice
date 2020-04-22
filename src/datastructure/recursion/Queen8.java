package datastructure.recursion;

/**
 * 八皇后问题
 */
public class Queen8 {
    //定义max表示多少个皇后,同时也表示列数
    int max = 8;
    //定义数组array，表示皇后放置的位置的结果
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.place(0);
        System.out.println("一共有"+count+"次解法！");
    }//end main()

    /**
     * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 表示第几个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //判断是否在同一列或者同一斜线，同一斜线判断方法：两个皇后的坐标行列差的绝对值相等则表示在同一斜线
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        } //end for
        return true;
    } //end judee()

    /**
     * 编写一个方法，放置第n个皇后
     */
    private void place(int n) {
        if (n==max) {
            print();
            return ;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if(judge(n)) { //不冲突
                //接着放n+1个皇后，即开始递归
                place(n+1);
            }
            //如果冲突，就继续执行array[n] = i;即将第n个皇后，放置在本行的后一个位置
        } //end for
    } //end check()

    /**
     * 输出皇后摆放的位置
     */
    private void print() {
        count ++;
        for (int i : array) {
            System.out.print(i);
        } //end for
        System.out.println();
    } //end printPos()
}
