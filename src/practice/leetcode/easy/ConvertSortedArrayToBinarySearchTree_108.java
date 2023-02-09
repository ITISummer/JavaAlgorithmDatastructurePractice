package practice.leetcode.easy;

import practice.leetcode.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree_108 {
    /**
     * Recursion
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST_1(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }
    private static TreeNode createBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l+r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums,l,mid-1);
        root.right = createBST(nums,mid+1,r);
        return root;
    }

    /**
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solutions/130516/java-recursive-and-iterative-solution/
     */
    private class Node {
        TreeNode node;
        int l;
        int h;
        public Node(TreeNode node, int l, int h) {
            this.node = node;
            this.l = l;
            this.h = h;
        }
    }
    /**
     * Iteration
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Stack<Node> nodeStack = new Stack<>();
        TreeNode root = new TreeNode(0);
        nodeStack.push(new Node(root, 0, nums.length - 1));
        while (!nodeStack.isEmpty()) {
            Node curNode = nodeStack.pop();
            TreeNode cur = curNode.node;
            int start = curNode.l;
            int end = curNode.h;
            int mid = start + (end - start) / 2;
            cur.val = nums[mid];

            if (mid - 1 >= start) {
                cur.left = new TreeNode(0);
                nodeStack.push(new Node(cur.left, start, mid - 1));
            }
            if (mid + 1 <= end) {
                cur.right = new TreeNode(0);
                nodeStack.push(new Node(cur.right, mid + 1, end));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST_1(nums);
    }
}
