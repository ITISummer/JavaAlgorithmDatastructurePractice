package practice.leetcode.easy;

/**
 * https://leetcode.com/problems/same-tree/description/
 */
public class SameTree_100 {
    /**
     * Definition for a binary tree node.
     */
     private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    /**
     * Recursion
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
         if(p==null&&q==null) {
             return true;
         }
         if(p==null||q==null) {
            return false;
         }
         return (p.val==q.val)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
