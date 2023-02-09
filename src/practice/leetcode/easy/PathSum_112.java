package practice.leetcode.easy;

import practice.leetcode.TreeNode;

public class PathSum_112 {
    public boolean haspathsum(TreeNode root, int targetsum) {
        if (root == null) {
            return false;
        }
        targetsum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetsum == 0;
        }
        if (root.left != null) {
            boolean left = haspathsum(root.left, targetsum);
            // 已经找到
            if (left) {
                return true;
            }
        }
        if (root.right != null) {
            boolean right = haspathsum(root.right, targetsum);
            // 已经找到
            if (right) {
                return true;
            }
        }
        return false;
}
}
