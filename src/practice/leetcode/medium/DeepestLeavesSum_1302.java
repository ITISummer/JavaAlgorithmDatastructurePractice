package practice.leetcode.medium;

/**
 * @ClassName DeepestLeavesSum_1302
 * @Author LCX
 * @Date 2021 2021-06-23 5:16 p.m.
 * @Version 1.0
 **/
public class DeepestLeavesSum_1302 {
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        int depth = findDepth(root);
        findSum(root, 1, depth);
        return sum;
    }

    public int findDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    public void findSum(TreeNode root, int currDepth, int depth) {
        if (root != null) {
            if (currDepth == depth) {
                sum += root.val;
            }
            findSum(root.left, currDepth + 1, depth);
            findSum(root.right, currDepth + 1, depth);
        }
    }
}
