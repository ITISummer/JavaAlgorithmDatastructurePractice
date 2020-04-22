package datastructure.myutils;

import javax.sound.midi.MidiChannel;

/**
 * 自定义Arrays工具类
 */
public class MyArrays {

    /**
     * 得到数组的最大值
     *
     * @param arr
     */
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 得到数组的最小值
     *
     * @param arr
     */
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * 得到数组的和
     *
     * @param arr
     */
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }


    /**
     * 得到数组的平均值
     *
     * @param arr
     */
    public static int getAvg(int[] arr) {
        return getSum(arr) / arr.length;
    }

    /**
     * 反转数组
     *
     * @param arr
     */
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i] - arr[arr.length - 1 - i];
            arr[i] = arr[i] - arr[arr.length - 1 - i];
        }
    }

    /**
     * 赋值数组
     *
     * @param arr
     * @param length 赋值的长度
     */
    public static int[] copy(int[] arr, int length) {
        int[] newArr = new int[length];
        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    /**
     * 数组排序
     * 快速排序
     *
     * @param arr
     */
    public static void sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int i, j, temp;
        temp = arr[left];//temp中存的就是基准数
        i = left;
        j = right;
        while (i != j) {
            //顺序很重要，先从右往左找
            while (arr[j] >= temp && i < j) {
                j--;
            }
            //再从左往右找
            while (arr[i] <= temp && i < j) {
                i++;
            }
            //交换两个数在数组中的位置
            if (i < j) { //当i与j没有相遇
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        } //end while

//        最终将基准数归位
        arr[left] = arr[i];
        arr[i] = temp;

        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }

    /**
     * 输出数组
     *
     * @param arr
     */
    public static void print(int[] arr) {
        MyUtils.printOneDimArray(arr);
    }

    /**
     * 查找指定元素
     *
     * @param arr
     */
    public static int getIndex(int[] arr, int value) {
        int[] newArr = copy(arr, arr.length);
        sort(newArr, 0, newArr.length - 1);
        int low = 0;
        int high = newArr.length - 1;
        int mid = (low + high) >> 1;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (newArr[mid] > value) {
                high = mid - 1;
            } else if (newArr[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            } //end if...else
        } //end while

        return -1;
    }


}
