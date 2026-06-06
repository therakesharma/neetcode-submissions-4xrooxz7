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
    public int goodNodes(TreeNode root) {
        int count = 0;
        Queue<Object []> queue = new ArrayDeque<>();
        Object [] arr = new Object[]{root, Integer.MIN_VALUE};
        queue.offer(arr);

        while (!queue.isEmpty()) {
            Object [] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            int max = (Integer) curr[1];

            if (node.val >= max) {
                count++;
            }
            if (node.left != null) {
                queue.offer(new Object[]{node.left, Math.max(node.val, max)});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, Math.max(node.val, max)});
            }
        }

        return count;
        
    }
}
