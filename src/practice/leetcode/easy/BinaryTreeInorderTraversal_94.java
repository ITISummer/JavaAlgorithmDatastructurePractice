package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BinaryTreeInorderTraversal_94
 * @Author LCX
 * @Date 2021 2021-06-22 12:12 p.m.
 * @Version 1.0
 **/


public class BinaryTreeInorderTraversal_94 {
    List<Integer> res = new ArrayList<>();

    /**
     * recursion
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }

    /**
     * iterative
     * [94.二叉树的中序遍历（非递归遍历）](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/94er-cha-shu-de-zhong-xu-bian-li-fei-di-gui-bian-l/)
     */
    public List<Integer> inorderTraversal_2(TreeNode root) {

        //相同点：大家都返回栈顶的值。不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        //本次循环的结果是：把根节点的左子树依次入栈
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        //判断最后一个入栈结点有没有右子树
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            res.add(node.val); // 访问根节点
            //没有右子树的话 判断这个点是不是上一节点的右子树
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();  //如果这个点是上一节点右子树，则这个点的上一节点也出栈
                }
            } else { //有右子树的话，右子树入栈，再遍历左子树
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return res;
    }
}
