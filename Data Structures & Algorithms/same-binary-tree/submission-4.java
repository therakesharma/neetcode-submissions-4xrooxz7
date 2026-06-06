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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<List<TreeNode>> tree = new ArrayDeque<>();
        tree.offer(Arrays.asList(new TreeNode[]{p, q}));

        while (!tree.isEmpty()) {
            List<TreeNode> pair = tree.poll();
            TreeNode first = pair.get(0);
            TreeNode second = pair.get(1);

            if (first == null && second != null) return false;
            if (first != null && second == null) return false;
            if (first != null && second != null && first.val !=  second.val) return false;

            if (first != null && second != null) {
                tree.offer(Arrays.asList(new TreeNode[]{first.left, second.left}));
                tree.offer(Arrays.asList(new TreeNode[]{first.right, second.right}));
            }

        }

        return true;
        
    }
}
