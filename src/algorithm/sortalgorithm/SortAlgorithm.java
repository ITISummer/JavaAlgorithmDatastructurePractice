package algorithm.sortalgorithm;

import java.util.Arrays;

/**
 * 排序算法
 * 测试用例：
 * 1. [1,2,3,4,5]
 * 2. [3,9,1,10,20]
 * 3. [8,3,2,1,7,4,6,5]
 * 4. [101,34,119,1,-1,89]
 * 5. [8,9,1,7,2,3,5,4,6,0]
 * 6. [53,3,542,748,14,214]
 * 整数交换的三种方法
 * A = A + B
 * B = A - B
 * A = A - B
 * -------------
 * A = A ^ B
 * B = A ^ B
 * A = A ^ B
 * -------------
 * temp = A
 * A = B
 * B = temp
 */
public class SortAlgorithm {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,8};
//        int[] arr = {3,9,1,10,20};
//        int[] arr = {8, 3, 2, 1, 7, 4, 6, 5};
//        int[] arr = {101, 34, 119, 1, -1, 89};
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = {53, 3, 542, 748, 14, 214};
//        int[] arr = {-9, 78, 0, 23, -567, 70};
//        bubbleSort_1(arr);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        shellSort_1(arr);
//        quickSort(arr, 0, arr.length - 1);
//        int[] temp = new int[arr.length];
//        mergeSort(arr,0,arr.length-1,temp);

