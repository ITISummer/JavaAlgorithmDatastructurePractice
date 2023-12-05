package datastructure.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 顺序查找
 */
public class Search {
    public static void main(String[] args) {
//        int[] arr = {1,9,11,-1,34,89};
//        System.out.println(seqSearch(arr,11));
//        int[] arr = {3,14,53,214,542,748};
//        System.out.println(binarySearch(arr,0,arr.length-1,3));
//        int[] arr = {1,1,1,2,3,4};
//        System.out.println(binarySearch2(arr,0,arr.length-1,1));
//        int[] arr = {1, 1, 1, 2, 3, 4};
//        System.out.println(binarySearchRec(arr, 0, arr.length - 1, 0));
//        int[] arr = {1, 1, 1, 2, 3, 4};
//        System.out.println(binarySearchRec2(arr, 0, arr.length - 1, 1));
//        int[] arr = {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 0));
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println(fibonacciSearch(arr, 10));
    }//end main()


    /**
     * 斐波那契数列查询法
     * 非递归方法
     * @param arr
     * @return
     */
    public static int fibonacciSearch(int[] arr,int key) {
        //mid = low+F(k-1)-1;
        int fibSize = 20;
        int low = 0;
        int high = arr.length-1;
        int k = 0;//表示斐波那契数列分割数值的下标
        int mid = 0; //存放mid的值
        int[] fib = getFib(fibSize); //获取到斐波那契数列
        //获取到斐波那契数列分割数值的下标
        while (high > fib[k] - 1) {
            k++;
        }
        //因为fib[k]值可能大于arr的长度,因此使用Arrays类，构造一个新的数组，并指向arr
        //不足的部分会使用0填充
        //temp->{1,8,10,89,1000,1234,0,0} -> {1,8,10,89,1000,1234,1234,1234}
        int[] temp = Arrays.copyOf(arr,fib[k]);
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //使用while循环来找到key
        while (low<=high) {
            mid = low+fib[k-1] - 1;
            if (key<temp[mid]) {
                //继续向数组左边查找
                high = mid - 1;
                //
                k--;
            } else if (key>temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            } //end if...else
        } //end while
        return -1;
    } //end fibonacciSearch()
    /**
     * 使用非递归方法获取一个斐波那契数列
     * @return
     */
    public static int[] getFib(int fibSize) {
        int[] f = new int[fibSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i-1] + f[i-2];
        } //end for
        return f;
    } //end getFib()
    /**
     * 二分查找
     * 问题一：
     * 给定一个有序的数组，查找value是否在数组中，不存在返回-1。
     * 注意此二叉搜索把判断相等放到最后，因为毕竟不相等的次数是比相等的次数多的
     * 所以每次不要判断是否相等，这样会减少程序运行的比较次数
     *
     * @param arr
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            //防止溢出，移位也更高效。同时，每次循环都需要更新。
            // int mid = left + ((right - left) >> 1);
            // int mid = (left+right) >> 1;
            if (value < arr[mid]) {
                right = mid - 1;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            } //end if...else
        } //end while
        return -1;
    } //end binarySearch()

    /**
     * 递归二叉查询
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int binarySearchRec(int[] arr, int left, int right, int value) {
        if (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > value) {
                return binarySearchRec(arr, left, mid - 1, value);
            } else if (arr[mid] < value) {
                return binarySearchRec(arr, mid + 1, right, value);
            } else {
                return mid;
            } //end if...else
        } //end if
        return -1;
    } //end binarySearchRec()

    /**
     * 插值查找
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int value) {
        //这里的条件必须加，负责可能越界
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        //寻找合适位置
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (value > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    } //end insertValueSearch()

    /**
     * 将多个相同值全部返回
     *
     * @param arr
     * @param left
     * @param right
     * @param value 1. 找到mid值不要马上返回
     *              2. 向mid左边扫描，将满足条件的下标值加入到ArrayList中
     *              3. 向mid右边扫描，将满足条件的下标值加入到ArrayList中
     *              4. 将ArrayList返回
     * @return
     */
    public static List binarySearchRec2(int[] arr, int left, int right, int value) {
        if (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > value) {
                return binarySearchRec2(arr, left, mid - 1, value);
            } else if (arr[mid] < value) {
                return binarySearchRec2(arr, mid + 1, right, value);
            } else {
                //2. 向mid左边扫描，将满足条件的下标值加入到ArrayList中
                List<Integer> resIndexList = new ArrayList<>();
                int temp = mid - 1;
                while (true) {
                    if (temp < 0 || arr[temp] != value) {
                        break;
                    }
                    resIndexList.add(temp);
                    temp -= 1;
                } //end while
                resIndexList.add(mid);

                //3. 向mid右边扫描，将满足条件的下标值加入到ArrayList中
                temp = mid + 1;
                while (true) {
                    if (temp > arr.length - 1 || arr[temp] != value) {
                        break;
                    }
                    resIndexList.add(temp);
                    temp += 1;
                } //end while
                return resIndexList;
            } //end if...else
        } //end if
        return new ArrayList<Integer>();
    } //end binarySearchRec2()

    /**
     * 二分查找
     * 问题二：
     * 给定一个有序的数组，查找arr中等于value的最小下标
     * 如果问题改为查找value最后一次出现的下标呢？只需改动两个位置：
     * 1.if (数组[middle] >= value)中的等号去掉；
     * 2.return中right+1改为left-1。
     *
     * @param arr
     */
    public static int binarySearch2(int[] arr, int left, int right, int value) {
        int mid = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= value)  //因为是找到最小的等值下标，所以等于号放在这里
                right = mid - 1;
            else
                left = mid + 1;
        } //end while
        return arr[right + 1] == value ? right + 1 : -1;
    } //end binarySearch()

    /**
     * 给定一个有序的数组，查找最接近value且大于value的数的下标（
     * 如果该数存在多个，返回第一个下标），不存在返回-1。
     * <p>
     * 如果问题改为查找最接近value且小于value的数的下标
     * （如果该数存在多个，返回最后一个下标）呢？只需改动两个位置：
     * 1.if (数组[middle] > value)加入一个等号；
     * 2.return 数组[right + 1] > value ? right + 1 : -1;
     * 改为return 数组[left-1] < value ? left - 1 : -1;。
     *
     * @param array
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int binarySearch3(int array[], int left, int right, int value) {
        int mid = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (array[mid] > value)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return array[right + 1] > value ? right + 1 : -1;
    } //end binarySearch3()

    /**
     * 找到一个满足条件的值就返回
     *
     * @param arr
     * @param value
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    } //end seqSearch()
}
