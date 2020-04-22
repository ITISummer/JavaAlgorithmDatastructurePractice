package algorithm.binarysearchnorecursion;

/**
 * 二分查找算法-非递归实现
 */
public class BinarySearchNoCur {
    public static void main(String[] args) {
        int[] arr = {11,23,31,43,67,79,97};
//        int pos = binarySearchNoCur(arr,97);
//        System.out.println(pos);
        int pos = binarySearchByCur(arr,0,arr.length - 1,97);
        System.out.println(pos);

    }

    /**
     *
     * @param arr 需要查找的有序（升序）数组
     * @param target 目标
     * @return
     */
    public static int binarySearchNoCur(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            } //end if...else
        } //end while
        return -1;
    } //end binarySearch()
    /**
     *
     * @param arr 需要查找的有序（升序）数组
     * @param target 目标
     * @return
     */
    public static int binarySearchByCur(int[] arr, int low, int high, int target) {
        if (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] > target) {
                return binarySearchByCur(arr,low,mid - 1,target);
            } else if (arr[mid] < target){
                return binarySearchByCur(arr,mid + 1,high,target);
            } else {
                return mid;
            } //end if...else
        } //end if
        return -1;
    } //end binarySearch()
}
