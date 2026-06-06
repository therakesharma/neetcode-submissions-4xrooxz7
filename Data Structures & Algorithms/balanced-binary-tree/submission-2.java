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
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lHeight = height(node.left);
        int rHeight = height(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }


}
