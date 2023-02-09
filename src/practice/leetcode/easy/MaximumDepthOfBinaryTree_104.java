package practice.leetcode.easy;

import practice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 参考解法：
 * https://cloud.tencent.com/developer/article/1859061
 *
 * https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247491804&idx=2&sn=b23e425ab9169abb1dbf7208d9ac4a65&scene=21#wechat_redirect
 *
 * https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247491416&idx=1&sn=1a99afc9cb150f889f8005e0cc63c5fe&scene=21#wechat_redirect
 */
public class MaximumDepthOfBinaryTree_104 {
    /**
     * Recursion-simplified
     * @param root
     * @return
     */
    public static int maxDepth_1(TreeNode root) {
        if(root!=null) {
            return Math.max(maxDepth_1(root.left)+1, maxDepth_1(root.right)+1);
        }
        return 0;
    }

    /**
     * post-order traversal
     * @param root
     * @return
     */
    public static int maxDepth_2(TreeNode root) {
        if(root==null) {
            return 0;
        }
        // left
        int leftDepth = maxDepth_2(root.left);
        // right
        int rightDepth = maxDepth_2(root.right);
        // middle
        int depth = 1+Math.max(leftDepth,rightDepth);
        return depth;
    }

    private static int res = 0;
    /**
     * pre-order traversal
     * @param root
     * @return
     */
    public static int maxDepth_3(TreeNode root) {
        res = 0;
        if(root==null) {
            return res;
        }
        getDepth(root,1);
        return res;
    }
    private static void getDepth(TreeNode root, int depth) {
        // middle
        res = Math.max(depth, res);
        if (root.left==null && root.right==null) {
            return;
        }
        // left
        if(root.left!=null) {
//            depth++;
            getDepth(root.left,depth+1);
//            depth--;
        }
        // right
        if (root.right!=null) {
//            depth++;
            getDepth(root.right, depth+1);
//            depth--;
        }
    }

    /**
     * level-order traversal
     * @param root
     * @return
     */
    public static int maxDepth_4(TreeNode root) {
        if(root==null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        int size;
        TreeNode curr;
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                if(curr.left!=null) {
                    queue.offer(curr.left);
                }
                if(curr.right!=null) {
                    queue.offer(curr.right);
                }
            }
        }
        return depth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2));
        MaximumDepthOfBinaryTree_104.maxDepth_3(root);
//        System.out.println(res);
    }
}
