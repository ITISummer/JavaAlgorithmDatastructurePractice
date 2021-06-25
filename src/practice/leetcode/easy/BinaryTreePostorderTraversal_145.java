package practice.leetcode.easy;

import java.util.*;

/**
 * @ClassName BinaryTreePostorderTraversal_145
 * @Author LCX
 * @Date 2021 2021-06-22 1:45 p.m.
 * @Version 1.0
 **/
public class BinaryTreePostorderTraversal_145 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }

    /**
     * iterative
     * [二叉树的几种遍历递归与非递归java实现](https://blog.csdn.net/zlp1992/article/details/51406067)
     */
    public List<Integer> postorderTraversal_2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                ret.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(ret);
        return ret;
    }
}