//        radixSort(arr);
//        System.out.println(getDigit(748,4));
//        int[] arr = {4, 6, 8, 5, 9};
//        heapSort(arr);
        printArr(arr);
    }

    /**
     * 原始版
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * [冒泡排序](https://www.runoob.com/w3cnote/bubble-sort.html)
     * O(n2) 稳定排序
     * 【参考博文：】[https://blog.csdn.net/kybd2006/article/details/3727218]
     * 位运算：
     * 1.参与运算的两个值，如果两个相应位相同，则结果为0，否则为1。
     * 即：0^0=0， 1^0=1， 0^1=1， 1^1=0
     * 2. 异或运算符的特点是：数a两次异或同一个数b（a=a^b^b）仍然为原值a.
     */
    public static void bubbleSort_1(int[] arr) {
        boolean isContinue = true;
        for (int i = 0; i < arr.length - 1; i++) {
            isContinue = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    isContinue = true;
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
            if (!isContinue) { //在一趟交换中一次都没有发生，说明在中途已经排好序，则不必再往下执行
                System.out.println("比较了" + (i + 1) + "趟");
                break;
            }
        }
    }

    /**
     * [选择排序](https://www.runoob.com/w3cnote/selection-sort.html)
     * O(n2) 不稳定排序
     */
    public static void selectSort(int[] arr) {
        int j = 0, min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i; // k 设置指定到最小的元素位置
            j = i + 1; // j 做移动
            while (j < arr.length) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                j++;
            }
            if (min != i) {
                arr[i] = arr[i] + arr[min];
                arr[min] = arr[i] - arr[min];
                arr[i] = arr[i] - arr[min];
            }
        }
    }

    /**
     * 插入排序
     * O(n2) 稳定排序
     */
    public static void insertSort(int[] arr) {
        int k;
        int temp;
        for (int i = 1; i < arr.length; i++) {
            k = i;
            temp = arr[k];
            while (k > 0 && temp < arr[k - 1]) {
                arr[k] = arr[k - 1];
                k--;
            }
            if (k != i) {
                arr[k] = temp;
            }
        }
    }

    /**
     * 【参考博文：】[https://www.cnblogs.com/chengxiao/p/6104371.html]
     * 希尔排序-特殊的插入排序-采用交换法
     * 采用缩小增量的方式
     * O(nlogn) 不稳定
     * 变化过程：
     * [8,9,1,7,2,3,5,4,6,0]
     * [3,5,1,6,0,8,9,4,7,2]
     * [0,2,1,4,3,5,7,6,9,8]
     * [0,1,2,3,4,5,6,7,8,9]
     * 希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。
     * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，
     * 也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一
     */
    public static void shellSort(int[] arr) {
        for (int step = arr.length / 2; step >= 1; step /= 2) {
            // 插入排序从前往后排
            for (int i = step; i < arr.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        arr[j] = arr[j] + arr[j + step];
                        arr[j + step] = arr[j] - arr[j + step];
                        arr[j] = arr[j] - arr[j + step];
                    }
                }
            }
        }
    }

    /**
     * 希尔排序-对交换式的排序进行优化-采用移动法
     * 将插入排序和希尔缩小增量进行结合的排序算法
     */
    public static void shellSort_1(int[] arr) {
        //增量 step,并逐步缩小增量
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //从第 step 个元素，逐个对其所在的组进行直接插入排序
            int i, j, temp;
            for (i = step; i < arr.length; i++) {
                j = i;
                temp = arr[j];
                while (j - step >= 0 && temp < arr[j - step]) {
                    //移动
                    arr[j] = arr[j - step];
                    j -= step;
                }
                //当退出while循环后，就给temp找到插入的位置
                if (j != i) {
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 归并排序
     * 分解 + 合并
     * O(nlogn)-稳定
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //--------------------------分解数组----------------------------
        if (left < right) {
            //向左递归
            mergeSort(arr, left, (left + right) / 2, temp);
            //向右递归
            mergeSort(arr, (left + right) / 2 + 1, right, temp);
            //合并
            merge(arr, left, (left + right) / 2, right, temp);
        }
    }

    /**
     * 合并
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //左边有序序列的初始索引
        int j = mid + 1; //右边有序序列的初始索引
        int t = 0; //指向temp数组当前索引
        //--------------------------拷贝数组到temp----------------------------
        //拷贝左右两边有序序列到temp中
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //把有剩余的一方的数组中元素直接拷贝到temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //--------------------------将数组temp拷贝到arr----------------------------
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    /**
     * 快速排序算法-采用递归思想
     * O(nlogn) 不稳定
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        while (l < r) {
            //在左边找大于等于pivot的数
            while (arr[l] < pivot) {
                l += 1;
            }
            //在右边找小于pivot的数
            while (arr[r] > pivot) {
                r -= 1;
            }
            //每找完一次需要判断，如果判断结果为true，则说明满足了pivot左边小右边大的情况
            if (l >= r) {
                break;
            }
            //交换值
            arr[l] = arr[l] + arr[r];
            arr[r] = arr[l] - arr[r];
            arr[l] = arr[l] - arr[r];

            //防止死循环
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        // 放置栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }


    /**
     * 基数排序（类桶排序）
     * O(n*k)-稳定
     */
    public static void radixSort(int[] arr) {
        //声明一个二维数组作为桶
        int[][] bucket = new int[10][arr.length];
        //用于记录当前取arr中各元素第几位，默认从个位（第一位）开始取
        int count = 0;
        //先找到arr中的最大数并得到该数的位数，max 的长度表示要循环的次数
        int max = getMax(arr);
        //取数组中的位数
        int len = ("" + max).length();
        for (int i = 0; i < len; i++) {
            //声明一个一维数组用于记录每个桶中有效个数
            int[] bucketLen = new int[10];
            count++;
            int digit = 0; //用于记录arr当前元素的位数
            //开始取arr中的各个元素的位数，存入bucket中
            for (int j = 0; j < arr.length; j++) {
                // 取第 count 位
                digit = getDigit(arr[j], count);
                //对bucket中每一行中有效个数进行实时统计
                bucket[digit][bucketLen[digit]++] = arr[j];
            }
            //再从桶bucket中取出第一次排序的元素放入到arr中
            resetArr(arr, bucket, bucketLen);
        }

    }

    /**
     * @param arr       待排序数组
     * @param bucket    中间二维数组
     * @param bucketLen 记录二维数组有效个数的中间数组
     */
    private static void resetArr(int[] arr, int[][] bucket, int[] bucketLen) {
        int index = 0;
        for (int k = 0; k < bucket.length; k++) {
            if (bucketLen[k] != 0) {
                for (int m = 0; m < bucketLen[k]; m++) {
                    arr[index++] = bucket[k][m];
                }
            }
            //需要将bucketLen中数量重新置0
            bucketLen[k] = 0;
        }
    }

    /**
     * 返回arr中的最大元素
     */
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 根据pla位置获取ele的位数
     *
     * @param pla 个位，十位。。。
     */
    private static int getDigit(int ele, int pla) {
        int temp = -1;
        for (int i = 0; i < pla; i++) {
            temp = ele % 10;
            ele /= 10;
        }
        return temp;
    }

    /**
     * 堆排序-利用二叉树的性质
     * 大顶堆-节点的值比左右子节点的值大，但是左右子节点的值没有顺序
     * 小顶堆-节点的值比左右子节点的值小，但是左右子节点的值没有顺序
     * <p>
     * 一切操作都是以数组来为基础，不会用到树，只是在操作时将操作给抽象化成对树的操作
     * <p>
     * 升序排序表示是对大顶堆操作
     * 降序排序表示是对小顶堆操作
     * <p>
     * 堆排序主要注意两点
     * 1. 将子树调节为大（小）顶堆
     * 2. 将整个树的根节点与最后一个节点进行交换
     * 3. 循环1 2 操作
     */
    public static void heapSort(int[] arr) {
//        System.out.println("第一次调整后：");
//        adjustHeap(arr,1,arr.length);
        int temp = 0;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    /**
     * //将一个数组（二又树），调整成一个大顶堆功能：完成将以主对应的非叶子结点的树调整成大顶堆
     * 举例 int arr[]={4,6,8,5,9}=)i=1=) adjustHeap=)得到{4,9,8,5,6}
     * 如果我们再次调用 adjustHeap传入的是主=0=>得到{4,9,8,5,6}=){9,6,8,5,4
     * 注意此调整是以【从左至右，从下至上】顺序来调整的
     * 测试样例：[4,6,8,5,9]
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整，length是在逐渐的减少
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        //先保存arr[i]的值
        int temp = arr[i];
        //循环建大顶堆 k 表示当前节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //取父节点和左右子节点的值的最大值来替换为父节点
            //比较左子节点与右子节点的值，取最大值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//指向右子节点
            }
            //比较右子节点与父节点的值，取最大值
            if (arr[k] > temp) {
                arr[i] = arr[k]; //将较大值赋给父节点
                i = k; //继续循环比较
            } else {
                break;
            }
        }
        //当for循环结束后，我们已经将以主为父结点的树的最大值，放在了最顶(局部)
        arr[i] = temp;
    }


    /**
     * 打印数组
     */
    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
