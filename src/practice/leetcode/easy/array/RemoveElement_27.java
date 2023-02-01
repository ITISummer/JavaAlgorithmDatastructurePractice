package practice.leetcode.easy.array;

/**
 * https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length-1;
        while (l<r) {
            while (l<r && nums[l] != val) {
                l++;
            }
            while (l<r && nums[r] == val) {
                r--;
            }
            if(l<r) {
                nums[l++] = nums[r--];
            }
//            swap(nums,l,r);
        }
        return l;
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


    public int removeElement_1(int[] nums, int val) {
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
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
}
