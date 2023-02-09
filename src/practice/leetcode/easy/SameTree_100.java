package practice.leetcode.easy;

import practice.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/description/
 */
public class SameTree_100 {

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
