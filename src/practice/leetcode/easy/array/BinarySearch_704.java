package practice.leetcode.easy.array;

/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch_704 {
    /**
     * while loop
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1, mid;
        while (l<=r) {
            mid = (l+r)/2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }

    /**
     * recursion
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public int search_2(int[] nums, int target, int left, int right) {
        if(left>right) {
            return -1;
        }
        int mid = (left+right)/2;
        if(nums[mid]==target) {
            return mid;
        } else if(nums[mid] > target) {
            return search_2(nums,target,left,mid-1);
        } else {
            return search_2(nums,target,mid+1,right);
        }
    }
}
