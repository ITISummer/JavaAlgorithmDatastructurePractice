package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BinaryTreePreorderTraversal_144
 * @Author LCX
 * @Date 2021 2021-06-22 12:21 p.m.
 * @Version 1.0
 **/
public class BinaryTreePreorderTraversal_144 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }

    /**
     * 非递归先序遍历二叉树
     * [二叉树的几种遍历递归与非递归java实现](https://blog.csdn.net/zlp1992/article/details/51406067)
     */
    public List<Integer> preorderTraversal_2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        if (root == null) //如果为空树则返回
            return resultList;
        treeStack.push(root);
        while (!treeStack.isEmpty()) {
            TreeNode tempNode = treeStack.pop();
            if (tempNode != null) {
                resultList.add(tempNode.val);//访问根节点
                treeStack.push(tempNode.right); //入栈右孩子
                treeStack.push(tempNode.left);//入栈左孩子
            }
        }
        return resultList;
    }
}
