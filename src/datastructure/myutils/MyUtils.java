package datastructure.myutils;

/**
 * 此类是我的自定义工具类
 * 适用于一些常用功能操作
 * 例如：对二维数组的输出等
 */
public class MyUtils {
    /**
     * 输出二维数组
     * @param array
     */
    public static void printDoubleDimArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            } //end for
            System.out.println();
        } //end for
    } //end printDoubleDimArray()

    /**
     * 输出一维数组
     * @param array
     */
    public static void printOneDimArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+" ");
        }
    } //end printOneDimArray()
}
