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
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxSum(node.left);
        int right = maxSum(node.right);
        int pathSum = node.val + Math.max(left, right);
        return Math.max(pathSum, 0);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int leftMax = maxSum(root.left);
        int rightMax = maxSum(root.right);
        res = Math.max(res, root.val + leftMax + rightMax);
        dfs(root.left);
        dfs(root.right);
    }
}
