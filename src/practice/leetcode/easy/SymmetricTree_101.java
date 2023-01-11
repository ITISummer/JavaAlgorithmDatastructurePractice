package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/symmetric-tree/solutions/
 */
public class SymmetricTree_101 {
    /**
     * Recursion - DFS
     * @param root
     * @return
     */
    public static boolean isSymmetric_DFS(TreeNode root) {
        return root==null || preOrder(root.left,root.right);
    }
    public static boolean preOrder(TreeNode left,TreeNode right){
        if(left==null || right==null){
            return left==right;
        }
        if(left.val!=right.val) {
            return false;
        }
        return preOrder(left.left,right.right) && preOrder(left.right,right.left);
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public static boolean isSymmetric_BFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                // Retrieves and removes the head of this queue
                TreeNode curr = q.poll();

                if (curr == null) {
                    list.add(null);
                } else {
                    list.add(curr.val);
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }

            if (!checkSymmetry(list)) {
                return false;
            }
        }

        return true;
    }
    public static boolean checkSymmetry(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l++) != list.get(r--)) {
                return false;
            }
        }
        return true;
    }
}
