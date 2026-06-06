/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getBST(root)[0] == 1;    
    }

    public int[] getBST(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int [] left = getBST(root.left);
        int [] right = getBST(root.right);
        int balanced = (left[0] == 1 && right[0] == 1) ? 1 : 0;
        if (Math.abs(left[1] - right[1]) > 1) {
            balanced = 0;
        }

        return new int[]{balanced, 1 + Math.max(left[1], right[1])};

    }
}
