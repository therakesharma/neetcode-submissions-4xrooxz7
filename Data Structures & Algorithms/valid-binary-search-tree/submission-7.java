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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<Object []> queue = new ArrayDeque<>();
        queue.offer(new Object[]{root, Long.MAX_VALUE, Long.MIN_VALUE});

        while (!queue.isEmpty()) {
            Object [] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            long max = (long) curr[1];
            long min = (long) curr[2];

            if (!(node.val < max && node.val > min)) {
                return false;
            }

            if (node.right != null) {
                queue.offer(new Object[]{node.right, max, (long) node.val});
            }
            if (node.left != null) {
                queue.offer(new Object[]{node.left, (long) node.val, min});
            }
        }
        return true;
        
    }
}
