package practice.leetcode;

/**
 * @ClassName TreeNode
 * @Author LCX
 * @Date 2021 2021-06-22 12:22 p.m.
 * @Version 1.0
 **/

//Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
