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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode parent = root;
        while (!queue.isEmpty()) {
            parent = queue.poll();
            if (parent.val > p.val && parent.val > q.val && parent.left != null) {
                //parent = node;
                queue.offer(parent.left);
            } else if (parent.val < p.val && parent.val < q.val && parent.right != null) {
                //parent = node;
                queue.offer(parent.right);
            } else {
                break;
            }
        }
        return parent;
    }
}
