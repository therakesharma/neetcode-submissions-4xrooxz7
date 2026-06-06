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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode first = queue.poll();
            int currIndex = map.get(first);

            if (currIndex <= res.size()) {
                res.get(currIndex - 1).add(first.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(first.val);
                res.add(list);
            }

            if (first.left != null) {
                map.put(first.left, currIndex + 1);
                queue.offer(first.left);
            }

            if (first.right != null) {
                map.put(first.right, currIndex + 1);
                queue.offer(first.right);
            }
        }

        return res;
        
    }
}
