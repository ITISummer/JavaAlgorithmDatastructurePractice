package practice.leetcode.easy.array;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }//end main()


    /*
     * Test Data:
     * [1,1,2]--2
     * [0,0,1,1,1,2,2,3,3,4]--5
     * */
    public static int removeDuplicates(int[] nums) {
      
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[j] != nums[i])
                nums[++j] = nums[i++];
            else
                i++;
        }//end while
        return j + 1;
    }//end removeDuplicates()

}//end RemoveDuplicatesFromSortedArray_26
