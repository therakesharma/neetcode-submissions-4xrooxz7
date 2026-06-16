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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public List<Integer> dfs(TreeNode node, List<Integer> res, int lvl) {
        if (node == null) {
            return res;
        }
        if (lvl == res.size()) {
            res.add(node.val);
        }
        dfs(node.right, res, lvl + 1);
        dfs(node.left, res, lvl + 1);

        return res;
    }
}