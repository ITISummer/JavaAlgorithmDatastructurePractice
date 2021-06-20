package practice.leetcode.easy;


/**
 * @ClassName RangeSumBST_938
 * @Author LCX
 * @Date 2021 2021-06-20 12:24 p.m.
 * @Version 1.0
 **/
public class RangeSumBST_938 {

    //  Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int sum = 0;

    public void sumBST(TreeNode root, int low, int high) {
        if (root != null) {
            if (low <= root.val && root.val <= high) {
                sum += root.val;
                sumBST(root.left, low, high);
                sumBST(root.right, low, high);
            } else if (root.val < low) { // pruning
                sumBST(root.right, low, high);
            } else { // pruning
                sumBST(root.left, low, high);
            }
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        sumBST(root, low, high);
        return sum;
    }
}
