package practice.leetcode.数组.快慢指针;

/**
 * https://leetcode.com/problems/remove-element/description/
 */
public class Easy_27_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3}; // 少返回
//        int[] nums = {3}; // 多返回
//        int[] nums = {3,3}; // 多返回
        removeElement(nums,3);
    }

    /**
     * 有问题
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if(nums[l] == val) {
                nums[l] = nums[r--];
            }else{
                l++;
            }
        }
        return l;
    }
    
    public static int removeElement_0(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if(nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }


    public int removeElement_1(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public int removeElement_2(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            // 发现需要移除的元素，就将数组集体向前移动一位
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                i--;
                // 此时数组的大小-1
                size--;
            }
        }
        return size;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private void swap_1(int[] nums, int l, int r) {
        nums[l] = nums[l] + nums[r];
        nums[r] = nums[l] - nums[r];
        nums[l] = nums[l] - nums[r];
    }

    private void swap_2(int[] nums, int l, int r) {
        nums[l] = nums[l] ^ nums[r];
        nums[r] = nums[l] ^ nums[r];
        nums[l] = nums[l] ^ nums[r];
    }
}

