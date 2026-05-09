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
    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }

    public int depth(TreeNode node, int curr) {
        if (node == null) {
            return curr;
        }
        curr = curr + 1;
        return Math.max(depth(node.left, curr), depth(node.right, curr));
    }
}