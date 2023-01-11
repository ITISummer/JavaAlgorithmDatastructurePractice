package practice.leetcode.easy;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree_110 {
    private static boolean isBalanced = true;
    public static boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        getDepth(root);
        return isBalanced;
    }

    private static int getDepth(TreeNode root){
        if(root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left-right)>1) {
            isBalanced=false;
        }
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        boolean res = isBalanced(root);
        System.out.println(res);
    }
}
