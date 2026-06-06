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
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return res;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int diameter = height(root.left) + height(root.right);
        res = Math.max(res, diameter);

        return Math.max(height(root.left), height(root.right)) + 1;
    }


}
