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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> tree = new ArrayDeque<>();
        tree.offer(root);
        while (!tree.isEmpty()) {
            TreeNode curr = tree.poll();
            if (curr.val == subRoot.val && validate(curr, subRoot)) {
                return true;
            }
            if (curr.left != null) {
                tree.offer(curr.left);
            }
            if (curr.right != null) {
                tree.offer(curr.right);
            }
        }
        return false;

    }

    public boolean validate(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }

        return validate(root.left, subRoot.left) && validate(root.right, subRoot.right);
    }
}
