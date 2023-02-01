package practice.leetcode.medium;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    /**
     * solution 1
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange_1(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums,target);
        int rightBorder = getRightBorder(nums,target);
        if(leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1,-1};
        }
        if(rightBorder-leftBorder>1) {
            return new int[]{leftBorder+1,rightBorder-1};
        }
        return new int[]{-1,-1};

    }
    public int getLeftBorder(int[] nums, int target) {
        int l = 0, r = nums.length-1, mid;
        int leftBorder = -2;
        while (l<=r) {
            mid = (l+r)/2;
            if(nums[mid]>=target) {
                r = mid-1;
                leftBorder = r;
            } else {
                l = mid + 1;
            }
        }
        return leftBorder;
    }

    public int getRightBorder(int[] nums, int target) {
        int l = 0, r = nums.length-1, mid;
        int rightBorder = -2;
        while (l<=r) {
            mid = (l+r)/2;
            if(nums[mid]>target) {
                r = mid-1;
            } else {
                l = mid + 1;
                rightBorder = l;
            }
        }
        return rightBorder;
    }


    /**
     * solution 2
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange_2(int[] nums, int target) {
        // 二分查找
        int index = binarySearch(nums, target);
        // nums 中不存在 target，直接返回 {-1, -1}
        if (index == -1) {
            // 匿名数组
            return new int[] {-1, -1};
        }
        // nums 中存在 targe，则左右滑动指针，来找到符合题意的区间
        int left = index;
        int right = index;
        // 向左滑动，找左边界
        // 防止数组越界。逻辑短路，两个条件顺序不能换
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) {
            left--;
        }
        // 向左滑动，找右边界
        // 防止数组越界。
        while (right + 1 < nums.length && nums[right + 1] == nums[index]) {
            right++;
        }
        return new int[] {left, right};
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        // 不变量：左闭右闭区间
        int right = nums.length - 1;
        // 不变量：左闭右闭区间
        while (left <= right) {
            // 等同于 (left+right)/2
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 不变量：左闭右闭区间
                right = mid - 1;
            }
        }
        return -1;
    }


    /**
     * solution 3
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange_3(int[] nums, int target) {
        int left = searchLeft(nums,target);
        int right = searchRight(nums,target);
        return new int[]{left,right};
    }
    public int searchLeft(int[] nums,int target){
        // 寻找元素第一次出现的地方
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            // >= 的都要缩小 因为要找第一个元素
            if(nums[mid]>=target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        // right = left - 1
        // 如果存在答案 right是首选
        if(right>=0&&right<nums.length&&nums[right]==target){
            return right;
        }
        if(left>=0&&left<nums.length&&nums[left]==target){
            return left;
        }
        return -1;
    }

    public int searchRight(int[] nums,int target){
        // 找最后一次出现
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            // <= 的都要更新 因为我们要找最后一个元素
            if(nums[mid]<=target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        // left = right + 1
        // 要找最后一次出现 如果有答案 优先找left
        if(left>=0&&left<nums.length&&nums[left]==target){
            return left;
        }
        if(right>=0&&right<=nums.length&&nums[right]==target){
            return right;
        }
        return -1;
    }
}
