package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree_111 {
    public static int minDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        int size;
        TreeNode node;
        boolean flag = false;
        while (!queue.isEmpty()) {
            depth++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if(node.left==null&&node.right==null) {
                    flag = true;
                    break;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (flag) {
                break;
            }
        }
        return depth;
    }

    /**
     * post-order traversal
     * @param root
     * @return
     */
    public int minDepth_2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = minDepth_2(root.left);
        int rightDepth = minDepth_2(root.right);
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left == null) {
            return 1 + rightDepth;
        }
        if(root.right == null) {
            return 1 + leftDepth;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * post-order traversal
     * @param root
     * @return
     */
    public int minDepth_3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = minDepth_3(root.left);
        int right = minDepth_3(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    private static int res = Integer.MAX_VALUE;
    /**
     * pre-order traversal
     * @param root
     * @return
     */
    public static int minDepth_4(TreeNode root) {
        if (root==null) {
            return 0;
        }
        getDepth(root,1);
        return res;
    }

    private static void getDepth(TreeNode node, int depth) {
        if (node.left==null && node.right==null) {
            res = Math.min(depth,res);
            return;
        }
        if (node.left != null) {
            getDepth(node.left,depth+1);
        }
        if (node.right != null) {
            getDepth(node.right,depth+1);
        }
    }


}
