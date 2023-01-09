package practice.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray_88 {
    /**
     * simple simulation using another Array buffer
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[] res = new int[m+n];
        while (i<m&&j<n){
            if(nums1[i]<=nums2[j]) {
                res[k]=nums1[i++];
            }else {
                res[k]=nums2[j++];
            }
            k++;
        }
        while (i<m) {
            res[k++] = nums1[i++];
        }
        while (j<n) {
            res[k++] = nums2[j++];
        }
//        nums1 = res;
        for(int i1 = 0; i1<k;i1++) {
            nums1[i1] = res[i1];
        }
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * merge two arrays from backwards without using another array buffer
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1,j = n-1;
        while (i>=0&&j>=0) {
            if(nums1[i]>=nums2[j]) {
                nums1[i+j+1] = nums1[i--];
            } else {
                nums1[i+j+1] = nums2[j--];
            }
        }
        while (j>=0) {
            nums1[j] = nums2[j--];
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        int[] nums1 = {0};
//        int[] nums2 = {1};
        int[] nums1 = {0};
        int[] nums2 = {1};
//        MergeSortedArray_88.merge_1(nums1,0,nums2,1);
        MergeSortedArray_88.merge_2(nums1,0,nums2,1);
    }
}
